package bitcamp.myapp.util;

public abstract class AbstractList implements List {

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
        return new Iterator() {

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
    }
}
