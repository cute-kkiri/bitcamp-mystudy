package bitcamp.myapp.command.board;

import bitcamp.command.Command;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;
import bitcamp.net.Prompt;
import org.apache.ibatis.session.SqlSession;

public class BoardUpdateCommand implements Command {

    private BoardDao boardDao;
    private SqlSession sqlSession;

    public BoardUpdateCommand(BoardDao boardDao, SqlSession sqlSession) {

        this.boardDao = boardDao;
        this.sqlSession = sqlSession;
    }

    @Override
    public void execute(String menuName, Prompt prompt) {
        try {
            User loginUser = (User) prompt.getAttribute("loginUser");

            prompt.printf("[%s]\n", menuName);
            int boardNo = prompt.inputInt("게시글 번호?");

            try {
                Board board = boardDao.findBy(boardNo);
                if (board == null) {
                    prompt.println("없는 게시글입니다.");
                    return;
                } else if (loginUser.getNo() > 10 && board.getWriter().getNo() != loginUser.getNo()) {
                    prompt.println("변경 권한이 없습니다.");
                    return;
                }

                board.setTitle(prompt.input("제목(%s)?", board.getTitle()));
                board.setContent(prompt.input("내용(%s)?", board.getContent()));

                boardDao.update(board);
                sqlSession.commit();
                prompt.println("변경 했습니다.");

            } catch (Exception e) {
                sqlSession.rollback();
                prompt.println("변경 중 오류 발생!");
                e.printStackTrace();
            }
        } catch (Exception e) {

        }

    }
}
