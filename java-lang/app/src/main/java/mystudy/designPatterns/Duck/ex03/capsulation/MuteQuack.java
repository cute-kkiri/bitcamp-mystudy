package mystudy.designPatterns.Duck.ex03.capsulation;

import mystudy.designPatterns.Duck.ex03.behavior.QuackBehavior;

public class MuteQuack implements QuackBehavior {
  @Override
  public void quack() {
    // 아무것도 하지 않음
    // 소리를 낼 수 없는 경우
    System.out.println("<< 조용~ >>");
  }
}
