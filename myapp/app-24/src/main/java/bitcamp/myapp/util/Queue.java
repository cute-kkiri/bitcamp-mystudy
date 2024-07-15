package bitcamp.myapp.util;

public class Queue<E> extends LinkedList<E> {

    public static void main(String[] args) {
//        Queue<String> q = new Queue<String>();
        Queue q = new Queue();
        q.offer("111");

//        Queue q = new Queue();
//        q.offer(true);
//        q.offer(3.14f);
//        q.offer(new User(10));

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }

    public void offer(E value) {
        add(value);
    }

    public E poll() {
        return remove(0);
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
