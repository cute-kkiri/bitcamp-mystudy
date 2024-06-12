package study.lang.method;

public class Test06 {
  public static void main(String[] args) {
    // sum = 1 + 2 + 3 + 4 + 5 + ... + 10
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
      sum += i;
    }

    System.out.println(sum);

    // 재귀호출
    // sum(10) = 10 + sum(9)
    // sum(10) = 10 + 9 + sum(8)
    // sum(10) = 10 + 9 + 8 + sum(7)
    // sum(10) = 10 + 9 + 8 + ... + sum(1)
    // sum(n) = n + sum(n - 1)
    System.out.println(sum(10));
  }

  static int sum(int n) {
    if (n == 1) {
      return 1;
    }
    return n + sum(n - 1);
  }

}
