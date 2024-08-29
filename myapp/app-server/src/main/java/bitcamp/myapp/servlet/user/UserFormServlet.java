package bitcamp.myapp.servlet.user;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/form")
public class UserFormServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();

        req.getRequestDispatcher("/header").include(req, res);

        out.println("<h1>회원 등록</h1>");
        out.println("<form action='/user/add'>");
        out.println("    이름: <input name='name' type='text' /><br />");
        out.println("    이메일: <input name='email' type='email' /><br />");
        out.println("    암호: <input name='password' type='password' /><br />");
        out.println("    연락처: <input name='tel' type='tel' /><br />");
        out.println("    <input type='submit' value='등록' />");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}
