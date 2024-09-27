package bitcamp.myapp.controller;

import bitcamp.myapp.service.BoardService;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BoardController {

    private AmazonS3 s3;
    private BoardService boardService;
    private String uploadDir;

    @Value("${ncp.storage.bucketname}")
    private String bucketName;

    private String folderName = "board/";

    public BoardController(
            BoardService boardService, ServletContext ctx,
            @Value("${ncp.storage.endpoint}") String endPoint,
            @Value("${ncp.storage.regionName}") String regionName,
            @Value("${ncp.accessKey}") String accessKey,
            @Value("${ncp.secretKey}") String secretKey
    ) {
        this.boardService = boardService;
        this.uploadDir = ctx.getRealPath("/upload/board");

        // S3 client
        this.s3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();
    }

    @GetMapping("/board/form")
    public void form() {
    }

    @PostMapping("/board/add")
    public String add(
            Board board,
            MultipartFile[] files,
            HttpSession session) throws Exception {

        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            throw new Exception("로그인 하지 않았습니다.");
        }

        board.setWriter(loginUser);

        ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file.getSize() == 0) {
                continue;
            }

            AttachedFile attachedFile = new AttachedFile();
            attachedFile.setFilename(UUID.randomUUID().toString());
            attachedFile.setOriginFilename(file.getOriginalFilename());

            // 첨부파일을 Object Storage에 올린다.
            try {
                // Object Storage에 업로드할 콘텐츠의 요청 정보를 준비함
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentType(file.getContentType()); // 콘텐츠의 MIME Type 정보를 설정함

                PutObjectRequest putObjectRequest = new PutObjectRequest(
                        bucketName, // 업로드할 버킷 이름
                        folderName + attachedFile.getFilename(), // 업로드 파일의 경로(폴더 경로 포함)
                        file.getInputStream(), // 업로드 파일 데이터를 읽어들일 입력 스트림
                        objectMetadata // 업로드 파일의 부가 정보
                ).withCannedAcl(CannedAccessControlList.PublicRead);

                s3.putObject(putObjectRequest);

            } catch (Exception e) {
                e.printStackTrace(); // 서버 콘솔창에 예외 정보를 출력한 후 게시글 등록을 취소한다.
                throw e;
            }

            attachedFiles.add(attachedFile);
        }

        board.setAttachedFiles(attachedFiles);

        boardService.add(board);
        return "redirect:list";
    }

    @GetMapping("/board/list")
    public void list(Model model) throws Exception {
        List<Board> list = boardService.list();
        model.addAttribute("list", list);
    }

    @GetMapping("/board/view")
    public void view(int no, Model model) throws Exception {
        Board board = boardService.get(no);
        if (board == null) {
            throw new Exception("게시글이 존재하지 않습니다.");
        }

        boardService.increaseViewCount(board.getNo());

        model.addAttribute("board", board);
    }

    @PostMapping("/board/update")
    public String update(
            int no,
            String title,
            String content,
            Part[] files,
            HttpSession session) throws Exception {

        User loginUser = (User) session.getAttribute("loginUser");

        Board board = boardService.get(no);
        if (board == null) {
            throw new Exception("없는 게시글입니다.");
        } else if (loginUser == null || loginUser.getNo() > 10 && board.getWriter().getNo() != loginUser.getNo()) {
            throw new Exception("변경 권한이 없습니다.");
        }

        board.setTitle(title);
        board.setContent(content);

        ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

        for (Part part : files) {
            if (part.getSize() == 0) {
                continue;
            }

            AttachedFile attachedFile = new AttachedFile();
            attachedFile.setFilename(UUID.randomUUID().toString());
            attachedFile.setOriginFilename(part.getSubmittedFileName());

            part.write(this.uploadDir + "/" + attachedFile.getFilename());

            attachedFiles.add(attachedFile);
        }

        board.setAttachedFiles(attachedFiles);

        boardService.update(board);
        return "redirect:list";
    }

    @GetMapping("/board/delete")
    public String delete(
            int no,
            HttpSession session) throws Exception {

        User loginUser = (User) session.getAttribute("loginUser");
        Board board = boardService.get(no);

        if (board == null) {
            throw new Exception("없는 게시글입니다.");
        } else if (loginUser == null || loginUser.getNo() > 10 && board.getWriter().getNo() != loginUser.getNo()) {
            throw new Exception("삭제 권한이 없습니다.");
        }

        for (AttachedFile attachedFile : board.getAttachedFiles()) {
            File file = new File(uploadDir + "/" + attachedFile.getFilename());
            if (file.exists()) {
                file.delete();
            }
        }

        boardService.delete(no);
        return "redirect:list";
    }

    @GetMapping("/board/file/delete")
    public String fileDelete(
            HttpSession session,
            int fileNo,
            int boardNo) throws Exception {

        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            throw new Exception("로그인 하지 않았습니다.");
        }

        AttachedFile attachedFile = boardService.getAttachedFile(fileNo);
        if (attachedFile == null) {
            throw new Exception("없는 첨부파일입니다.");
        }

        Board board = boardService.get(attachedFile.getBoardNo());
        if (loginUser.getNo() > 10 && board.getWriter().getNo() != loginUser.getNo()) {
            throw new Exception("삭제 권한이 없습니다.");
        }

        File file = new File(uploadDir + "/" + attachedFile.getFilename());
        if (file.exists()) {
            file.delete();
        }

        boardService.deleteAttachedFile(fileNo);
        return "redirect:../view?no=" + boardNo;
    }

}
