package bitcamp.myapp.command.user;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;
import java.util.Map;

public class UserViewCommand implements Command {

  private Map<Integer, User> userMap;

  public UserViewCommand(Map<Integer, User> userMap) {
    this.userMap = userMap;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    int userNo = Prompt.inputInt("회원번호?");

    User user = userMap.get(userNo);
    if (user == null) {
      System.out.println("없는 회원입니다.");
      return;
    }

    System.out.printf("이름: %s\n", user.getName());
    System.out.printf("이메일: %s\n", user.getEmail());
    System.out.printf("연락처: %s\n", user.getTel());
  }
}
