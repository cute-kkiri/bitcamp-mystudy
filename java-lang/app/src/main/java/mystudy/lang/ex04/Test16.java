package mystudy.lang.ex04; // Exam0411

// # 정수 변수 - 변수의 메모리 크기
//
public class Test16 {
    public static void main(String[] args) {

        // 1바이트 크기의 정수 값을 담을 메모리 준비
        byte b;

        // 값을 메모리에 저장하려면 1과 0, 2진수 형태로 바꿔야 한다.
        // 정수를 2진수로 바꿀 때 '2의 보수' 방식을 사용한다.
        // 1 byte(8 bit)에 저장할 수 있는 최대/최소값은 다음과 같다.
        b = -128;
        b = 127;

        // 다음과 같이 메모리 크기를 벗어난 값을 저장하려 하면 컴파일 오류가 발생한다.
        // b = -129; // 컴파일 오류!
        // b = 128; // 컴파일 오류!

        // 2바이트 크기의 정수 값을 담을 메모리 준비
        short s;

        // 2바이트 메모리에 담을 수 있는 최소/최대 정수값
        s = -32768; // 10000000 00000000
        s = 32767; // 01111111 11111111

        // 2바이트 범위를 벗어나면 컴파일 오류!
        // s = -32769; // 컴파일 오류!
        // s = 32768; // 컴파일 오류!

        // 4바이트 크기의 정수 값을 담을 메모리 준비
        int i;

        // 4바이트 메모리에 담을 수 있는 최소/최대 정수값
        i = -2147483648; // 10000000 00000000 00000000 00000000
        i = 2147483647; // 01111111 11111111 11111111 11111111

        // 다음은 값을 저장할 메모리의 크기 때문에 발생한 오류가 아니다.
        // 리터럴 크기의 문제다.
        // 정수 값 뒤에 L 또는 l을 붙이지 않은 리터럴은 4바이트 크기를 의미하다.
        // 그런데 4바이트를 넘어서는 값을 리터럴로 표현했기 때문에 오류가 발생한 것이다.
        // i = -2147483649; // 컴파일 오류!
        // i = 2147483648; // 컴파일 오류!

        // 해결책?
        // - 4 byte 크기를 벗어나는 정수를 표기할 때는 반드시 숫자 뒤에 L 또는 l을 붙여야 한다.
        // i = -2147483649L; // 컴파일 오류가 발생하는 이유? 메모리의 크기가 4바이트라서 값을 저장할 수 없다.
        // i = 2147483648L; // 컴파일 오류!

        // 8바이트 크기의 정수 값을 담을 메모리 준비
        long l;

        // 8바이트 메모리에 감을 수 있는 최소/최대 정수값
        l = -9223372036854775808L; // 10000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
        l = 9223372036854775807L; // 01111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111
    }
}