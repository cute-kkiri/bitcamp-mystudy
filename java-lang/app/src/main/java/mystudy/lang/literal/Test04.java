package mystudy.lang.literal;

// # 정수 리터럴 - 메모리 크기에 따른 표기법
public class Test04 {
    public static void main(String[] args) {
        // ## 4바이트 정수
        System.out.println(2147483647); // 4 바이트 양의 정수 최대값
        System.out.println(-2147483648); // 4 바이트 양의 정수 최소값

        // 4바이트 메모리 크기를 초과하면 컴파일 오류가 발생한다.
        // System.out.println(2147483648);
        // System.out.println(-2147483649);

        // ## 8바이트 정수
        System.out.println(2147483647L); // 2147483647
        System.out.println(-2147483649L); // -2147483649

        // ## 4바이트 또는 8바이트 정수의 최대값과 최소값
        System.out.println(Integer.MAX_VALUE); // 4바이트로 표현할 수 있는 정수 최대값 // 2147483647
        System.out.println(Integer.MIN_VALUE); // 4바이트로 표현할 수 있는 정수 최소값 // -2147483648
        System.out.println(Long.MAX_VALUE); // 8바이트로 표현할 수 있는 정수 최대값 // 9223372036854775807
        System.out.println(Long.MIN_VALUE); // 8바이트로 표현할 수 있는 정수 최소값 // -9223372036854775808

        // ## 주의!
        System.out.println(100); // 4바이트 크기의 정수 값
        System.out.println(100L); // 8바이트 크기의 정수 값

        // ## 정리
        // - 4바이트 정수 리터럴
        // 예) 100

        // - 8바이트 정수 리터럴
        // 정수 뒤에 접미사 L 또는 l을 붙인다.
        // 예) 100L (주로 사용)
        // 예) 100l
    }
}
