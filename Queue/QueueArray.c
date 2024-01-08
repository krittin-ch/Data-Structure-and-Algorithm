#define MAX_QUEUE 5
#define true 1
#define false 0
typedef int boolean;
int items[MAX_QUEUE];
int front = 0;
int back = MAX_QUEUE-1;
int count = 0;

boolean isEmpty() {
    return ((count == 0)&&(front == back));
}

boolean isFull() {
    return ((count == MAX_QUEUE)&&(front == back));
}

boolean enqueue(int newItem) {
    if(!isFull()) {
        back = (back+1)%MAX_QUEUE;
        items[back] = newItem;
        ++count;
        return true;
    } else return false;
}

int deque() {
    if(!isEmpty()) {
        front = (front+1)%MAX_QUEUE;
        int queueFront = items[front];
        count--;
        return queueFront;
    } else return -1;
}

void dequeueAll() {
    front = 0;
    back = MAX_QUEUE-1;
    count = 0;
}

int peek() {
    if(!isEmpty()) return items[front];
    else return -1;
}