package study.oop.lambda;

import study.oop.lambda.Test04.InterestCalculator;

public class Factory {
  // static public InterestCalculator create(double rate) {
  // return new My(rate);
  // }

  static InterestCalculator create(double rate) {
    // class My implements InterestCalculator {
    // double rate;
    //
    // public My(double rate) {
    // this.rate = rate;
    // }
    //
    // @Override
    // public double compute(int money) {
    // return money + (money * rate);
    // }
    // }
    // return new My(rate);

    // class My implements InterestCalculator {
    // @Override
    // public double compute(int money) {
    // return money + (money * rate);
    // }
    // }
    // return new My();

    return money -> money + (money * rate);
  }
}
