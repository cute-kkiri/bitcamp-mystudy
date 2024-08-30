package bitcamp.myapp.servlet.auth;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth/form")
public class LoginFormServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();

        req.getRequestDispatcher("/header").include(req, res);

        out.println("<h1>로그인</h1>\n");
        out.println("<form action='/auth/login'>\n");
        out.println("    이메일: <input name='email' type='email' /><br />\n");
        out.println("    암호: <input name='password' type='password' /><br />\n");
        out.println("    <input type='submit' value='로그인' />\n");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}
