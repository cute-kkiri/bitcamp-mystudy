package bitcamp.myapp.servlet.user;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/user/view")
public class UserViewServlet extends GenericServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        // 서블릿 컨테이너 ---> init(ServletConfig) ---> init() 호출한다.
        userDao = (UserDao) this.getServletContext().getAttribute("userDao");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            int userNo = Integer.parseInt(req.getParameter("no"));
            User user = userDao.findBy(userNo);
            req.setAttribute("user", user);

            res.setContentType("text/html;charset=UTF-8");
            req.getRequestDispatcher("/user/view.jsp").include(req, res);

        } catch (Exception e) {
            req.setAttribute("exception", e);
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }
}
