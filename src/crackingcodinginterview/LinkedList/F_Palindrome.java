package crackingcodinginterview.LinkedList;

import crackingcodinginterview.LinkedList.collection.LinkedListSingleNode;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome
 */
public class F_Palindrome {

    public static void main(String[] args) {
        palindrome();
    }

    public static void palindrome() {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solution(makeTestLinkedList()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static LinkedListSingleNode makeTestLinkedList() {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(1);
        linkedListSingleNode.appendToTail(2);
        linkedListSingleNode.appendToTail(2);
        return linkedListSingleNode;
    }

    public static Boolean solution(LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return false;
        }

        final StringBuilder sb = new StringBuilder();
        while (linkedListSingleNode != null) {
            int data = linkedListSingleNode.data;
            sb.append(data);

            linkedListSingleNode = linkedListSingleNode.next;
        }
        final String forward = sb.toString();
        final String backward = sb.reverse().toString();

        return forward.equals(backward);
    }
}