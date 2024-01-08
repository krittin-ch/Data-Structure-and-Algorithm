public class Node {
    private Node next;
    private int item;
    
    public Node() {
        next = null;
    }

    public Node(int newItem) {
        item = newItem;
    }

    public Node(int newItem, Node nextNode) {
        item = newItem;
        next = nextNode;
    }

    public void setItem(int newItem) {
        item = newItem;
    }

    public int getItem() {
        return item;
    }

    public void setNext(Node nextNode) {
        next = nextNode;
    }

    public Node getNext() {
        return next;
    }
}
