package bitcamp.myapp.util;

public abstract class AbstractList<E> implements List<E> {

    protected int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(E obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public boolean remove(E obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public Iterator<E> iterator() {

        // 4) anonymous class
        return new Iterator<E>() {

            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < size();
            }

            @Override
            public E next() {
                return get(cursor++);
            }
        };
    }
}
