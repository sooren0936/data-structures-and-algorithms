package crackingcodinginterview.StacksAndQueues;

import crackingcodinginterview.StacksAndQueues.myqueue.MyQueue;
import crackingcodinginterview.StacksAndQueues.myqueue.impl.MyQueueImplWithOneStack;
import crackingcodinginterview.StacksAndQueues.myqueue.impl.MyQueueImplWithTwoStacks;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */
public class D_QueueViaStacks {

    public static void main(String[] args) {
        queueViaStacks();
    }

    public static void queueViaStacks() {
        final MyQueue<Integer> myQueueWithOneStack = new MyQueueImplWithOneStack<>();

        System.out.println(myQueueWithOneStack.isEmpty());
        myQueueWithOneStack.add(3);
        myQueueWithOneStack.add(1);
        myQueueWithOneStack.add(2);
        myQueueWithOneStack.add(2);
        myQueueWithOneStack.add(2);
        myQueueWithOneStack.add(2);
        System.out.println(myQueueWithOneStack.peek());

        final MyQueue<Integer> myQueueImplWithTwoStacks = new MyQueueImplWithTwoStacks<>();

        System.out.println(myQueueImplWithTwoStacks.isEmpty());
        myQueueImplWithTwoStacks.add(3);
        myQueueImplWithTwoStacks.add(1);
        myQueueImplWithTwoStacks.add(2);
        myQueueImplWithTwoStacks.add(2);
        myQueueImplWithTwoStacks.add(2);
        myQueueImplWithTwoStacks.add(2);
        System.out.println(myQueueImplWithTwoStacks.peek());
    }
}


