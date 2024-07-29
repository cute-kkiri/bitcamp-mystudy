package bitcamp.myapp.command.user;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;
import java.util.List;
import java.util.Map;

public class UserAddCommand implements Command {

  private Map<Integer, User> userMap;
  private List<Integer> userNoList;

  public UserAddCommand(Map<Integer, User> userMap, List<Integer> userNoList) {
    this.userMap = userMap;
    this.userNoList = userNoList;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    User user = new User();
    user.setName(Prompt.input("이름?"));
    user.setEmail(Prompt.input("이메일?"));
    user.setPassword(Prompt.input("암호?"));
    user.setTel(Prompt.input("연락처?"));
    user.setNo(User.getNextSeqNo());
    
    userMap.put(user.getNo(), user);
    userNoList.add(user.getNo());
  }
}
