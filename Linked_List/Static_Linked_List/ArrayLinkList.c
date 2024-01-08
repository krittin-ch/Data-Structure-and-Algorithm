#include <stdio.h>
#include <stdlib.h>

#define true 1
#define false 0
typedef int boolean;

struct ArrayNode {
    int item;
    int next;
};

#define MaxNode 10
int newNode;
int head = -1;
int curr;
int prev;
int Null = -1;
int countNode = 0;

struct ArrayNode node[MaxNode];

void createLinkList() {
    for(newNode=0; newNode<MaxNode; newNode++) {
        // Don't need to add "struct ArrayNode node[newNode]" because in C all are initialized as 0 or NULL, Unlike Java that all are null
        node[newNode].item = Null;
        node[newNode].next = Null;
    }
}

boolean isFull() {
    if(countNode != MaxNode) {
        return true;
    } else return false;
}

boolean findEmptyNode() {
    for(newNode=0; newNode<MaxNode; newNode++) {
        if(node[newNode].item == Null) {
            break;
        }
    }
    if(newNode == MaxNode) {
        return false;
    } else return true;
}

void add(int newItem) {
    if(isFull() && findEmptyNode()) {
        node[newNode].item = newItem;
        if(head != Null) {
            node[newNode].next = head;
        }
        head = newNode;
        countNode++;
    } else {
        printf("Array Link List is Full");
    }
}

boolean searchItem(int item) {
    curr = head;
    prev = Null;
    boolean status = false;
    while(curr!=Null) {
        if(node[curr].item==item) {
            status = true;
            break;
        }
        else {
            prev = curr;
            curr = node[curr].next;
        }
    }
    return status;
}

void deleteNode(int item) {
    if(searchItem(item)) {
        node[item].item = Null;
        if(prev == Null) {
            head = node[curr].next;
        } else {
            node[prev].next = node[curr].next;
        }
    } else {
        printf("Not found item");
    }
}

void insert(int insertItem, int newItem) {
    if(isFull() && findEmptyNode()) {
        node[newNode].item = newItem;
        countNode++;
        if(searchItem(insertItem)) {
            if(prev == Null) {
                node[newNode].next = curr;
                head = newNode;
            } else {
                node[prev].next = newNode;
                node[newNode].next = curr;
            }
        } else {
            if (head == Null) {
                head = newNode;
            } else if (curr == Null) {
                node[prev].next = newNode;
            }
        }
    } else printf("Array Link List is Full");
}

void showdata() {
    curr = head;
    while (curr!=Null) {
        printf("%d ", node[curr].item);
        curr = node[curr].next;
    }
    printf("\n");
}

void main() {
    createLinkList();
    add(1);
    add(2);
    add(3);
    showdata();
    insert(2, 7);
    showdata();
    
}