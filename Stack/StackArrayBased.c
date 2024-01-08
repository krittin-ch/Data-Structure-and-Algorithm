#define MAX_STACK 50
#define true 1
#define false 0
typedef int boolean;
int item[MAX_STACK];
int top = -1;

boolean isEmpty() {
    return top < 0;
}

boolean isFull() {
    return top == MAX_STACK-1;
}

boolean push(int newItem) {
    if(!isFull()) {
        item[++top] = newItem;
        return true;
    } else return false;
}

void popAll() {
    int item[MAX_STACK];
    top = -1;
}

int pop() {
    if(!isEmpty()) return item[top--];
    else return -1;
}

int peek() {
    if(!isEmpty()) return item[top];
    else return -1;
}

void main() {
    int MAX_ITEMS = 15;
    int items[15];
    for(int i=0; i<MAX_ITEMS; i++) {
        items[i] = i;
        if(!isFull()) push(items[i]);
    }
    while(!isEmpty()) {
        printf("%d \n", pop());
    }
}