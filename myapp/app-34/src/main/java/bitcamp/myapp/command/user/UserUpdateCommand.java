package bitcamp.myapp.command.user;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;
import java.util.Map;

public class UserUpdateCommand implements Command {

  private Map<Integer, User> userMap;

  public UserUpdateCommand(Map<Integer, User> userMap) {
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

    user.setName(Prompt.input("이름(%s)?", user.getName()));
    user.setEmail(Prompt.input("이메일(%s)?", user.getEmail()));
    user.setPassword(Prompt.input("암호?"));
    user.setTel(Prompt.input("연락처(%s)?", user.getTel()));
    System.out.println("변경 했습니다.");
  }

}
