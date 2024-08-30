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
        try {
            int boardNo = Integer.parseInt(req.getParameter("no"));

            Board board = boardDao.findBy(boardNo);

            res.setContentType("text/html;charset=UTF-8");

            if (board != null) {
                board.setViewCount(board.getViewCount() + 1);
                boardDao.updateViewCount(board.getNo(), board.getViewCount());
                sqlSessionFactory.openSession(false).commit();
            }

            req.setAttribute("board", board);
            req.getRequestDispatcher("/board/view.jsp").include(req, res);


        } catch (Exception e) {
            req.setAttribute("exception", e);
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }
}
