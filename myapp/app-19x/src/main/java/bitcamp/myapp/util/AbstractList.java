package bitcamp.myapp.util;

// 서브클래스에게 공통필드를 물려주기 위한 클래스
// List interface 사용
public abstract class AbstractList implements List {
    protected int size = 0; // 서브클래스는 사용할 수 있게 protected로

    @Override
    public int size() {
        return size;
    }
}
