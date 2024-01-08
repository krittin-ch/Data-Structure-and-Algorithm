// Singly Linked-List

#ifndef NODE_H
#define NODE_H

#include <stdlib.h>
// Structure Linked-List


struct Node {
    int item;
    struct Node *next;
};

struct Node *createNode(int newItem, struct Node *nextNode) {
    struct Node *newNode;
    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->item = newItem;
    newNode->next = nextNode;
    return newNode;
}

void setItem(struct Node *node, int newItem) {
    node->item = newItem;
}

void setNext(struct Node *node, struct Node *nextNode) {
    node->next = nextNode;
}

int getItem(struct Node *node) {
    return node->item;
}

struct Node *getNext(struct Node *node) {
    return node->next;
}








// //'struct Node *' indicate the pointer to a 'struct Node'
// // For example, 'struct Node *next' indicate that 'next' is a pointer to 'struct Node'
// struct Node { // The amount of memory (in bytes) is sizeof(int) + sizeof(struct Node *)
//     int item;
//     struct Node *next; // next is the pointer to Node
// };

// struct Node *createNode(int newItem, struct Node *nextNode) {
//     struct Node *newNode; // create new node name newNode to store newItem and nextNode
//     newNode = (struct Node *)malloc(sizeof(struct Node));
//     newNode->item = newItem;
//     newNode->next = nextNode;
//     return newNode;
// }

// void setItem(struct Node *node, int newItem) {
//     node->item = newItem;
// }
// int getItem(struct Node *node) {
//     return node->item;
// }

// void setNext(struct Node *node, struct Node *nextNode) {
//     node->next = nextNode;
// }
// struct Node *getNext(struct Node *node) {
//     return node->next;
// 		} 

#endif 