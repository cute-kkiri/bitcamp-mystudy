package bitcamp.myapp.command.board;

import bitcamp.command.Command;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;
import bitcamp.net.Prompt;
import org.apache.ibatis.session.SqlSession;

public class BoardAddCommand implements Command {

    private BoardDao boardDao;
    private SqlSession sqlSession;

    public BoardAddCommand(BoardDao boardDao, SqlSession sqlSession) {

        this.boardDao = boardDao;
        this.sqlSession = sqlSession;
    }

    @Override
    public void execute(String menuName, Prompt prompt) {
        System.out.printf("[%s]\n", menuName);
        try {
            Board board = new Board();
            board.setTitle(prompt.input("제목?"));
            board.setContent(prompt.input("내용?"));
            board.setWriter((User) prompt.getAttribute("loginUser"));

            boardDao.insert(board);
            sqlSession.commit();

        } catch (Exception e) {
            sqlSession.rollback();
            prompt.println("등록 중 오류 발생!");
            e.printStackTrace();
        }
    }

}
