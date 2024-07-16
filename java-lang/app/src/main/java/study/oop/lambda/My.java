package study.oop.lambda;

import study.oop.lambda.Test04.InterestCalculator;

public class My implements InterestCalculator {
  double rate;

  public My(double rate) {
    this.rate = rate;
  }

  @Override
  public double compute(int money) {
    return money + (money * rate);
  }
}
