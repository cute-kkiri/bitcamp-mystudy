package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/board/view")
public class BoardViewServlet extends GenericServlet {

    private BoardDao boardDao;
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void init() throws ServletException {
        // 서블릿 컨테이너 ---> init(ServletConfig) ---> init() 호출한다.
        boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
        sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();

        req.getRequestDispatcher("/header").include(req, res);

        try {
            out.println("<h1>게시글 조회</h1>");

            int boardNo = Integer.parseInt(req.getParameter("no"));

            Board board = boardDao.findBy(boardNo);
            if (board == null) {
                out.println("<p>없는 게시글입니다.</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            board.setViewCount(board.getViewCount() + 1);
            boardDao.updateViewCount(board.getNo(), board.getViewCount());
            sqlSessionFactory.openSession(false).commit();

            out.println("<form action='/board/update'>\n");
            out.printf("    번호: <input name='no' readonly type='text' value='%d'><br>\n", board.getNo());
            out.printf("    제목: <input type='text' name='title' value='%s'><br>\n", board.getTitle());
            out.printf("    내용: <textarea cols='30' name='content' rows='10'>%s</textarea><br>\n", board.getContent());
            out.printf("    작성일: <input readonly type='text' value='%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS'><br>\n", board.getCreatedDate());
            out.printf("    조회수: <input readonly type='text' value='%d'><br>\n", board.getViewCount());
            out.printf("    작성자: <input readonly type='text' value='%s'><br>\n", board.getWriter().getName());
            out.println("   <button>변경</button>\n");
            out.printf("   <button type='button' onclick='location.href=\"/board/delete?no=%d\"'>삭제</button>\n", board.getNo());
            out.println("</form>");

        } catch (Exception e) {
            sqlSessionFactory.openSession(false).rollback();
            out.println("<p>조회 중 오류 발생!</p>");
            e.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");
    }
}
