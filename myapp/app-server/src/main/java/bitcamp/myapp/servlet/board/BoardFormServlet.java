package bitcamp.myapp.servlet.board;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/board/form")
public class BoardFormServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();

        req.getRequestDispatcher("/header").include(req, res);

        out.println("<h1>게시글 등록</h1>");
        out.println("<form action='/board/add'>");
        out.println("    제목: <input name='title' type='text' /><br />");
        out.println("    내용: <textarea cols='30' name='content' rows='10'></textarea><br />");
        out.println("    <input type='submit' value='등록' />");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}
