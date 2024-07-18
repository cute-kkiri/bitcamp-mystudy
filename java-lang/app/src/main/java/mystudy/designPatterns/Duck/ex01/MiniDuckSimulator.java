package mystudy.designPatterns.Duck.ex01;

public class MiniDuckSimulator {
  public static void main(String[] args) {
    Duck mallard = new MallardDuck();

    mallard.performQuack();
    mallard.performFly();
  }
}
