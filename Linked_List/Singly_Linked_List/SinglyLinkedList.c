#include "C:\\Users\\kritt\\Documents\\Personal_Project\\Data_Structure_and_Algorithm\\Linked_List\\Singly_Linked_List\\Node.h"
#include <stdio.h>

#define true 1;
#define false 0;
typedef int boolean;

struct Node *newNode;
struct Node *head;
struct  Node *curr;
struct Node * prev;

void add(int newItem) {
    if(head == NULL) {
        newNode = createNode(newItem, NULL);
    }
    else {
        newNode = createNode(newItem, head);
    }
    head = newNode;
}

boolean searchItem(int item) {
    prev = NULL;
    curr = head;
    boolean status = false;

    while (curr != NULL) {
        if(getItem(curr) == item) {
            status = true;
            break;
        }
        else {
            prev = curr;
            curr = getNext(curr);
        }
    }
    return status;
}

void deleteNode(int item) {
    if(searchItem(item)) {
        if(prev == NULL) {
            head = getNext(curr);
        }
        else {
            setNext(prev, getNext(curr));
        }
    }
    else {
        printf("Not found item");
    }
}

void insert(int insertitem, int newItem) {
    if(searchItem(insertitem)) {
        if(prev == NULL) {
            newNode = createNode(newItem, head);
            head = newNode;
        }
        else {
            newNode = createNode(newItem, curr);
            setNext(prev, newNode);
        }
    }
    else {
        if(head == NULL) {
            newNode = createNode(newItem, NULL);
            head = newNode;
        }
        else {
            printf("Not found item");
        }
    }
}

void showdata() {
    curr = head;
    while (curr != NULL) {
        printf("%d ", getItem(curr));
        curr = getNext(curr);
    }
    printf("\n");
}

void main() {
    add(9); // from head == NULL to getItem(head) == 9;
    add(100);
    showdata();
    insert(9, 123);
    showdata();
}