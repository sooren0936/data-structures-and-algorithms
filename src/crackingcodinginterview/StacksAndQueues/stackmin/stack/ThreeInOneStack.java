package crackingcodinginterview.StacksAndQueues.stackmin.stack;

import crackingcodinginterview.StacksAndQueues.stackmin.model.enums.StackNumber;

public interface ThreeInOneStack {

    void push(Integer value, final StackNumber stackNumber);

    boolean pop(final StackNumber stackNumber);

    boolean empty(final StackNumber stackNumber);

    Object peek(final StackNumber stackNumber);

    Object min(final StackNumber stackNumber);
}
