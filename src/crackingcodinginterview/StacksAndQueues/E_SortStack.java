package crackingcodinginterview.StacksAndQueues;

import java.util.Stack;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
 */
public class E_SortStack {

    public static void main(String[] args) {
        sortStack();
    }

    public static void sortStack() {
        final Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(500);
        stack.push(3);
        stack.push(105);
        stack.push(3);
        stack.push(3);
        stack.push(-423);
        stack.push(553);
        stack.push(5);
        stack.push(4);
        stack.push(100);
        stack.push(4);
        stack.push(32);
        System.out.println(solutionNaive(stack));
    }

    public static Stack<Integer> solutionNaive(final Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        final Stack<Integer> additionalStack = new Stack<>();

        int count = 1;
        while (count != 0) {
            if (additionalStack.isEmpty()) {
                count = sortStacks(stack, additionalStack);
                if (count == 0) {
                    return additionalStack;
                }
            } else {
                count = sortStacksReverse(additionalStack, stack);
            }
        }

        return stack;
    }

    private static int sortStacks(Stack<Integer> stack, Stack<Integer> additionalStack) {
        Integer stackPop1 = stack.pop();
        Integer stackPop2 = stack.pop();
        int count = 0;

        while (!stack.empty()) {
            if (stackPop1 == null) {
                stackPop1 = stack.pop();
            } else if (stackPop2 == null) {
                stackPop2 = stack.pop();
            }

            if (stackPop1 < stackPop2) {
                count--;
                additionalStack.push(stackPop2);
                stackPop2 = stackPop1;
                stackPop1 = null;
                if (stack.isEmpty()) {
                    additionalStack.push(stackPop1);
                }
            } else if (stackPop1 > stackPop2) {
                count++;
                additionalStack.push(stackPop1);
                stackPop1 = null;
                if (stack.isEmpty()) {
                    additionalStack.push(stackPop2);
                }
            } else {
                additionalStack.push(stackPop2);
                stackPop2 = null;
                if (stack.isEmpty()) {
                    additionalStack.push(stackPop1);
                }
            }
        }
        return count;
    }

    private static int sortStacksReverse(Stack<Integer> stack, Stack<Integer> additionalStack) {
        Integer stackPop1 = stack.pop();
        Integer stackPop2 = stack.pop();
        int count = 0;

        while (!stack.empty()) {
            if (stackPop1 == null) {
                stackPop1 = stack.pop();
            } else if (stackPop2 == null) {
                stackPop2 = stack.pop();
            }

            if (stackPop1 < stackPop2 || stackPop1.equals(stackPop2)) {
                additionalStack.push(stackPop1);
                stackPop1 = null;
                if (stack.isEmpty()) {
                    additionalStack.push(stackPop2);
                }
            } else {
                count++;
                additionalStack.push(stackPop2);
                stackPop2 = null;
                if (stack.isEmpty()) {
                    additionalStack.push(stackPop1);
                }
            }
        }
        return count;
    }
}
