package crackingcodinginterview.repeat1.archive.LinkeLists.collection;

/**
 * 2.2 Return Kth to Last:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class ReturnKthToLast {
    public static void main(String[] args) {
        final LinkedListNode linkedListNode = new LinkedListNode(9);
        linkedListNode.appendToTail(1);
        linkedListNode.appendToTail(2);
        linkedListNode.appendToTail(3);
        linkedListNode.appendToTail(2);
        linkedListNode.appendToTail(9);
        linkedListNode.appendToTail(9);
        linkedListNode.appendToTail(9);
        linkedListNode.appendToTail(9);
        linkedListNode.appendToTail(9);
        linkedListNode.appendToTail(9);
        linkedListNode.appendToTail(1);
        linkedListNode.appendToTail(2);
        linkedListNode.appendToTail(55555);


        System.out.println(resultWithNodes(linkedListNode, 0));
    }

    public static LinkedListNode resultWithNodes(LinkedListNode linkedList, int k) {
        if (linkedList == null) {
            return linkedList;
        }

        LinkedListNode head = linkedList;
        while (k >= 0) {
            if (head.next != null) {
                throw new RuntimeException("Элементы не найдены");
            }
            head = head.next;
            k--;
        }

        return head;
    }
}
