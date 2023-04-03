package crackingcodinginterview.StacksAndQueues.myqueue;

public interface MyQueue<T> {

    void add(T value);

    T remove();

    boolean isEmpty();

    T peek();
}