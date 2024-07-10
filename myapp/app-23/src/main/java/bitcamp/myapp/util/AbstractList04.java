package bitcamp.myapp.util;

public abstract class AbstractList04 implements List {

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

        // 4) anonymous class
        // 인스턴스를 하나만 만들었을 때 익명 클래스로 생성함.
        // 익명 클래스는 클래스를 상속 받던지 interface를 구현하던지 둘 중 하나만 할 수 있다.
        // Iterator obj = new Iterator() { // interface를 상속받는 class를 작성함.
        return new Iterator() { // interface를 상속받는 class를 작성함.

            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < size();
            }

            @Override
            public Object next() {
                return get(cursor++);
            }
        };

        // return obj;
    }
}
