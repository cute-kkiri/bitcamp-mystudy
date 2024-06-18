package study.oop.clazz.domain;

public class Score {
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  // 기본 생성자.
  // public Score() {
  // super();
  // }

  public Score(String name, int kor, int eng, int math) {
    // super 클래스는 필수. 컴파일러가 자동으로 붙임.
    // 자동으로 붙기 때문에 안써도 되긴 함. 늘 생성된다는 것을 알면됨.
    super();
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;

    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }

  // 코드 사용의 일관성을 위해서 name도 똑같이 만들어줌.
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // 값이 왜곡될 수 있기 때문에 kor, eng, math도 getter, setter 메서드를 만들어서 왜곡되는 현상을 없애자.
  public int getKor() {
    return this.kor;
  }

  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }

  public int getEng() {
    return this.eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }

  public int getMath() {
    return this.math;
  }

  public void setMath(int math) {
    this.math = math;
    this.compute();
  }

  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }
}
