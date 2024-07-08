package bitcamp.myapp.util;

// 추상 클래스 상속.
public class LinkedList extends AbstractList {

    private Node first;
    private Node last;

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

    // 1) 스태틱 중첩 클래스 - 인스턴스와 상관 없는 클래스라서 스태틱으로 만들어줌.
    // 메서드 생성과 같이 고민하고 만들면 된다.
    // 지금 LinkedList에서만 쓰고 있기 때문에 이곳에 스태틱 중첩 클래스로 변경함.
    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
    // 중첩 클래스에서 바깥 클래스의 인스턴스 멤버를 사용한다면 인스턴스 중첩 클래스로 생성한다.
    // 인스턴스 멤버 사용이 없다면 스태틱 중첩 클래스로 사용.

}
