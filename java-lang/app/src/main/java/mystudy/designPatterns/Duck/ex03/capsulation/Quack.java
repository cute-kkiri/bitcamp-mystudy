package mystudy.designPatterns.Duck.ex03.capsulation;

import mystudy.designPatterns.Duck.ex03.behavior.QuackBehavior;

public class Quack implements QuackBehavior {
  @Override
  public void quack() {
    // 꽥꽥 소리를 냄
    System.out.println("꽥");
  }
}
