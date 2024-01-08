#include "C:\\Users\\kritt\\Documents\\Personal_Project\\Data_Structure_and_Algorithm\\Linked_List\\Singly_Linked_List\\Node.h"
#include <stdio.h>

#define true 1
#define false 0
typedef int boolean;
struct Node *lastNode = NULL;

boolean isEmpty() {
    if(lastNode == NULL) {
        return true;
    } else return false;
}

void dequeueAll() {
    lastNode = NULL;
}

void enqueue(int newItem) {
    struct Node *newNode;
    newNode = createNode(newItem, NULL);
    if(isEmpty()) {
        setNext(newNode, newNode);
    } else {
        setNext(newNode, getNext(lastNode));
        setNext(lastNode, newNode);
    }
    lastNode = newNode;
}

int dequeue() {
    if(!isEmpty()) {
        struct Node *firstNode;
        firstNode = getNext(lastNode);
        if(firstNode == lastNode) {
            lastNode = NULL;
        } else {
            setNext(lastNode, getNext(firstNode));
        }
        return getItem(firstNode);
    } else return -1; 
}

int peek() {
    if(!isEmpty()) {
        struct Node *firstNode;
        firstNode = getNext(lastNode);
        return getItem(firstNode);
    } else return -1;
}

void main() {
    for(int i=0; i<9; i++) {
        enqueue(i);
    }
    while (!isEmpty())
    {
        printf("%d \n", dequeue());
    }
    
}