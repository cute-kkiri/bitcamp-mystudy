package bitcamp.myapp.servlet.user;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {

  private UserDao userDao;

  @Override
  public void init() {
    userDao = (UserDao) this.getServletContext().getAttribute("userDao");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      List<User> list = userDao.list();

      // 콘텐트 출력은 JSP에 맡긴다.
      req.setAttribute("list", list); // JSP를 실행하기 전에 JSP가 사용할 객체를 ServletRequest 보관소에 보관한다.

      // 콘텐트 타입은 include() 호출 전에 실행해야 한다.
      res.setContentType("text/html;charset=UTF-8");
      req.getRequestDispatcher("/user/list.jsp").include(req, res);

    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
  }
}
