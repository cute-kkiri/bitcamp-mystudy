package mystudy.designPatterns.Duck.ex02;

public class Quack implements QuackBehavior {
  @Override
  public void quack() {
    // 꽥꽥 소리를 냄
    System.out.println("꽥");
  }
}
