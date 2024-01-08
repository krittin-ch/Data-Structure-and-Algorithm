public class Queue {
    private Node lastNode;

    public Queue() {
        lastNode = null;
    }

    public boolean isEmpty() {
        return lastNode == null;
    }

    public void denqueueAll() {
        lastNode = null;
    }

    public void enqueue(int newItem) {
        Node newNode = new Node(newItem, lastNode);
        if(isEmpty()) {
            newNode.setNext(newNode);
        } else {
            newNode.setNext(lastNode.getNext());
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
    }

    public int dequeue() {
        if (!isEmpty()) {
            Node firstNode = lastNode.getNext();
            if(firstNode == lastNode) {
                lastNode = null;
            } else {
                lastNode.setNext(firstNode.getNext());
            }
            return firstNode.getItem();
        } else return -1;
    }

    public int peek() {
        if(!isEmpty()) {
            Node firstNode = lastNode.getNext();
            return firstNode.getItem();
        } else return -1;
    }
}