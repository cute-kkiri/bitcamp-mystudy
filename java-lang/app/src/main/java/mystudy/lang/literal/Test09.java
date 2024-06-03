package mystudy.lang.literal;

// # 부동소수점 리터럴 - 최소값과 최대값

public class Test09 {
    public static void main(String[] args) {
        // ## 4바이트 부동소수점의 최대값과 최소값
        System.out.println(Float.MAX_VALUE); // 3.4028235E38
        System.out.println(Float.MIN_VALUE); // 1.4E-45

        // ## 8바이트 부동소수점의 최대값과 최소값
        System.out.println(Double.MAX_VALUE); // 1.7976931348623157E308
        System.out.println(Double.MIN_VALUE); // 4.9E-324
    }
}