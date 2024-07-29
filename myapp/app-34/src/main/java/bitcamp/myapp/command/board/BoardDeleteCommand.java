package bitcamp.myapp.command.board;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.List;
import java.util.Map;

public class BoardDeleteCommand implements Command {

  private Map<Integer, Board> boardMap;
  private List<Integer> boardNoList;

  public BoardDeleteCommand(Map<Integer, Board> boardMap, List<Integer> boardNoList) {
    this.boardMap = boardMap;
    this.boardNoList = boardNoList;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    int boardNo = Prompt.inputInt("게시글 번호?");

    Board deletedBoard = boardMap.remove(boardNo);
    if (deletedBoard == null) {
      System.out.println("없는 게시글입니다.");
      return;
    }
    boardNoList.remove(Integer.valueOf(boardNo));
    System.out.printf("%d번 게시글을 삭제 했습니다.\n", deletedBoard.getNo());
  }


}
