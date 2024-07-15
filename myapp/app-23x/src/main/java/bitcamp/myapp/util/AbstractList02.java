package bitcamp.myapp.util;

public abstract class AbstractList02 implements List {

    protected int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator iterator() {
        // 컴파일러: 바깥 클래스의 인스턴스 주소를 전달하는 코드로 변환
        return new ListIterator();
    }

    // 2) non-static nested class == inner class
    class ListIterator implements Iterator {
        // 컴파일러: 바깥 클래스의 인스턴스 주소를 저장할 필드 자동 생성
        //        private List list;
        private int cursor;

        // 컴파일러: 바깥 클래스의 인스턴스 주소를 받는 생성자 자동 생성
        // public ListIterator(List list) {
        //    this.list = list;
        // }

        @Override
        public boolean hasNext() {
            // 바깥 클래스의 인스턴스를 사용하려면
            // => 바깥클래스명.this 라고 지정해야한다.
            // return cursor < AbstractList.this.size();
            // => 중첩 클래스 안에 해당 필드나 메서드가 없다면
            // 바깥클래스명.this 생략 가능
            // => 컴파일러가 자동으로 붙인다.
            return cursor < size();
        }

        @Override
        public Object next() {
            // 바깥 클래스의 인스턴스를 사용하려면
            // => 바깥클래스명.this 라고 지정해야한다.
            // return AbstractList.this.get(cursor++);
            return get(cursor++);
        }
    }
}
