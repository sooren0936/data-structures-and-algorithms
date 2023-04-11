package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.Node;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
 * algorithm to create a binary search tree with minimal height.
 */
public class B_MinimalTree {

    public static void main(String[] args) {
        minimalTree();
    }

    public static void minimalTree() {
        int[] sortedArray = {1, 3, 5, 6, 9, 15, 30};
        solution(sortedArray, sortedArray.length / 2, sortedArray.length / 2, 0);
    }

    public static Node solution(int[] sortedArray, int position, int step, int count) {
        if (count > (int) Math.sqrt(sortedArray.length)) {
            return null;
        }
        step = (step + 1) / 2;
        Node childLeft = solution(sortedArray, position - step, step, count + 1);
        Node childRight = solution(sortedArray, position + step, step, count + 1);
        Node root = new Node(sortedArray[position], childLeft, childRight);

        return root;
    }
}