package study.oop.clazz.vo;

public class ScoreMy {
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  // 생성자
  // 생성자는 return 타입이 없음. void라고 적지 않기.
  // 생성자 명은 클래스 명과 반드시 똑같이 대소문자까지
  // 클래스를 호출할 때 자동으로 같이 호출해줌.
  public ScoreMy(String name, int kor, int eng, int math) { // 생성자도 public해줘야함.
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

  // 일관성을 위해서 이름조차도 메서드로 작성함.
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }

  public int getKor() {
    return this.kor;
  }

  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }

  public int getEng() {
    return this.eng;
  }

  public void setMath(int math) {
    this.math = math;
    this.compute();
  }

  public int getMath() {
    return this.math;
  }

  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }
}
