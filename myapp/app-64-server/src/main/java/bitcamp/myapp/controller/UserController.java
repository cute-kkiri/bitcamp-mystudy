package bitcamp.myapp.controller;

import bitcamp.myapp.service.StorageService;
import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private StorageService storageService;

    private String folderName = "user/";

    public UserController(UserService userService, StorageService storageService) {
        this.userService = userService;
        this.storageService = storageService;
    }

    @GetMapping("form")
    public String form() {
        return "user/form";
    }

    @PostMapping
    public String add(User user, MultipartFile file) throws Exception {

        // 클라이언트가 보낸 파일을 저장할 때 다른 파일 이름과 충돌나지 않도록 임의의 새 파일 이름을 생성한다.
        String filename = UUID.randomUUID().toString();

        HashMap<String, Object> options = new HashMap<>();
        options.put(StorageService.CONTENT_TYPE, file.getContentType());
        storageService.upload(
                folderName + filename,
                file.getInputStream(),
                options
        );

        user.setPhoto(filename); // DB에 저장할 사진 파일 이름 설정

        userService.add(user);
        return "redirect:../users";
    }

    @GetMapping
    public String list(Model model) throws Exception {
        List<User> list = userService.list();
        model.addAttribute("list", list);
        return "user/list";
    }

    @GetMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        User user = userService.get(no);
        model.addAttribute("user", user);
        return "user/view";
    }

    @PostMapping("{no}")
    public String update(
            @PathVariable int no, User user, MultipartFile file) throws Exception {

        user.setNo(no);

        User old = userService.get(no);

        if (file != null && file.getSize() > 0) {
            storageService.delete(folderName + old.getPhoto());

            String filename = UUID.randomUUID().toString();

            HashMap<String, Object> options = new HashMap<>();
            options.put(StorageService.CONTENT_TYPE, file.getContentType());
            storageService.upload(
                    folderName + filename,
                    file.getInputStream(),
                    options
            );

            user.setPhoto(filename);
        } else {
            user.setPhoto(old.getPhoto());
        }
        if (userService.update(user)) {
            return "redirect:../users";
        } else {
            throw new Exception("없는 회원입니다!");
        }
    }

    @Transactional
    @DeleteMapping("{no}")
    @ResponseBody
    public String delete(
            @PathVariable int no) throws Exception {

        User old = userService.get(no);

        if (userService.delete(no)) {
            storageService.delete(folderName + old.getPhoto());
            return "success";
        } else {
            return "failure";
        }
    }
}
