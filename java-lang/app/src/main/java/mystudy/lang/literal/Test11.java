package mystudy.lang.literal;

// # 부동소수점 리터럴 - 2진수로 변경된 것을 확인하기
// - 자바가 부동소수점을 다룰 때 IEEE 754 규칙에 따라 2진수로 변환하는 것을 확인해 보자.

public class Test11 {
    public static void main(String[] args) {
        System.out.println(12.375f);
        System.out.println(-12.375f);
        System.out.println(12.375);
    }
}

// ## 실습
// 1) 컴파일하기
// 2) 클래스 파일로 부동소수점 값 확인하기
// - Exam35.class 파일을 hexdump 플러그인으로 출력한다.
// - 12.375의 2진수 값인 0100_0001_0100_0110_0000_0000_0000_0000을 찾아본다.
// 보통 에디터에서는 2진수를 16진수로 바꿔 보여주기 때문에 16진수 값 0x41460000을 찾아보라!
//

//
// 부동소수점 정규화 과정
// 1) 소수점 이상 부분을 2진수로 변환
// - 12(10진수)
// - 1100(진수)
//
// 2) 소수점 이하 부분을 2진수로 변환
// - .375
// - 소수점을 2로 곱하여 나온 결과에서 정수 부분만을 차례대로 표기한다.
// - 소수 부분이 0이거나 반복되면 계산을 멈춘다.
// - 예: 0.375(10진수)
// 0.375 * 2 = 0.75 --> 0
// 0.75 * 2 = 1.5 --> 1
// 0.5 * 2 = 1.0 --> 1
// => 0.011(2진수)
//
// 3) 소수점 이상 2진수와 소수점 이하 2진수를 합친다.
// => 12(1100) + .375(0.011) = 1100.011
//
// 4) 정규화
// => 소수점 위치를 조정하여 가수부와 지수부를 분리한다.
// => 4.1: 소수점 왼쪽에 1이 한개만 남도록 소수점 위치를 이동한다.
// = 1.100011 * 2**3 = 1100.011
// => 4.2: 소수점 앞의 1은 무조건 1이기 때문에 버린다.
// = .100011 * 2**3
// => 4.3: 가수부와 지수부로 분리한다.
// 가수부(23비트)
// - Sign-Magnitude로 표현한다
// - 따라서 음수나 양수나 같은 2진수 값을 갖는다.
// - 예) 100011
// 지수부(8비트)
// - 2의 제곱승 값이다.
// - Excess-K 로 표현한다.
// - K값은 2**(8-1) - 1 = 2**7 - 1 = 128 - 1 = 127 이다.
// - 예) 3(2의 제곱승) + 127(K값; bias) = 130
// 예) 130 = 10000010(2진수)
// => 4.4: 32비트 메모리에 담기
// - [1:부호비트][8:지수부][23:가수부] = 32비트
// - 예) 0_10000010_10001100000000000000000
// = 01000001_01000110_00000000_00000000
// = 41_46_00_00(16진수)
// - -12.375
// - 예) 1_10000010_10001100000000000000000
// = 11000001_01000110_00000000_00000000
// = c1_46_00_00(16진수)
// => 4.5: 64비트 메모리에 담기
// - [1:부호비트][11:지수부][52:가수부] = 64비트
// - 부호비트(1) = 0
// - 지수부(11) = 3 + (2**(11-1) - 1) = 3 + (1024 - 1) = 3 + 1023 = 1026
// = 100_0000_0010
// - 가수부(52) = 100011
// - 예) 0_10000000010_1000110000000000000000000000000000000000000000000000
// = 01000000_00101000_11000000_00000000_00000000_00000000_00000000_00000000
// = 40_28_c0_00_00_00_00_00(16진수)
//
