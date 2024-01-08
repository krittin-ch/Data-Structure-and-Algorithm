#include "C:\\Users\\kritt\\Documents\\Personal_Project\\Data_Structure_and_Algorithm\\Linked_List\\Singly_Linked_List\\Node.h"
#include <stdio.h>

#define true 1
#define false 0
typedef int boolean;
struct Node *top = NULL;

boolean isEmpty() {
    if(top == NULL) return true;
    else return false;
}

void push(int newItem) {
    top = createNode(newItem, top);
}

int pop() {
    if(!isEmpty()) {
        struct Node *temp = top;
        top = getNext(top);
        return getItem(temp);
    } else return -1;
}

void popAll() {
    top = NULL;
}

int peek() {
    if(!isEmpty()) return getItem(top);
    else return -1;
}