#ifndef TreeNode_H
#define TreeNode_H

// Declarations go here

#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int item;
    struct TreeNode *lChild;
    struct TreeNode *rChild;
};

struct TreeNode *createNode(int newItem) {
    struct TreeNode *newNode;
    newNode = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    newNode->item = newItem;
    newNode->lChild = NULL;
    newNode->rChild = NULL;
    return newNode;
}

struct TreeNode *createNode(int newItem, struct TreeNode *nextLChild, struct TreeNode *nextRChild) {
    struct TreeNode *newNode;
    newNode = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    newNode->item = newItem;
    newNode->lChild = nextLChild;
    newNode->rChild = nextRChild;
    return newNode;
}

void setItem(struct TreeNode *node, int newItem) {
    node->item = newItem;
}

int getItem(struct TreeNode *node) {
    return node->item;
}

void setLChild(struct TreeNode *node, struct TreeNode *nextLChild) {
    node->lChild = nextLChild;
}

struct TreeNode *getLChild(struct TreeNode *node) {
    return node->lChild;
}

void setRChild(struct TreeNode *node, struct TreeNode *nextRChild) {
    node->rChild = nextRChild;
}

struct TreeNode *getRChild(struct TreeNode *node) {
    return node->rChild;
}


#endif