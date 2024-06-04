package study.lang.variable;

public class Test01 {
  public static void main(String[] args) {
    // 실습
    // - primitive type의 변수를 선언하라.
    // - 각 변수의 최소값, 최대값을 할당하라.
    // - 각 변수에 최소값, 최대값 범위를 벗어나는 값을 넣은 후 오류를 확인하라.
    // - 예)
    // byte b1 = -128;
    // byte b2 = 127;

    byte b1 = -128; // 최소값
    byte b2 = 127; // 최대값

    short s1 = -32768; // 최소값
    short s2 = 32767; // 최대값

    int i1 = -21_4748_3648; // 최소값
    int i2 = 21_4748_3647; // 최대값

    long l1 = -922_3372_0368_5477_5808L; // 최소값
    long l2 = 922_3372_0368_5477_5807L; // 최대값

    // 부동소수점 메모리 크기와 값의 범위
    // 유효자릿수를 초과하면 값이 짤려서 들어갈 가능성이 높다.
    // 2진수로 변환하는 과정에서 유효하지 않은 자리수라도 정확하게 저장될 수 있다.
    float f1 = -9876.543f;
    float f2 = 9876.5437f; // 반올림됨.
    // float f1 = 1.4E-45f; // 최소값
    // float f2 = 3.4028235E3f; // 최대값

    double d1 = -987654323456.789;
    double d2 = 98765432.34567898; // 반올림됨.
    // double d1 = 4.9E-324; // 최소값
    // double d2 = 1.7976931348623157E308; // 최대값

    System.out.println(f2); // 12345.679
    System.out.println(d2); // 12345.67898

    // 문자 코드 값을 숫자로 직접 저장할 수 있다.
    char c1 = 0; // 최소값
    char c2 = 65535; // 최대값

    boolean bool1 = false; // 최소값
    boolean bool2 = true; // 최대값

    // 원래는 4Byte 값을 1Byte 메모리에 저장할 수 없지만,
    // 리터럴일 경우, 저장할 수 있는 값이라면, 허락한다.

    // float: 약 7자리, double: 약 15자리
  }
}
