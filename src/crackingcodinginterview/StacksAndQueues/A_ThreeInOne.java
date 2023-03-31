package crackingcodinginterview.StacksAndQueues;

/**
 * Three in One: Describe how you could use a single array to implement three stacks.
 */
public class A_ThreeInOne {

    public static void main(String[] args) {
        threeInOne();
    }

    public static void threeInOne() {

        final ThreeInOneStack threeInOneStack = new ThreeInOneStackImpl();

        System.out.println(threeInOneStack.empty(1));
        threeInOneStack.push(5, 1);
        System.out.println(threeInOneStack.empty(1));
        System.out.println(threeInOneStack.peek(1));
        threeInOneStack.pop(1);
        System.out.println(threeInOneStack.empty(1));
        System.out.println(threeInOneStack.peek(1));

        System.out.println(threeInOneStack.empty(2));
        threeInOneStack.push(5, 2);
        threeInOneStack.push(5, 2);
        threeInOneStack.push(5, 2);
        System.out.println(threeInOneStack.empty(2));
        System.out.println(threeInOneStack.peek(2));
        threeInOneStack.pop(2);
        System.out.println(threeInOneStack.empty(2));
        System.out.println(threeInOneStack.peek(2));

        System.out.println(threeInOneStack.empty(3));
        threeInOneStack.push(5, 3);
        threeInOneStack.push(5, 3);
        System.out.println(threeInOneStack.empty(3));
        System.out.println(threeInOneStack.peek(3));
        threeInOneStack.pop(3);
        System.out.println(threeInOneStack.empty(3));
        System.out.println(threeInOneStack.peek(3));
    }

    interface ThreeInOneStack {

        void pop(int stackNumber);

        void push(Integer value, int stackNumber);

        boolean empty(int stackNumber);

        Object peek(int stackNumber);
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

        public int getMid() {
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
        public void pop(final int stackNumber) {
            final Range range = checkRange(stackNumber);
            if (range.getHead() == range.min) {
                array[range.getHead()] = null;
            } else {
                array[range.getHead()] = null;
                range.setHead(range.getHead() - 1);
            }
        }

        @Override
        public void push(final Integer value, final int stackNumber) {
            final Range range = checkRange(stackNumber);
            if (array[range.min] == null) {
                array[range.getHead()] = value;
            } else {
                range.setHead(range.getHead() + 1);
                array[range.getHead()] = value;
            }
        }

        @Override
        public boolean empty(final int stackNumber) {
            final Range range = checkRange(stackNumber);
            if (array[range.min] == null) {
                return true;
            }
            return false;
        }

        @Override
        public Object peek(final int stackNumber) {
            final Range range = checkRange(stackNumber);
            return array[range.head];
        }

        public Range checkRange(final int stackNumber) {
            if (stackNumber == 1) {
                return firstStackRange;
            } else if (stackNumber == 2) {
                return secondStackRange;
            } else if (stackNumber == 3) {
                return thirdStackRange;
            } else {
                throw new IllegalArgumentException("" + stackNumber);
            }
        }
    }
}