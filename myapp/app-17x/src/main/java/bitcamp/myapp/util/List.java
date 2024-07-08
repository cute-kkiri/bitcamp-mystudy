package bitcamp.myapp.util;

// 데이터 목록을 다루는 일을 할 객체 사용법
// => 즉 '그 객체에게 일을 시킬 때 다음의 메서드를 호출하여 일을 시켜라.' 라고 지정하는 문법
// interface는 규칙이기 때문에 반드시 공개되어야 한다. public
// abstract - interface에서 구체적이지 않다는 뜻으로 붙여줘야한다.
// 어차피 public이기 때문에 생략 가능. abstract는 컴파일이 자동으로 붙임.
public interface List {
    // 데이터를 더할 때 호출할 메서드
    void add(Object value); // 규칙이기 때문에 메서드의 시그너처만 정의한다.

    Object remove(int index);

    Object get(int index);

    int indexOf(Object obj);

    Object[] toArray();

    int size();
}
