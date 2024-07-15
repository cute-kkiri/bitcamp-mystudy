package bitcamp.myapp.util;

public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value); // 적는게 원칙이나 생략가능.

        if (first == null) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<E> cursor = first;
        int currentIndex = 0;

        while (cursor != null) {
            if (currentIndex == index) {
                return cursor.value;
            }
            cursor = cursor.next;
            currentIndex++;
        }
        return null;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<E> deletedNode = null;
        size--;

        if (index == 0) {
            deletedNode = first;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return deletedNode.value;
        }

        Node<E> cursor = first;
        int currentIndex = 0;

        while (cursor != null) {
            if (currentIndex == (index - 1)) {
                break;
            }
            cursor = cursor.next;
            currentIndex++;
        }

        deletedNode = cursor.next;
        cursor.next = cursor.next.next;

        if (cursor.next == null) {
            last = cursor;
        }

        return deletedNode.value;
    }

    @Override
    public int indexOf(E value) {
        Node<E> cursor = first;
        int currentIndex = 0;

        while (cursor != null) {
            if (cursor.value.equals(value)) {
                return currentIndex;
            }
            cursor = cursor.next;
            currentIndex++;
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];

        Node<E> cursor = first;
        for (int i = 0; i < size; i++) {
            arr[i] = cursor.value;
            cursor = cursor.next;
        }

        return arr;
    }

    // static nested class
    static class Node<E> {

        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

}
