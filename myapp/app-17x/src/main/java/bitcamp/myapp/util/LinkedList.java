package bitcamp.myapp.util;

public class LinkedList implements List {

    Node first;
    Node last;
    int size;

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);

        if (first == null) { // 리스트가 비어있는 경우.
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;  // 배열 추가할 때마다 증가
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node cursor = first;
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
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node deletedNode = null;
        size--; // delete할 때마다 줄이기.

        // 첫 노드일 때
        if (index == 0) {
            deletedNode = first;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return deletedNode.value;
        }

        // 중간 노드일 때
        Node cursor = first;
        int currentIndex = 0;

        while (cursor != null) {
            if (currentIndex == index - 1) {
                // 삭제할 노드의 전 노드에서
                break;
            }

            cursor = cursor.next;
            currentIndex++;
        }

        deletedNode = cursor.next;

        // 삭제할 노드에 있는 next의 주소를 current cursor next에 담는다.
        cursor.next = cursor.next.next;

        // 마지막 노드일 때
        if (cursor.next == null) {
            last = cursor;
        }
        return deletedNode.value;
    }

    @Override
    public int indexOf(Object value) {
        Node cursor = first;
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

        Node cursor = first;
        for (int i = 0; i < size; i++) {
            arr[i] = cursor.value;
            cursor = cursor.next;
        }

        return arr;
    }

    @Override
    public int size() {
        return size;
    }
}
