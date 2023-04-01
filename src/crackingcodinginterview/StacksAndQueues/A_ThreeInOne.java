package crackingcodinginterview.StacksAndQueues;

import static crackingcodinginterview.StacksAndQueues.A_ThreeInOne.StackNumber.*;

/**
 * Three in One: Describe how you could use a single array to implement three stacks.
 */
public class A_ThreeInOne {

    public static void main(String[] args) {
        threeInOne();
    }

    public static void threeInOne() {
        final ThreeInOneStack threeInOneStack = new ThreeInOneStackImpl(3);

        System.out.println(threeInOneStack.empty(FIRST));
        threeInOneStack.push(5, FIRST);
        threeInOneStack.push(5, FIRST);
        threeInOneStack.push(5, FIRST);
        System.out.println(threeInOneStack.empty(FIRST));
        System.out.println(threeInOneStack.peek(FIRST));
        threeInOneStack.pop(FIRST);
        System.out.println(threeInOneStack.empty(FIRST));
        System.out.println(threeInOneStack.peek(FIRST));

        System.out.println(threeInOneStack.empty(SECOND));
        threeInOneStack.push(5, SECOND);
        threeInOneStack.push(5, SECOND);
        threeInOneStack.push(5, SECOND);
        System.out.println(threeInOneStack.empty(SECOND));
        System.out.println(threeInOneStack.peek(SECOND));
        threeInOneStack.pop(SECOND);
        System.out.println(threeInOneStack.empty(SECOND));
        System.out.println(threeInOneStack.peek(SECOND));

        System.out.println(threeInOneStack.empty(THIRD));
        threeInOneStack.push(5, THIRD);
        threeInOneStack.push(5, THIRD);
        threeInOneStack.push(5, THIRD);
        System.out.println(threeInOneStack.empty(THIRD));
        System.out.println(threeInOneStack.peek(THIRD));
        threeInOneStack.pop(THIRD);
        System.out.println(threeInOneStack.empty(THIRD));
        System.out.println(threeInOneStack.peek(THIRD));
    }

    interface ThreeInOneStack {

        void push(Integer value, final StackNumber stackNumber);

        boolean pop(final StackNumber stackNumber);

        boolean empty(final StackNumber stackNumber);

        Object peek(final StackNumber stackNumber);
    }

    public static class Range {
        private final int min;
        private final int max;
        private int head;

        public Range(int min, int max, int head) {
            this.min = min;
            this.max = max;
            this.head = head;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public int getHead() {
            return head;
        }

        public void setHead(int head) {
            this.head = head;
        }
    }

    public enum StackNumber {
        FIRST,
        SECOND,
        THIRD
    }

    public static class ThreeInOneStackImpl implements ThreeInOneStack {

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

        public Range findRange(final StackNumber stackNumber) {
            return switch (stackNumber) {
                case FIRST -> firstStackRange;
                case SECOND -> secondStackRange;
                case THIRD -> thirdStackRange;
            };
        }
    }


}