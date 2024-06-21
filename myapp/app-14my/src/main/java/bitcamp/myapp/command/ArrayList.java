package bitcamp.myapp.command;

// 일반화 - Generalization
public class ArrayList { // ArrayList 상속을 만들면서 ArrayList를 모방하는 클래스를 만들어보기.
    private static final int MAX_SIZE = 100;

    private Object[] list = new Object[MAX_SIZE];
    private int size = 0;

    public void add(Object obj) {
        list[size++] = obj;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Object deletedObj = list[index];
        for (int i = index + 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        list[--size] = null;
        return deletedObj;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list[i];
        }
        return arr;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (list[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    // ArrayList에 있는 size를 모방하는 모양으로 메서드를 만들었다.
    public int size() {
        return size;
    }

    // list 추출
    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return list[index];
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }
}
