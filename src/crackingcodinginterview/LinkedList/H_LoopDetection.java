package crackingcodinginterview.LinkedList;

import crackingcodinginterview.LinkedList.collection.LinkedListSingleNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Loop Detection: Given a circular linked list,
 * implement an algorithm that returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 * EXAMPLE
 * Input: A - > B - > C - > D - > E - > C [the same C as earlier]
 * Output: C
 */
public class H_LoopDetection {

    public static void main(String[] args) {
        loopDetection();
    }

    public static void loopDetection() {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithNumberOfNode(makeTestLinkedList()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithLinkedList(makeTestLinkedList()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionFastSlowRunner(makeTestLinkedList()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionFastSlowRunnerSecondEdit(makeTestLinkedList()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static LinkedListSingleNode makeTestLinkedList() {
        final LinkedListSingleNode circular = new LinkedListSingleNode(5);

        LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(3);
        final LinkedListSingleNode head = linkedListSingleNode;

        linkedListSingleNode.next = new LinkedListSingleNode(1);
        linkedListSingleNode = linkedListSingleNode.next;

        linkedListSingleNode.next = new LinkedListSingleNode(222);
        linkedListSingleNode = linkedListSingleNode.next;

        linkedListSingleNode.next = new LinkedListSingleNode(333);
        linkedListSingleNode = linkedListSingleNode.next;

        linkedListSingleNode.next = circular;
        linkedListSingleNode = linkedListSingleNode.next;

        linkedListSingleNode.next = new LinkedListSingleNode(9);
        linkedListSingleNode = linkedListSingleNode.next;

        linkedListSingleNode.next = new LinkedListSingleNode(999);
        linkedListSingleNode = linkedListSingleNode.next;

        linkedListSingleNode.next = new LinkedListSingleNode(10);
        linkedListSingleNode = linkedListSingleNode.next;

        linkedListSingleNode.next = circular;
        return head;
    }

    public static Integer solutionWithNumberOfNode(LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return null;
        }

        final Set<LinkedListSingleNode> linkedLists = new HashSet<>();
        while (linkedListSingleNode != null) {

            if (linkedLists.contains(linkedListSingleNode)) {
                return linkedListSingleNode.data;
            }

            linkedLists.add(linkedListSingleNode);
            linkedListSingleNode = linkedListSingleNode.next;
        }

        return null;
    }

    public static LinkedListSingleNode solutionWithLinkedList(LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }

        final LinkedListSingleNode head = linkedListSingleNode;

        final Set<LinkedListSingleNode> linkedLists = new HashSet<>();
        while (linkedListSingleNode.next != null) {

            if (linkedLists.contains(linkedListSingleNode.next)) {
                linkedListSingleNode.next = null;
                return head;
            }

            linkedLists.add(linkedListSingleNode);
            linkedListSingleNode = linkedListSingleNode.next;
        }

        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionFastSlowRunner(LinkedListSingleNode head) {
        LinkedListSingleNode slow = head;
        LinkedListSingleNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;

        return slow.next;
    }

    public static LinkedListSingleNode solutionFastSlowRunnerSecondEdit(LinkedListSingleNode linkedListSingleNode) {
        if (linkedListSingleNode == null && linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }

        LinkedListSingleNode slowRunner = linkedListSingleNode;
        LinkedListSingleNode fastRunner = linkedListSingleNode;

        while (fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;

            if (fastRunner == slowRunner) {
                break;
            }
        }

        if (fastRunner == null || fastRunner.next == null) {
            return linkedListSingleNode;
        }

        slowRunner = linkedListSingleNode;
        while (fastRunner.next != slowRunner.next) {
            fastRunner = fastRunner.next;
            slowRunner = slowRunner.next;
        }

        fastRunner.next = null;

        return slowRunner.next;
    }
}














