package mystudy.designPatterns.Duck.ex03.capsulation;

import mystudy.designPatterns.Duck.ex03.behavior.FlyBehavior;

public class FlywithWings implements FlyBehavior {
  @Override
  public void fly() {
    // 나는 방법을 구현
    System.out.println("날고 있어요!!");
  }
}
