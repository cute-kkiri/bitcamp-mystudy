package mystudy.designPatterns.Duck.ex03;

import mystudy.designPatterns.Duck.ex03.capsulation.FlywithWings;
import mystudy.designPatterns.Duck.ex03.capsulation.Quack;
import mystudy.designPatterns.Duck.ex03.client.Duck;

public class MallardDuck extends Duck {
  public MallardDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlywithWings();
  }

  @Override
  public void display() {
    System.out.println("저는 물오리입니다.");
  }
}
