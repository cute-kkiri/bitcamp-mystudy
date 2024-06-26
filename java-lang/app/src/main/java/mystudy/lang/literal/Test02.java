package mystudy.lang.literal;

public class Test02 {
    public static void main(String[] args) {
        // 10진수 리터럴
        // - 코드에서 일반적으로 정수 값을 표현할 때 사용한다.
        System.out.println(100);

        // 8진수 리터럴
        // - 코드를 작성할 때 잘 사용하지 않는다.
        // - 0으로 시작해야 한다.
        System.out.println(0144); // 100

        // 2진수 리터럴
        // - 메모리의 상태를 직설적으로 보여주고 싶을 때 사용한다.
        // - 0b 또는 0B로 시작한다.
        System.out.println(0b1100100); // 100
        System.out.println(0B1100100); // 100

        // - 숫자 앞에 0이 있어도 된다.
        System.out.println(0b01100100); // 100
        System.out.println(0B01100100); // 100

        // 16진수 리터럴
        // 2진수를 간결하게 표현하기 위해 사용한다.
        // 0x 또는 0X로 시작한다.
        System.out.println(0x64); // 100
        System.out.println(0X64); // 100

        // 숫자 앞에 0이 있어도 된다.
        System.out.println(0x064); // 100
        System.out.println(0X064); // 100
    }
}
