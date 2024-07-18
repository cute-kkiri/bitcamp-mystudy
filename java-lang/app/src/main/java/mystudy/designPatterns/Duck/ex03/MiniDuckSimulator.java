package mystudy.designPatterns.Duck.ex03;

import mystudy.designPatterns.Duck.ex03.capsulation.FlyRocketPowered;
import mystudy.designPatterns.Duck.ex03.client.Duck;

public class MiniDuckSimulator {
  public static void main(String[] args) {
    Duck mallard = new MallardDuck();
    mallard.performQuack();
    mallard.performFly();

    Duck model = new ModelDuck();
    model.performFly();
    model.setFlyBehavior(new FlyRocketPowered());
    model.performFly();
  }
}
