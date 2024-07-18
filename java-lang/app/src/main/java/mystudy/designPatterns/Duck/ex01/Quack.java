package mystudy.designPatterns.Duck.ex01;

public class Quack implements QuackBehavior {
  @Override
  public void quack() {
    // 꽥꽥 소리를 냄
    System.out.println("꽥");
  }
}
