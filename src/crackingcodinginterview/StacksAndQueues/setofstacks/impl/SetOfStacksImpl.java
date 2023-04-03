package crackingcodinginterview.StacksAndQueues.setofstacks.impl;

import crackingcodinginterview.StacksAndQueues.setofstacks.SetOfStacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacksImpl<T> implements SetOfStacks<T> {

    private static final int DEFAULT_CAPACITY = 100;

    private final int capacity;
    private int currentStackNumber = 0;
    private int head = -1;

    private final List<Stack<T>> stacks = new ArrayList<>();

    public SetOfStacksImpl() {
        this(DEFAULT_CAPACITY);
    }

    public SetOfStacksImpl(final int initCapacity) {
        this.capacity = initCapacity;
        stacks.add(new Stack<>());
    }

    @Override
    public void push(final T value) {
        final Stack<T> stack = stacks.get(currentStackNumber);
        head++;
        stack.push(value);
        checkStackCapacity(stack);
    }

    @Override
    public T pop() {
        Stack<T> stack = stacks.get(currentStackNumber);
        checkStackCapacity(stack);
        stack = stacks.get(currentStackNumber);
        if (!stack.isEmpty()) {
            head--;
            return stack.pop();
        }
        return null;
    }

    @Override
    public T popAt(final int stackNumber) {
        Stack<T> stack = stacks.get(stackNumber);
        if (!stack.isEmpty()) {
            head--;
            return stack.pop();
        }
        return null;
    }

    @Override
    public boolean empty() {
        return !stacks.get(0).isEmpty();
    }

    @Override
    public T peek() {
        final Stack<T> stack = stacks.get(currentStackNumber);
        if (!stack.isEmpty()) {
            return stack.get(head);
        }
        return null;
    }

    private void checkStackCapacity(final Stack<T> stack) {
        if (stack.size() >= capacity) {
            stacks.add(new Stack<>());
            head = -1;
            currentStackNumber++;
        } else if (stack.isEmpty() && stacks.size() != 1) {
            stacks.remove(currentStackNumber);
            head = capacity;
            currentStackNumber--;
        }
    }
}