package study.lang.method;

public class Test02 {

  public static void main(String[] args) {
    m1("홍길동", 20); // 달라는대로 줘야함.(엄격!)
    m1("임꺽정", 30);
    m1("유관순", 18);
  }

  static void m1(String name, int age) {
    System.out.printf("%s(%d)님 반갑습니다.\n", name, age);
  }

}
