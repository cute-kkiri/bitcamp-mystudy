package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/project/form")
public class ProjectFormServlet extends GenericServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) this.getServletContext().getAttribute("userDao");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();

        req.getRequestDispatcher("/header").include(req, res);

        try {
            out.println("<h1>프로젝트 등록</h1>\n");
            out.println("<form action='/project/add'>\n");
            out.println("    프로젝트명: <input name='title' type='text' /><br />\n");
            out.println("    설명: <textarea name='description'></textarea><br />\n");
            out.println("    시작일: <input name='startDate' type='date' /><br />\n");
            out.println("    종료일: <input name='endDate' type='date' /><br />\n");
            out.println("    팀원: <br />\n");

            out.println("     <ul>");
            List<User> users = userDao.list();
            for (User user : users) {
                out.printf("  <li><input name='member' value='%d' type='checkbox' />%s</li>", user.getNo(), user.getName());
            }
            out.println("     </ul>");

            out.println("    <input type='submit' value='등록' />\n");
            out.println("</form>");


        } catch (Exception e) {
            out.println("<p>조회 중 오류 발생!</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
