public class StackLinkedList {
    private Node top;

    public StackLinkedList() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int newItem) {
        top = new Node(newItem, top);
    }

    public int pop() {
        if(!isEmpty()) {
            Node temp = top;
            top = top.getNext();
            return temp.getItem();
        } else return -1;
    }

    public void popAll() {
        top = null;
    }

    public int peek() {
        if (!isEmpty()) {
            return top.getItem();
        } else return -1;
    }
}
