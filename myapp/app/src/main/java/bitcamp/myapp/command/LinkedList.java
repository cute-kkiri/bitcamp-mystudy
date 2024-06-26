package bitcamp.myapp.command;

public class LinkedList {

    Node first;
    Node last;
    int size;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append("홍길동");
        list.append("임꺾정");
        list.append("유관순");
        list.append("안중근");
        list.append("윤봉길");
        list.append("김구");

        list.delete(2);
        list.printAll();

        list.delete(2);
        list.printAll();

        list.delete(2);
        list.printAll();

        list.delete(2);
        list.printAll();

        // list.printAll();
        // for (int i = 0; i < list.size(); i++) {
        //     System.out.println(list.getValue(i));
        // }
    }

    public void append(Object value) {
        Node newNode = new Node(value);

        if (first == null) { // 리스트가 비어있는 경우.
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;  // 배열 추가할 때마다 증가
    }

    public Object getValue(int index) {
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

    public Object delete(int index) {
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

    public int index(Object value) {
        Node cursor = first;
        int currentIndex = 0;

        while (cursor != null) {
            if (cursor.value == value) {
                return currentIndex;
            }
            cursor = cursor.next;
            currentIndex++;
        }

        return -1;
    }

    public Object[] getArray() {
        Object[] arr = new Object[size];

        Node cursor = first;
        for (int i = 0; i < size; i++) {
            arr[i] = cursor.value;
            cursor = cursor.next;
        }

        return arr;
    }

    public int size() {
        return size;
    }

    public void printAll() {
        Node cursor = first;
        while (cursor != null) {
            System.out.print(cursor.value + ",");
            cursor = cursor.next;
        }
        System.out.println();
    }
}
