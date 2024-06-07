package mystudy.lang.ex05;

public class Test02 {
  public static void main(String[] args) {
    // 비트 연산자

    // 응용: 메모리 절약
    boolean c, cpp, java, js, python, php, html, css;
    int lang = 0;
    lang = lang | 0x80; // c = true
    lang |= 0x20; // java = true
    lang |= 0x08; // python = true
    lang |= 0x02; // html = true
    System.out.println(Integer.toBinaryString(lang));

    // 위의 예제는 직접 숫자를 사용하여 코드를 읽고 이해하기가 쉽지 않다.
    // 해결책?
    // - 각각의 값을 의미있는 이름을 가진 변수에 저장한 후 사용.
    // - 또한 조회용으로 사용할 변수이므로 상수로 선언하기.
    final int CSS = 0x01; // 0000 0001
    final int HTML = 0x02; // 0000 0010
    final int PHP = 0x04; // 0000 0100
    final int PYTHON = 0x08; // 0000 1000
    final int JAVASCRIPT = 0x10; // 0001 0000
    final int JAVA = 0x20; // 0010 0000
    final int CPP = 0x40; // 0100 0000
    final int C = 0x80; // 1000 0000

    // Java와 C, C++, JavaScript를 할 줄 아는 개발자의 정보를 설정하라.
    int lang1 = C | JAVA | PYTHON | HTML;
    System.out.println(Integer.toBinaryString(lang1));

    System.out.println("--------------------------");
    // 할 줄 아는 언어 검사하기.
    System.out.printf("CSS : %b\n", (lang & CSS) == CSS);
    System.out.printf("HTML : %b\n", (lang & HTML) == HTML);
    System.out.printf("PHP : %b\n", (lang & PHP) == PHP);
    System.out.printf("Python : %b\n", (lang & PYTHON) == PYTHON);
    System.out.printf("JavaScript : %b\n", (lang & JAVASCRIPT) == JAVASCRIPT);
    System.out.printf("Java : %b\n", (lang & JAVA) == JAVA);
    System.out.printf("C++ : %b\n", (lang & CPP) == CPP);
    System.out.printf("C : %b\n", (lang & C) == C);
    System.out.println("--------------------------");
    System.out.printf("CSS : %b\n", (lang & CSS) > 0);
    System.out.printf("HTML : %b\n", (lang & HTML) > 0);
    System.out.printf("PHP : %b\n", (lang & PHP) > 0);
    System.out.printf("Python : %b\n", (lang & PYTHON) > 0);
    System.out.printf("JavaScript : %b\n", (lang & JAVASCRIPT) > 0);
    System.out.printf("Java : %b\n", (lang & JAVA) > 0);
    System.out.printf("C++ : %b\n", (lang & CPP) > 0);
    System.out.printf("C : %b\n", (lang & C) > 0);
  }

}
