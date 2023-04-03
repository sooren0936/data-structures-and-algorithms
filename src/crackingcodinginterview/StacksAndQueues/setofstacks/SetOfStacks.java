package crackingcodinginterview.StacksAndQueues.setofstacks;

public interface SetOfStacks<T> {

    void push(T value);

    T pop();

    T popAt(int stackNumber);

    boolean empty();

    T peek();
}
