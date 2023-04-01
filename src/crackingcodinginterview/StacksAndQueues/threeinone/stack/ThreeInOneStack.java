package crackingcodinginterview.StacksAndQueues.threeinone.stack;

import crackingcodinginterview.StacksAndQueues.threeinone.model.enums.StackNumber;

public interface ThreeInOneStack {

    void push(Integer value, final StackNumber stackNumber);

    boolean pop(final StackNumber stackNumber);

    boolean empty(final StackNumber stackNumber);

    Object peek(final StackNumber stackNumber);
}
