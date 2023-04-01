package crackingcodinginterview.StacksAndQueues;

import crackingcodinginterview.StacksAndQueues.stackmin.stack.ThreeInOneStack;
import crackingcodinginterview.StacksAndQueues.stackmin.stack.impl.ThreeInOneStackImpl;

import static crackingcodinginterview.StacksAndQueues.stackmin.model.enums.StackNumber.FIRST;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class B_StackMin {

    public static void main(String[] args) {
        stackMin();
    }

    public static void stackMin() {
        final ThreeInOneStack threeInOneStack = new ThreeInOneStackImpl(3);

        System.out.println(threeInOneStack.empty(FIRST));
        threeInOneStack.push(3, FIRST);
        threeInOneStack.push(1, FIRST);
        threeInOneStack.push(2, FIRST);
        System.out.println(threeInOneStack.min(FIRST));
    }
}