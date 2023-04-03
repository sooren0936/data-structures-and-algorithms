package crackingcodinginterview.StacksAndQueues.myqueue.impl;

import crackingcodinginterview.StacksAndQueues.myqueue.MyQueue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueueImplWithTwoStacks<T> implements MyQueue<T> {

    private final Stack<T> firstStack = new Stack<>();
    private final Stack<T> secondStack = new Stack<>();

    @Override
    public void add(final T value) {
        firstStack.add(value);
    }

    @Override
    public T remove() {
        shiftStacks();
        if (secondStack.empty()) {
            throw new NoSuchElementException();
        }
        return secondStack.pop();
    }

    @Override
    public boolean isEmpty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }

    @Override
    public T peek() {
        shiftStacks();
        return secondStack.peek();
    }

    private void shiftStacks() {
        while (!firstStack.empty()) {
            secondStack.push(firstStack.pop());
        }
    }
}