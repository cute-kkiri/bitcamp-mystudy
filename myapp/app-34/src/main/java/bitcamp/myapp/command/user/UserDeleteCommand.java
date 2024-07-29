package bitcamp.myapp.command.user;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;
import java.util.List;
import java.util.Map;

public class UserDeleteCommand implements Command {

  private Map<Integer, User> userMap;
  private List<Integer> userNoList;

  public UserDeleteCommand(Map<Integer, User> userMap, List<Integer> userNoList) {
    this.userMap = userMap;
    this.userNoList = userNoList;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    int userNo = Prompt.inputInt("회원번호?");

    User deletedUser = userMap.remove(userNo);
    if (deletedUser == null) {
      System.out.println("없는 회원입니다.");
      return;
    }
    userNoList.remove(Integer.valueOf(userNo));
    System.out.printf("'%s' 회원을 삭제 했습니다.\n", deletedUser.getName());
  }
}
