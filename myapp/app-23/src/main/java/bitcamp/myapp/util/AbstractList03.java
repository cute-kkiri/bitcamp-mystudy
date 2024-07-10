package bitcamp.myapp.util;

public abstract class AbstractList03 implements List {

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
        // 3) local class
        class ListIterator implements Iterator {
            // 컴파일러가 자동으로 생성.
            // private AbstractList this$0;
            private int cursor;

            // 컴파일러가 자동으로 생성.
            // public ListIterator(AbstractList outer) {
            //     this$0 = outer;
            // }

            @Override
            public boolean hasNext() {
                return cursor < size();
            }

            @Override
            public Object next() {
                return get(cursor++);
            }
        }

        return new ListIterator();
        // 컴파일러가 자동으로 생성.
        // return new ListIterator(this);
    }
}
