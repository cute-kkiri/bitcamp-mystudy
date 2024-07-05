package study.patterns.ex01.step6;

public abstract class Car {
  String maker;
  String model;
  int cc;

  @Override
  public String toString() {
    return "Car [maker=" + maker + ", model=" + model + ", cc=" + cc + "]";
  }

  // 자동차가 어떻게 동작할지 그 흐름을 정의한다.
  // => Template Method
  public void play() {
    // 흐름의 뼈대 구성.
    start();
    run();
    stop();
  }

  // 구체적인 세부 동자은 서브 클래스에게 맡긴다.
  protected abstract void start();

  protected abstract void run();

  protected abstract void stop();
}
