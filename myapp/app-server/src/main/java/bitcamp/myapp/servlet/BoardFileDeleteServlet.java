package bitcamp.myapp.servlet;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/board/file/delete")
public class BoardFileDeleteServlet extends HttpServlet {

    private BoardDao boardDao;
    private SqlSessionFactory sqlSessionFactory;
    private String uploadDir;

    @Override
    public void init() throws ServletException {
        this.boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
        this.sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");
        this.uploadDir = this.getServletContext().getRealPath("/upload/board");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            User loginUser = (User) ((HttpServletRequest) req).getSession().getAttribute("loginUser");
            if (loginUser == null) {
                throw new Exception("로그인 하지 않았습니다.");
            }

            int fileNo = Integer.parseInt(req.getParameter("fileNo"));
            AttachedFile attachedFile = boardDao.getFile(fileNo);
            if (attachedFile == null) {
                throw new Exception("없는 첨부파일입니다.");
            }
            Board board = boardDao.findBy(attachedFile.getBoardNo());

            if (loginUser.getNo() > 10 && board.getWriter().getNo() != loginUser.getNo()) {
                throw new Exception("삭제 권한이 없습니다.");
            }

            File file = new File(uploadDir + "/" + attachedFile.getFilename());
            if (file.exists()) {
                file.delete();
            }
            
            boardDao.deleteFile(fileNo);
            sqlSessionFactory.openSession(false).commit();
            res.sendRedirect("/board/view?no=" + req.getParameter("boardNo"));

        } catch (Exception e) {
            sqlSessionFactory.openSession(false).rollback();
            req.setAttribute("exception", e);
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }
}
