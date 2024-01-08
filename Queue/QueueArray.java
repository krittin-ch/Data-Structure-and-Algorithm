// Queue with Circular Array

public class QueueArray {
    private final int MAX_QUEUE = 5;
    private int[] items;
    private int front, back, count;

    private QueueArray() {
        items = new int[MAX_QUEUE];
        front = 0;
        back = MAX_QUEUE-1;
        count = 0;
    }

    public boolean isEmpty() {
        return ((count == 0)&&(front == back));
    }

    public boolean isFull() {
        return ((count == MAX_QUEUE)&&(front == back));
    }

    public boolean enqueue(int newItem) {
        if(!isFull()) {
            back = (back+1)%MAX_QUEUE;
            items[back] = newItem;
            ++count;
            return true;
        } else return false;
    }

    public int dequeue() {
        if(!isEmpty()) {
            front = (front+1)%MAX_QUEUE;
            int queueFront = items[front];
            count--;
            return queueFront;
        } else return -1;
    }

    public void denqueueAll() {
        items = new int[MAX_QUEUE];
        front = 0;
        back = MAX_QUEUE-1;
        count = 0;
    }

    public int peek() {
        if(!isEmpty()) {
            return items[front];
        } else return -1;
    }
}
