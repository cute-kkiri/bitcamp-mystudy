package bitcamp.myapp.util;

public class Stack extends LinkedList {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("111");
        s.push("222");
        s.push("333");

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    public void push(Object value) {
        add(value);
    }

    public Object pop() {
        return remove(size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
