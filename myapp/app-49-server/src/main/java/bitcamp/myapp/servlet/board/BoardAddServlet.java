package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/board/add")
public class BoardAddServlet extends GenericServlet {

    private BoardDao boardDao;
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void init() throws ServletException {
        ServletContext ctx = this.getServletContext();

        this.boardDao = (BoardDao) ctx.getAttribute("boardDao");
        this.sqlSessionFactory = (SqlSessionFactory) ctx.getAttribute("sqlSessionFactory");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();

        req.getRequestDispatcher("/header").include(req, res);

        try {
            out.println("<h1>게시글 등록</h1>");
            Board board = new Board();
            board.setTitle(req.getParameter("title"));
            board.setContent(req.getParameter("content"));

            // 클라이언트 전용 보관소에서 로그인 사용자 정보를 꺼낸다.
            User loginUser = (User) ((HttpServletRequest) req).getSession().getAttribute("loginUser");

            board.setWriter(loginUser);

            boardDao.insert(board);
            sqlSessionFactory.openSession(false).commit();
            out.println("<p>등록 성공입니다.</p>");

        } catch (Exception e) {
            sqlSessionFactory.openSession(false).rollback();
            out.println("<p>등록 중 오류 발생!</p>");
            e.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");

        ((HttpServletResponse) res).setHeader("Refresh", "1;url=/board/list");
    }

}
