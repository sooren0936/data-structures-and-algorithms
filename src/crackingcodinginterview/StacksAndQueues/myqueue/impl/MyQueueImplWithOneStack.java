package crackingcodinginterview.StacksAndQueues.myqueue.impl;

import crackingcodinginterview.StacksAndQueues.myqueue.MyQueue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueueImplWithOneStack<T> implements MyQueue<T> {

    private final Stack<T> firstStack = new Stack<>();
    private final Stack<T> secondStack = new Stack<>();

    private static final int HEAD = 0;

    @Override
    public void add(final T value) {
        firstStack.add(value);
    }

    @Override
    public T remove() {
        if (firstStack.empty()) {
            throw new NoSuchElementException();
        }
        return firstStack.remove(HEAD);
    }

    @Override
    public boolean isEmpty() {
        return firstStack.isEmpty();
    }

    @Override
    public T peek() {
        return firstStack.get(HEAD);
    }
}