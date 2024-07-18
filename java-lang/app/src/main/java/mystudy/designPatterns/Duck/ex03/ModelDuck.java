package mystudy.designPatterns.Duck.ex03;

import mystudy.designPatterns.Duck.ex03.capsulation.FlyNoWay;
import mystudy.designPatterns.Duck.ex03.capsulation.Quack;
import mystudy.designPatterns.Duck.ex03.client.Duck;

public class ModelDuck extends Duck {
  public ModelDuck() {
    flyBehavior = new FlyNoWay(); // 날지 못 하는 오리
    quackBehavior = new Quack();
  }

  @Override
  public void display() {
    System.out.println("저는 모형 오리입니다.");

  }
}
