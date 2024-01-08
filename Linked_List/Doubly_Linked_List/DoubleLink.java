package Doubly_Linked_List;

public class DoubleLink {
    private Object item;
    private DoubleLink next;
    private DoubleLink precede;

    public DoubleLink() {
        next = null;
        precede = null;
    }

    public DoubleLink(Object newItem) {
        item = newItem;
        next = null;
        precede = null;
    }

    public DoubleLink(Object newItem, DoubleLink nextNode, DoubleLink precedeNode) {
        item = newItem;
        next = nextNode;
        precede = precedeNode;
    }

    public void setItem(Object newItem) {
        item = newItem;
    }

    public Object getItem() {
        return item;
    }

    public void setNext(DoubleLink nextNode) {
        next = nextNode;
    }

    public DoubleLink getNext() {
        return next;
    }

    public void setPrecede(DoubleLink precedeNode) {
        precede = precedeNode;
    }

    public DoubleLink getPrecede() {
        return precede;
    }
}
