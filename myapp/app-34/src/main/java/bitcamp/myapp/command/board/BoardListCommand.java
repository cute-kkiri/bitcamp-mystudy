package bitcamp.myapp.command.board;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.Board;
import java.util.List;
import java.util.Map;

public class BoardListCommand implements Command {

  private Map<Integer, Board> boardMap;
  private List<Integer> boardNoList;

  public BoardListCommand(Map<Integer, Board> boardMap, List<Integer> boardNoList) {
    this.boardMap = boardMap;
    this.boardNoList = boardNoList;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    System.out.println("번호 제목 작성일 조회수");

    for (Integer no : boardNoList) {
      Board board = boardMap.get(no);
      System.out.printf("%d %s %tY-%3$tm-%3$td %d\n",
          board.getNo(), board.getTitle(), board.getCreatedDate(), board.getViewCount());
    }
  }
}
