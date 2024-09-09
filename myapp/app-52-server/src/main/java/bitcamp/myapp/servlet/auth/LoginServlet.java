package bitcamp.myapp.servlet.auth;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

  private UserDao userDao;

  @Override
  public void init() throws ServletException {
    userDao = (UserDao) this.getServletContext().getAttribute("userDao");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    req.getRequestDispatcher("/auth/form.jsp").include(req, res);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      String email = req.getParameter("email");
      String password = req.getParameter("password");

      User user = userDao.findByEmailAndPassword(email, password);
      if (user == null) {
        ((HttpServletResponse) res).setHeader("Refresh", "1;url=/auth/form");
        res.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/auth/fail.jsp").include(req, res);
        return;
      }

      if (req.getParameter("saveEmail") != null) {
        Cookie cookie = new Cookie("email", email);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        res.addCookie(cookie);
      } else {
        Cookie cookie = new Cookie("email", "test@test.com");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
      }

      HttpServletRequest httpReq = (HttpServletRequest) req;
      HttpSession session = httpReq.getSession();
      session.setAttribute("loginUser", user);
      res.sendRedirect("/");

    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
  }
}
