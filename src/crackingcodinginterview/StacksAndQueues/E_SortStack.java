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

        final Stack<Integer> firstStack = new Stack<>();
        firstStack.push(1);
        firstStack.push(500);
        firstStack.push(3);
        firstStack.push(105);
        firstStack.push(3);
        firstStack.push(3);
        firstStack.push(-423);
        firstStack.push(553);
        firstStack.push(5);
        firstStack.push(4);
        firstStack.push(100);
        firstStack.push(4);
        firstStack.push(32);
        System.out.println(solutionNaive(firstStack));

        final Stack<Integer> secondStack = new Stack<>();
        secondStack.push(-1000);
        secondStack.push(1);
        secondStack.push(500);
        secondStack.push(3);
        secondStack.push(105);
        secondStack.push(3);
        secondStack.push(3);
        secondStack.push(-423);
        secondStack.push(553);
        secondStack.push(5);
        secondStack.push(4);
        secondStack.push(100);
        secondStack.push(4);
        secondStack.push(32);
        System.out.println(solutionShortVersion(secondStack));
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
                stackPop2 = null;
                if (stack.isEmpty()) {
                    additionalStack.push(stackPop1);
                }
            } else if (stackPop1 > stackPop2) {
                additionalStack.push(stackPop1);
                stackPop1 = stackPop2;
                stackPop2 = null;
                if (stack.isEmpty()) {
                    additionalStack.push(stackPop1);
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

    public static Stack<Integer> solutionShortVersion(final Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        final Stack<Integer> additionalStack = new Stack<>();

        while (!stack.empty()) {
            Integer stackPop = stack.pop();

            while (!additionalStack.empty() && additionalStack.peek() > stackPop) {
                stack.push(additionalStack.pop());
            }

            additionalStack.push(stackPop);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }

        return stack;
    }
}
