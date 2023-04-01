package crackingcodinginterview.StacksAndQueues;

import crackingcodinginterview.StacksAndQueues.threeinone.stack.ThreeInOneStack;
import crackingcodinginterview.StacksAndQueues.threeinone.stack.impl.ThreeInOneStackImpl;

import static crackingcodinginterview.StacksAndQueues.threeinone.model.enums.StackNumber.*;

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
}