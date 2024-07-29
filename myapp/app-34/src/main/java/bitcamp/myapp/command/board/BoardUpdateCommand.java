package bitcamp.myapp.command.board;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.Map;

public class BoardUpdateCommand implements Command {

  private Map<Integer, Board> boardMap;

  public BoardUpdateCommand(Map<Integer, Board> boardMap) {
    this.boardMap = boardMap;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    int boardNo = Prompt.inputInt("게시글 번호?");
    
    Board board = boardMap.get(boardNo);
    if (board == null) {
      System.out.println("없는 게시글입니다.");
      return;
    }

    board.setViewCount(board.getViewCount() + 1);
    board.setTitle(Prompt.input("제목(%s)?", board.getTitle()));
    board.setContent(Prompt.input("내용(%s)?", board.getContent()));
    System.out.println("변경 했습니다.");
  }
}
