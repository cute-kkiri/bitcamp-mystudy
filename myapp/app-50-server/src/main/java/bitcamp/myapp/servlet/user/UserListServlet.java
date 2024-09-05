package bitcamp.myapp.servlet.user;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/list")
public class UserListServlet extends GenericServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) this.getServletContext().getAttribute("userDao");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            List<User> list = userDao.list();

            // 콘텐트 타입은 include() 호출 전에 실행해야 한다.
            res.setContentType("text/html;charset=UTF-8");

            // 콘텐트 출력은 JSP에 맡긴다.
            req.setAttribute("list", list); // JSP를 실행하기 전에 JS가 사용할 객체를 ServletRequest 보관소에 보관한다.
            req.getRequestDispatcher("/user/list.jsp").include(req, res);

        } catch (Exception e) {
            req.setAttribute("exception", e);
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }

    }
}
