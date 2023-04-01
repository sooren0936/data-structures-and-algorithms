package crackingcodinginterview.StacksAndQueues.threeinone.model;

public class Range {

    private int min;
    private int max;
    private int head;

    public Range(int min, int max, int head) {
        this.min = min;
        this.max = max;
        this.head = head;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
}