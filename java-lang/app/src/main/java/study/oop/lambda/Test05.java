package study.oop.lambda;

public class Test05 {
  static class MyCalculator {
    public static int plus(int a, int b) {
      return a + b;
    }

    public static int minus(int a, int b) {
      return a - b;
    }

    public static int multiple(int a, int b) {
      return a * b;
    }

    public static int divide(int a, int b) {
      return a / b;
    }
  }

  interface Calculator {
    int compute(int x, int y);
  }

  public static void main(String[] args) {
    // class My implements Calculator {
    // @Override
    // public int compute(int x, int y) {
    // return MyCalculator.plus(x, y);
    // }
    // }
    //
    // My obj = new My();

    // Calculator obj = new Calculator() {
    // @Override
    // public int compute(int x, int y) {
    // return MyCalculator.plus(x, y);
    // }
    // };
    //

    // Calculator obj = (x, y) -> {
    // return MyCalculator.plus(x, y);
    // };

    // Calculator obj = (x, y) -> MyCalculator.plus(x, y);

    Calculator obj = MyCalculator::plus;

    int result = obj.compute(100, 200);
    System.out.println(result);
  }
}
