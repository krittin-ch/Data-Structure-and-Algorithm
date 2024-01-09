#ifndef KaryNode_H
#define KaryNode_H

#include <stdio.h>
#include <stdlib.h>

#define K 4

struct KaryNode {
    int item[K-1];
    struct KaryNode *child[K];
};

struct KaryNode *createNode() {
    struct KaryNode *newNode;
    newNode = (struct KaryNode *)malloc(sizeof(struct KaryNode));
    int count;
    for (count = 0; count < K-1; count++) {
        newNode->item[count] = -1;
        newNode->child[count] = NULL;
    }
    newNode->child[count] = NULL;
    return newNode;
}

int getK() {
    return K;
}

int getItem(struct KaryNode *node, int indx) {
    if (node != NULL && indx >= 0 && indx < K-1) {
        return node->item[indx];
    } else {
    return -1;
    }
}


void setItem(struct KaryNode *node, int indx, int newItem) {
    node->item[indx] = newItem;
}

struct KaryNode *getChild(struct KaryNode *node, int indx) {
    return node->child[indx];
}

void setChild(struct KaryNode *node, int indx, struct KaryNode *nextNode) {
    node->child[indx] = nextNode;
}

#endif