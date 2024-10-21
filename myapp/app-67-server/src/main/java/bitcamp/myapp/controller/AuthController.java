package bitcamp.myapp.controller;


import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 의존객체 final은 무조건 생성자로 받아야하기 때문에 lombok에서 제공하는 기능으로 생성자를 생성.
@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {

    // 의존객체는 무조건 final로 생성.
    private final UserService userService;

    @GetMapping("form")
    public void form() {
    }

    @PostMapping("login")
    public String login(
            String email,
            String password,
            boolean saveEmail,
            HttpServletResponse res,
            HttpSession session) throws Exception {

        User user = userService.exists(email, password);
        if (user == null) {
            res.setHeader("Refresh", "2; url=form");
            return "auth/fail";
        }

        if (saveEmail) {
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            res.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("email", "test@test.com");
            cookie.setMaxAge(0);
            res.addCookie(cookie);
        }

        session.setAttribute("loginUser", user);
        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
