package bitcamp.myapp.command.user;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.User;
import java.util.List;
import java.util.Map;

public class UserListCommand implements Command {

  private Map<Integer, User> userMap;
  private List<Integer> userNoList;

  public UserListCommand(Map<Integer, User> userMap, List<Integer> userNoList) {
    this.userMap = userMap;
    this.userNoList = userNoList;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    System.out.println("번호 이름 이메일");

    for (Integer no : userNoList) {
      User user = userMap.get(no);
      System.out.printf("%d %s %s\n", user.getNo(), user.getName(), user.getEmail());
    }
  }
}
