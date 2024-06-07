package mystudy.lang.ex05;

public class Test01 {
  public static void main(String[] args) {
    // 비트 이동 연산자: >>, >>>, <<
    int i = 1;
    System.out.printf("i = 1 => %d, %d, %d %n", i << 1, i << 2, i << 3);

    int i1 = 11;
    System.out.printf("i1 = 11 => %d, %d, %d %n", i1 << 1, i1 << 2, i1 << 3);

    int a = -0x7f_ff_ff_fa;
    System.out.printf("a = -0x7f_ff_ff_fa => %d, %d, %d, %d %n", a, a << 1, a << 2, a << 3);

    // 비트 이동의 유효 범위
    System.out.printf("%d, %d, %d %n", 3 << 33, 3 << 65, 3 << 97);

    int i3 = 105;
    System.out.printf("i3 = 105 => %d, %d, %d %n", i3 >> 1, i3 >> 2, i3 >> 3);

    int i4 = -87;
    System.out.printf("i4 = -87 => %d, %d, %d %n", i4 >> 1, i4 >> 2, i4 >> 3);

    // >>>
    int i5 = 5;
    System.out.printf("i5 = 5 => %d, %d, %d %n", i5 >>> 1, i5 >>> 2, i5 >>> 3);

    int i6 = -87;
    System.out.printf("i6 = -87 => %d, %d, %d %n", i6 >>> 1, i6 >>> 2, i6 >>> 3);

    int i7 = 0x27a130ff;
    int a7, b7, c7, d7;
    a7 = i7 >> 24;
    b7 = i7 >> 16 & 0xff;
    c7 = i7 >> 8 & 0xff;
    d7 = i7 & 0xff;
    System.out.printf("i7 = 0x27a120ff => %x, %x, %x, %x %n", a7, b7, c7, d7);
  }

}
