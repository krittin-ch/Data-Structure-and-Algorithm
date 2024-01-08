public class StackArrayBased {
    final int MAX_STACK = 50; // "final" cannot change the value of variable
    private int item[];
    private int top;
    
    public StackArrayBased() {
        item = new int[MAX_STACK];
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == MAX_STACK - 1;
    }

    public boolean push(int newItem) {
        if(!isFull()) {
            item[++top] = newItem;
            return true;
        } else {
            return false;
        }
    }

    public void popAll() {
        item = new int[MAX_STACK];
        top = -1;
    }

    public int pop() {
        if(!isEmpty()) {
            return item[top--];
        } else {
            return -1;
        }
    }

    public int peek() {
        if(!isEmpty()) {
            return item[top];
        } else {
            return -1;
        }
    }
}
