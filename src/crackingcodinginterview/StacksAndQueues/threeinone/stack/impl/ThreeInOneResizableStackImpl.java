package crackingcodinginterview.StacksAndQueues.threeinone.stack.impl;

import crackingcodinginterview.StacksAndQueues.threeinone.model.Range;
import crackingcodinginterview.StacksAndQueues.threeinone.model.enums.StackNumber;
import crackingcodinginterview.StacksAndQueues.threeinone.stack.ThreeInOneStack;

import java.util.Arrays;
import java.util.stream.Stream;

public class ThreeInOneResizableStackImpl implements ThreeInOneStack {

    private static final int INIT_CAPACITY = 100;

    private Integer[] array;

    private final Range firstStackRange;
    private final Range secondStackRange;
    private final Range thirdStackRange;

    public ThreeInOneResizableStackImpl() {
        this(INIT_CAPACITY);
    }

    public ThreeInOneResizableStackImpl(final int initCapacity) {
        array = new Integer[initCapacity * 3];
        firstStackRange = new Range(0, initCapacity - 1, 0);
        secondStackRange = new Range(initCapacity, (initCapacity * 2) - 1, initCapacity);
        thirdStackRange = new Range(initCapacity * 2, (initCapacity * 3) - 1, initCapacity * 2);
    }

    @Override
    public void push(final Integer value, final StackNumber stackNumber) {
        final Range range = findRange(stackNumber);

        if (range.getHead() + 1 > range.getMax()) {
            changeStackSize(stackNumber, range);
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

    private void changeStackSize(final StackNumber stackNumber, final Range range) {
        Integer[] first = Arrays.copyOfRange(array, firstStackRange.getMin(), firstStackRange.getMax() + 1);
        Integer[] second = Arrays.copyOfRange(array, secondStackRange.getMin(), secondStackRange.getMax() + 1);
        Integer[] third = Arrays.copyOfRange(array, thirdStackRange.getMin(), thirdStackRange.getMax()+ 1 );

        range.setMax(range.getMax() * 2);
        int delta = (range.getMax() * 2) - range.getMax();

        secondStackRange.setMin(firstStackRange.getMax() + 1);
        if (!stackNumber.equals(StackNumber.THIRD)) {
            thirdStackRange.setMax(thirdStackRange.getMax() + delta);
        } else {
            secondStackRange.setMax(thirdStackRange.getMin() - 1);
        }

        thirdStackRange.setMin(secondStackRange.getMax() + 1);
        if (!stackNumber.equals(StackNumber.THIRD)) {
            thirdStackRange.setMax(thirdStackRange.getMax() + delta);
        }

        first = makeNewStack(first, delta);
        second = makeNewStack(second, delta);
        third = makeNewStack(third, delta);

        array = Stream.of(first, second, third)
                .flatMap(Stream::of)
                .toArray(Integer[]::new);
    }

    Integer[] makeNewStack(final Integer[] stack, final int delta) {
        return Arrays.copyOf(stack, stack.length + delta);
    }
}