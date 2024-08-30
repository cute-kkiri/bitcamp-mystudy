package bitcamp.myapp.servlet;

import bitcamp.myapp.vo.User;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/header")
public class HeaderServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Title</title>");
        out.println("    <link href='/css/common.css' rel='stylesheet' />");
        out.println("</head>");
        out.println("<body>");

        out.println("<header>");
        out.println("   <a href='/'><img alt='home' src='/images/home.png' /></a>");
        out.println("   <h1>프로젝트 관리 시스템</h1>");
        out.println("   <nav>");
        out.println("       <ul>");
        out.println("        <li class='btn btn-default'><a href='/user/list'>회원</a></li>");
        out.println("        <li class='btn btn-default'><a href='/project/list'>프로젝트</a></li>");
        out.println("        <li class='btn btn-default'><a href='/board/list'>게시글</a></li>");
        out.println("       </ul>");
        out.println("   </nav>");

        User loginUser = (User) ((HttpServletRequest) req).getSession().getAttribute("loginUser");
        out.println("<div class='login-state pos-right'>");
        if (loginUser == null) {
            out.println("   <a href='/auth/form' class='btn btn-primary'>로그인</a>");
        } else {
            out.printf("    <a href='/user/view?no=%d' class='btn btn-light'>%s</p>\n", loginUser.getNo(), loginUser.getName());
            out.println("   <a href='/auth/logout' class='btn btn-secondary'>로그아웃</a>");
        }
        out.println("</div>");

        out.println("</header>");
    }
}
