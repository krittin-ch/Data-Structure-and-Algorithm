#ifndef DOUBLELINK_H
#define DOUBLELINK_H

#include <stdlib.h>

struct DoubleLink {
    int item;
    struct DoubleLink *next;
    struct DoubleLink *precede;
};

struct DoubleLink *createNode(int item, struct DoubleLink *next, struct DoubleLink *precede) {
    struct DoubleLink *node;
    node = (struct DoubleLink *)malloc(sizeof(struct DoubleLink));
    node->item = item;
    node->next = next;
    node->precede = precede;
    return node;
}

void setItem(struct DoubleLink *node, int newItem) {
    node->item = newItem;
}

int getItem(struct DoubleLink *node) {
    return node->item;
}

void setNext(struct DoubleLink *node, struct DoubleLink *nextNode) {
    node->next = nextNode;
}

struct DoubleLink *getNext(struct DoubleLink *node) {
    return node->next;
}

void setPrecede(struct DoubleLink *node, struct DoubleLink *precedeNode) {
    node->precede = precedeNode;
}

struct DoubleLink *getPrecede(struct DoubleLink *node) {
    return node->precede;
}

#endif