package crackingcodinginterview.LinkedList;

import crackingcodinginterview.LinkedList.collection.LinkedListSingleNode;

/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class D_Partition {

    public static void main(String[] args) {
        partition();
    }

    public static void partition() {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithLeftAndRightLinkedLists(makeTestLinkedList(), 5));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithHeadAndTail(makeTestLinkedList(), 5));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static LinkedListSingleNode makeTestLinkedList() {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(3);
        linkedListSingleNode.appendToTail(5);
        linkedListSingleNode.appendToTail(8);
        linkedListSingleNode.appendToTail(5);
        linkedListSingleNode.appendToTail(10);
        linkedListSingleNode.appendToTail(2);
        linkedListSingleNode.appendToTail(1);
        return linkedListSingleNode;
    }

    public static LinkedListSingleNode solutionWithLeftAndRightLinkedLists(final LinkedListSingleNode linkedListSingleNode, final int partition) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }

        LinkedListSingleNode head = linkedListSingleNode;
        LinkedListSingleNode leftPartitionHead = null;
        LinkedListSingleNode rightPartitionHead = null;

        LinkedListSingleNode leftPartition = null;
        LinkedListSingleNode rightPartition = null;

        while (head != null) {

            if (head.data < partition) {
                if (leftPartitionHead == null) {
                    leftPartitionHead = new LinkedListSingleNode(head.data);
                    leftPartition = leftPartitionHead;
                } else {
                    leftPartition.next = new LinkedListSingleNode(head.data);
                    leftPartition = leftPartition.next;
                }
            } else {
                if (rightPartitionHead == null) {
                    rightPartitionHead = new LinkedListSingleNode(head.data);
                    rightPartition = rightPartitionHead;
                } else {
                    rightPartition.next = new LinkedListSingleNode(head.data);
                    rightPartition = rightPartition.next;
                }
            }

            head = head.next;
        }

        leftPartition.next = rightPartitionHead;
        return leftPartitionHead;
    }

    public static LinkedListSingleNode solutionWithHeadAndTail(LinkedListSingleNode linkedListSingleNode, final int partition) {
        if (linkedListSingleNode == null || linkedListSingleNode.next == null) {
            return linkedListSingleNode;
        }

        LinkedListSingleNode head = linkedListSingleNode;
        LinkedListSingleNode tail = linkedListSingleNode;

        while (linkedListSingleNode != null) {

            LinkedListSingleNode next = linkedListSingleNode.next;
            if (linkedListSingleNode.data < partition) {
                linkedListSingleNode.next = head;
                head = linkedListSingleNode;
            } else {
                tail.next = linkedListSingleNode;
                tail = linkedListSingleNode;
            }
            linkedListSingleNode = next;
        }
        tail.next = null;

        return head;
    }
}