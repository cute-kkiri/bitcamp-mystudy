package com.eomcs.oop.ex11.overview.step4;

public class Test1 {
  public static void main(String[] args) {
    MyList myList = new MyList();
    myList.add("홍길동");
    myList.add("임꺽정");
    myList.add("유관순");
    myList.add("안중근");
    myList.add("윤봉길");
    myList.add("김구");

    Iterator iterator = myList.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
