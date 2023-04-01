package crackingcodinginterview.StacksAndQueues.threeinone.stack.impl;

import crackingcodinginterview.StacksAndQueues.threeinone.model.Range;
import crackingcodinginterview.StacksAndQueues.threeinone.model.enums.StackNumber;
import crackingcodinginterview.StacksAndQueues.threeinone.stack.ThreeInOneStack;

public class ThreeInOneStackImpl implements ThreeInOneStack {

    private static final int DEFAULT_CAPACITY = 100;

    private final Integer[] array;

    private final Range firstStackRange;
    private final Range secondStackRange;
    private final Range thirdStackRange;

    public ThreeInOneStackImpl() {
        this(DEFAULT_CAPACITY);
    }

    public ThreeInOneStackImpl(final int initCapacity) {
        array = new Integer[initCapacity * 3];
        firstStackRange = new Range(0, initCapacity - 1, 0);
        secondStackRange = new Range(initCapacity, (initCapacity * 2) - 1, initCapacity);
        thirdStackRange = new Range(initCapacity * 2, (initCapacity * 3) - 1, initCapacity * 2);
    }

    @Override
    public void push(final Integer value, final StackNumber stackNumber) {
        final Range range = findRange(stackNumber);

        if (range.getHead() + 1 > range.getMax()) {
            throw new IndexOutOfBoundsException("Stack with number: " + stackNumber + " is overflow!");
        }

        if (array[range.getMin()] == null) {
            array[range.getHead()] = value;
        } else {
            range.setHead(range.getHead() + 1);
            array[range.getHead()] = value;
        }
    }

    @Override
    public boolean pop(final StackNumber stackNumber) {
        final Range range = findRange(stackNumber);

        if (range.getHead() == range.getMin() && array[range.getHead()] == null) {
            return false;
        }

        if (range.getHead() == range.getMin()) {
            array[range.getHead()] = null;
        } else {
            array[range.getHead()] = null;
            range.setHead(range.getHead() - 1);
        }
        return true;
    }

    @Override
    public boolean empty(final StackNumber stackNumber) {
        final Range range = findRange(stackNumber);
        if (array[range.getMin()] == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object peek(final StackNumber stackNumber) {
        final Range range = findRange(stackNumber);
        return array[range.getHead()];
    }

    private Range findRange(final StackNumber stackNumber) {
        return switch (stackNumber) {
            case FIRST -> firstStackRange;
            case SECOND -> secondStackRange;
            case THIRD -> thirdStackRange;
        };
    }
}