package study.lang.literal;

// 실습
// - 부동소수점 3.14를 다음의 방식으로 표현하라.
//   3.14
//   31.4 * 10^-1
//   314 * 10^-2
//   0.314 * 10^1
//   0.0314 * 10^2
//

// 부동소수점의 지수표기법(Expornential Notation)
public class Test03 {
    public static void main(String[] args) {
        // 코드를 완성하라.
        System.out.println(3.14); // 고정소수점
        System.out.println(31.4e-1); // 부동소수점
        System.out.println(314e-2); // 부동소수점
        System.out.println(0.314e1); // 부동소수점
        System.out.println(0.0314e2); // 부동소수점
    }
}
