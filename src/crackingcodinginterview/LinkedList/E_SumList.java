package crackingcodinginterview.LinkedList;

import crackingcodinginterview.LinkedList.collection.LinkedListSingleNode;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 */
public class E_SumList {

    public static void main(String[] args) {
        sumList();
    }

    public static void sumList() {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionReverse(makeFirstTestLinkedList(), makeSecondTestLinkedList()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionStraight(makeFirstTestLinkedList(), makeSecondTestLinkedList()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static LinkedListSingleNode makeFirstTestLinkedList() {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(7);
        linkedListSingleNode.appendToTail(1);
        linkedListSingleNode.appendToTail(6);
        return linkedListSingleNode;
    }

    private static LinkedListSingleNode makeSecondTestLinkedList() {
        final LinkedListSingleNode linkedListSingleNode = new LinkedListSingleNode(5);
        linkedListSingleNode.appendToTail(9);
        linkedListSingleNode.appendToTail(2);
        return linkedListSingleNode;
    }

    private static StringBuilder extractDigits(LinkedListSingleNode firstLinkedList) {
        final StringBuilder firstSbValue = new StringBuilder();
        while (firstLinkedList != null) {
            firstSbValue.append(firstLinkedList.data);
            firstLinkedList = firstLinkedList.next;
        }
        return firstSbValue;
    }

    public static LinkedListSingleNode solutionReverse(LinkedListSingleNode firstLinkedList, LinkedListSingleNode secondLinkedList) {
        if (firstLinkedList == null || secondLinkedList == null) {
            return firstLinkedList;
        }

        final StringBuilder firstSbValue = extractDigits(firstLinkedList);
        final StringBuilder secondSbValue = extractDigits(secondLinkedList);

        final String firstStringValue = firstSbValue.reverse().toString();
        final Integer firstValue = Integer.valueOf(firstStringValue);

        final String secondStringValue = secondSbValue.reverse().toString();
        final Integer secondValue = Integer.valueOf(secondStringValue);

        final int total = firstValue + secondValue;
        final String totalString = Integer.toString(total);
        final String[] digits = totalString.split("");

        return makeResultLinkedListReverse(digits);
    }

    private static LinkedListSingleNode makeResultLinkedListReverse(String[] digits) {
        LinkedListSingleNode resultLinkedList = null;
        LinkedListSingleNode resultLinkedListHead = resultLinkedList;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (resultLinkedList == null) {
                resultLinkedList = new LinkedListSingleNode(Integer.parseInt(digits[i]));
                resultLinkedListHead = resultLinkedList;
            } else {
                resultLinkedList.next = new LinkedListSingleNode(Integer.parseInt(digits[i]));
                resultLinkedList = resultLinkedList.next;
            }
        }
        return resultLinkedListHead;
    }

    public static LinkedListSingleNode solutionStraight(LinkedListSingleNode firstLinkedList, LinkedListSingleNode secondLinkedList) {
        if (firstLinkedList == null || secondLinkedList == null) {
            return firstLinkedList;
        }

        final StringBuilder firstSbValue = extractDigits(firstLinkedList);
        final StringBuilder secondSbValue = extractDigits(secondLinkedList);

        final String firstStringValue = firstSbValue.toString();
        final Integer firstValue = Integer.valueOf(firstStringValue);

        final String secondStringValue = secondSbValue.toString();
        final Integer secondValue = Integer.valueOf(secondStringValue);

        final int total = firstValue + secondValue;
        final String totalString = Integer.toString(total);
        final String[] digits = totalString.split("");

        return makeResultLinkedListStraight(digits);
    }

    private static LinkedListSingleNode makeResultLinkedListStraight(final String[] digits) {
        LinkedListSingleNode resultLinkedList = null;
        LinkedListSingleNode resultLinkedListHead = resultLinkedList;

        for (String digit : digits) {
            if (resultLinkedList == null) {
                resultLinkedList = new LinkedListSingleNode(Integer.parseInt(digit));
                resultLinkedListHead = resultLinkedList;
            } else {
                resultLinkedList.next = new LinkedListSingleNode(Integer.parseInt(digit));
                resultLinkedList = resultLinkedList.next;
            }
        }
        return resultLinkedListHead;
    }
}