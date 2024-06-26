// 관계 연산자 : 부동소수점 비교 
package com.eomcs.lang.ex05;

public class Exam0221 {
  public static void main(String[] args) {
    float f1 = 12.321f;
    float f2 = 1.1f;
    System.out.println((f1 + f2) == 13.421f);
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f1 + f2);
    // 12.321
    // => 12: 1100
    // => 0.321: 01010010001011010001
    // => 12 + 0.321 = 1100.01010010001011010001
    // => 1.10001010010001011010001 * 2**3
    // => 지수부: 3 + 127 = 130 = 10000010
    // => 가수부: 10001010010001011010001
    // => 0 10000010 10001010010001011010001
    // 
    // 1.1
    // => 1: 1
    // => 0.1: 00011001100110011001101
    // => 1 + 0.1 = 1.00011001100110011001101
    // => 1.00011001100110011001101 * 2**0
    // => 지수부: 0 + 127 = 127 = 01111111
    // => 가수부: 00011001100110011001101
    // => 0 01111111 00011001100110011001101
    //
    // 지수가 작은 쪽을 큰 쪽에 맞춘다.
    // => 1.1의 지수가 0이기 때문에 3으로 맞춘다.
    //    1.10001010010001011010001    (12.321)
    //  + 0.00100011001100110011001    (1.1)
    // ----------------------------------------
    //    1.10101101011110001101010
    //
    // => 0 10000010 10101101011110001101010
    //    

    System.out.println("----------------------------------");

    float x = 11.221f;
    float y = 2.2f;
    System.out.println((x + y) == 13.421f);
    System.out.println(x);
    System.out.println(y);
    System.out.println(x + y); 
    System.out.println(13.421f);
    // 11.221
    // => 11: 1011
    // => 0.221: 00111000100100110111
    // => 11 + 0.221 = 1011.00111000100100110111
    // => 1.01100111000100100110111 * 2**3
    // => 지수부: 3 + 127 = 130 = 10000010
    // => 가수부: 01100111000100100110111
    // => 0 10000010 01100111000100100110111
    // 
    // 2.2
    // => 2: 10
    // => 0.2: 0011001100110011001101
    // => 2 + 0.2 = 10.0011001100110011001101
    // => 1.00011001100110011001101 * 2**1
    // => 지수부: 1 + 127 = 128 = 10000000
    // => 가수부: 00011001100110011001101
    // => 0 10000000 00011001100110011001101
    //
    // 지수가 작은 쪽을 큰 쪽에 맞춘다.
    // => 2.2의 지수가 1이기 때문에 3으로 맞춘다.
    //    1.01100111000100100110111   (11.221)
    //  + 0.01000110011001100110011 (2.2)
    // ----------------------------------------
    //    1.10101101011110001101010
    //
    // => 0 10000010 10101101011110001101010
    //       



  }
}

