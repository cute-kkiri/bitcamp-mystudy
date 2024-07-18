package mystudy.designPatterns.Duck.ex03.capsulation;

import mystudy.designPatterns.Duck.ex03.behavior.QuackBehavior;

public class Squeak implements QuackBehavior {
  @Override
  public void quack() {
    // 고무 오리의 삑삑
    // 소리를 냄
    System.out.println("삑");
  }
}
