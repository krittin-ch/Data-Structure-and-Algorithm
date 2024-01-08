#include "C:\\Users\\kritt\\Documents\\Personal_Project\\Data_Structure_and_Algorithm\\Linked_List\\Doubly_Linked_List\\DoubleLink.h"
#include <stdio.h>

struct DoubleLink *newNode;
struct DoubleLink *head;
struct DoubleLink *last;
struct DoubleLink *curr;
struct DoubleLink *prev1;
struct DoubleLink *prev2;
#define true 1  
#define false 0
typedef int boolean;

void add(int newItem) {
    newNode = createNode(newItem, NULL, NULL);
    if(head == NULL) {
        last = newNode;
    }
    else {
        setNext(newNode, head);
        setPrecede(head, newNode);
    }
    head = newNode;
}

boolean searchItem(int item) {
    curr = head;
    prev1 = NULL;
    prev2 = NULL;
    boolean status = false;
    while(curr != NULL) {
        if(getItem(curr) == item) {
            status = true;
            prev2 = getNext(curr);
            break;
        } 
        else {
            prev1 = curr;
            curr = getNext(curr);
        }
    }
    return status;
}

void deleteNode(int item) {
    if(searchItem(item)) {
        if(prev1 == NULL) {
            head = getNext(curr);
            setPrecede(prev2, NULL);
        }
        else if(prev2 == NULL) {
            setNext(prev1, NULL);
            setPrecede(curr, NULL);
            last = prev1;
        }
        else {
            setNext(prev1, prev2);
            setPrecede(prev2, prev1);
        }
    }
    else {
        printf("Not found item");
    }
}

void insertItem(int insertItem, int newItem) {
    prev2 = curr;
    newNode = createNode(newItem, NULL, NULL);
    
    if(searchItem(insertItem)) {
        if(prev1 == NULL) {
            setNext(newNode, curr);
            setPrecede(curr, newNode);
            head = newNode;
            if(prev2 != NULL) {
                setPrecede(prev2, newNode);
            }
        }
        else {
            setNext(prev1, newNode);
            setNext(newNode, prev2);
            setPrecede(newNode, prev1);
            setPrecede(prev2, newNode);
        }
    }
    else {
        if(head == NULL) {
            head = newNode;
            last = newNode;
        }
        else {
            setPrecede(newNode, last);
            setNext(last, newNode);
            last = newNode;
        }
    }
}

void showdata() {
    curr = head;
    while(curr != NULL) {
        printf("%d ", getItem(curr));
        curr = getNext(curr);
    }
}

void main() {
    add(10);
    add(11);
    add(12);
    insertItem(11, 5);
    insertItem(123, 2);
    showdata();
}