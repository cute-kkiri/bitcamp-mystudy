package bitcamp.myapp.command.board;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BoardAddCommand implements Command {

  private Map<Integer, Board> boardMap;
  private List<Integer> boardNoList;

  public BoardAddCommand(Map<Integer, Board> boardMap, List<Integer> boardNoList) {
    this.boardMap = boardMap;
    this.boardNoList = boardNoList;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    Board board = new Board();
    board.setTitle(Prompt.input("제목?"));
    board.setContent(Prompt.input("내용?"));
    board.setCreatedDate(new Date());
    board.setNo(Board.getNextSeqNo());

    boardMap.put(board.getNo(), board);
    boardNoList.add(board.getNo());
  }

}
