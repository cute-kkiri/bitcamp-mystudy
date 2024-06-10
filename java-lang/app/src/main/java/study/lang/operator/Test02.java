package study.lang.operator;

// 실습
// - 산술 연산자를 사용하여 연산을 수행한 후 결과를 확인하라.
//
// 학습 내용
// - byte, short, char를 산술연산할 때 int로 변환한 후 수행한다.
// - 같은 타입끼리만 연산할 수 있다.
// - int와 int의 연산 결과를 int이다.
// - 다른 타입으로 변환하는 것을 '형변환(type casting)' 이라 한다.

public class Test02 {
  public static void main(String[] args) {
    byte b1 = 100;
    byte b2 = 20;
    byte b3;

    b3 = 100 + 20; // 리터럴 끼리의 연산 결과는 리터럴이다.
    b3 = (byte) (b1 + b2);

    // 다음 코드를 완성하라.
    // b3 변수에 b1 + b2 값을 넣고 출력해보라!
    System.out.println(b3);

    // - Java의 기본 산술 연산이 int 타입으로 수행된다.
    // 즉, byte 타입의 두 변수를 더하면 결과가 int 타입으로 자동 변환된다.
    // 따라서, int 타입의 값을 byte 타입의 변수에 직접 할당하려고 하면 타입 불일치로 인해 컴파일 오류가 발생
    //
    // - 발생하는 오류 타입
    // => 불일치 오류: b1 + b2의 결과는 int 타입이므로, 이를 byte 타입 변수 b3에 직접 할당할 수 없습니다.
    // - 해결 방법
    // =>명시적 타입 캐스팅: int 타입의 결과를 byte 타입으로 변환하여 할당합니다. 변수 초기화: 변수를 선언할 때 초기화합니다.

    int r = b1 + b2; // OK

    char c = 20;
    short s = 30;
    // short r2 = c + s;

    // int i1 = 21_0000_0000;
    // int i2 = 21_0000_0000;
    // int i3 = i1 + i2;

    // 이렇게 하면 해결할 수 있다.
    long i1 = 22_0000_0000L; // 22_0000_0000 - int 리터럴 범위를 벗어나면 오류. 따라서 L을 붙여줘야한다.
    long i2 = 21_0000_0000;
    long i3 = i1 + i2;
    System.out.println(i3); // -94967296

    long r3 = i1 + i2;
    System.out.println(r3); // -94967296

    // - int 타입의 값이 최대 2,147,483,647(약 21억)이며, 이를 초과하는 연산을 수행하면 오버플로우가 발생
    // - long r3 = (long) (i1 + i2); 코드가 원하는 결과를 얻지 못하는 이유는, i1과 i2의 덧셈 연산이 int 타입으로 먼저 수행되고 난 후에 그
    // 결과가 long 타입으로 캐스팅된다.
    // 즉, 오버플로우는 이미 int 연산에서 발생한 후에 long으로 변환되므로, 변환된 값은 여전히 잘못된 결과 값이 나옴.

  }
}