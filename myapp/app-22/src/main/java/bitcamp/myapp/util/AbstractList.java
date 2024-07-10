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
        return new ListIterator(this);
    }
}
