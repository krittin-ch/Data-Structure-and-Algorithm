#include <stdio.h>
#include <stdlib.h>
#include "KaryNode.h"

#define true 1
#define false 0
typedef int boolean;

struct KaryNode *root;
struct KaryNode *newNode;
struct KaryNode *parent;
int indexparent;
struct KaryNode * nodeDelete;
int indexDelete;
struct KaryNode *nodeChange;
int indexChange;
int indx;
int k = 3; // getK() - 1

boolean isEmpty() {
    return getItem(root, 0) == -1;
}

int checkItem(struct KaryNode *node, int newItem) {
    int indexfind;
    for (indexfind = 0; indexfind<k; indexfind++) {
        int item = getItem(node, indexfind);
        if ((newItem < item) || (item == -1)) {
            break;
        }
    }
    return indexfind;
}

void insertItem(struct KaryNode *node, int newItem) {
    indx = checkItem(node, newItem);
    if ((indx != k) && (getItem(node, indx) == -1)) {
        setItem(node, indx, newItem);
    } else {
        if (getChild(node, indx) == NULL) {
            newNode =createNode();
            setItem(newNode, 0, newItem);
            setChild(node, indx, newNode);
        } else {
            insertItem(getChild(node, indx), newItem);
        }
    }
}

struct KaryNode *insert(int newItem) {
    if (isEmpty()) {
        newNode = createNode();
        setItem(newNode, 0, newItem);
        root = newNode;
    } else {
        insertItem(root, newItem);
    }
    return root;
}

void search(struct KaryNode *node, int indx, int searchKey) {
    if (indx != k) {
        if (searchKey == getItem(node, indx)) {
            nodeDelete = node;
            indexDelete = indx;
        } else if (searchKey < getItem(node, indx)) {
            parent = node;
            indexparent = indx;
            node = getChild(node, indx);
            if (node != NULL) {
                search(node, 0, searchKey);
            } else {
                nodeDelete = NULL;
            }
        } else {
            search(node, indx += 1, searchKey);
        }
    } else {
        if (getChild(node, indx) != NULL) {
            parent = node;
            indexparent = indx;
            search(getChild(node, indx), 0, searchKey);
        }
    }
}

void inordersuccessor(struct KaryNode *node) {
    if (getChild(node, 0) != NULL) {
        parent = node;
        indexparent = 0;
        inordersuccessor(getChild(node, 0));
    } else {
        nodeChange = node;
    }
}

void preordersuccessor(struct KaryNode *node) {
    if (getChild(node, k) == NULL) {
        for (int count = k -1; count <= indx; count--) {
            if (getItem(node, count) != -1) {
                if (getChild(node, count+1) != NULL) {
                    parent = node;
                    indexparent = count;
                    preordersuccessor(getChild(node, count+1));
                } else {
                    nodeChange = node;
                    indexChange = count;
                    break;
                }
            }
        }
    } else {
        parent = node;
        indexparent = k;
        preordersuccessor(getChild(node, k));
    }
}

void deleteItems(struct KaryNode *node, int indx) {
    int Sibling = -1;
    struct KaryNode *ChildL = getChild(node, indx);
    struct KaryNode *ChildR = getChild(node, indx+1);
    if (indx != k-1) {
        Sibling = getItem(node, indx+1); // Sibling is the node next to the current node
    }
    if ((ChildL == NULL) && (ChildR == NULL) && (Sibling == -1) && (indexDelete == 0)) { // Contains only 1 item (and delete that item) make the chil of parent node NULL
        setChild(parent, indexparent, NULL);
    } else if ((ChildL == NULL) && (ChildR == NULL) && (Sibling == -1)) { // The rightmost item. Deleting does not affect others
        setItem(nodeDelete, indexDelete, -1);
    } else if ((ChildL == NULL) && (ChildR == NULL) && (Sibling != -1)) { // The item between the node, substitute next item in the current item
        for (int count = indx; count < k-1; count++) {
            setItem(node, count, getItem(node, count+1));
            setChild(node, count, getChild(node, count+1));
        }
        if (getChild(node, k) != NULL) {
            struct KaryNode *child = getChild(node, k);
            setItem(node, k-1, getItem(child, 0));
            parent = node;
            indexparent = k;
            indexDelete = 0;
            deleteItems(child, 0);
        } else {
        setItem(node, k-1, -1);
        }
    } else if ((ChildL != NULL) && (ChildR != NULL)) {
        parent = node;
        indexparent = indx;
        inordersuccessor(ChildR);
        setItem(nodeDelete, indexDelete, getItem(nodeChange, 0));
        nodeDelete = nodeChange;
        indexDelete = 0;
        deleteItems(nodeDelete, 0);
    } else {
        if((Sibling == -1) && (indexDelete == 0)) { 
            setChild(parent, indexparent, getChild(node, 0));
        } else if (ChildL != NULL) {
            parent = node;
            indexparent = indx;
            preordersuccessor(ChildL);
            setItem(nodeDelete, indexDelete, getItem(nodeChange, indexChange));
            nodeDelete = nodeChange;
            indexDelete = indexChange;
            deleteItems(nodeDelete, indexChange);
        } else {
            parent = node;
            indexparent = indx;
            inordersuccessor(ChildR);
            setItem(nodeDelete, indexDelete, getItem(nodeChange, 0));
            nodeDelete = nodeChange;
            indexDelete = 0;
            deleteItems(nodeDelete, 0);
        }
    }
}

void deleteNode(int deleteItem) {
    if (isEmpty()) {
        printf("Tree Empty\n");
    } else {
        parent = root;
        indexparent = 0;
        nodeDelete = NULL;
        search(root, 0, deleteItem);
        if (nodeDelete == NULL) {
            printf("Not Found Data\n");
        } else {
            deleteItems(nodeDelete, indexDelete);
        }
    }
}

void preOrder(struct KaryNode *rootNode) {
    int count;
    if (rootNode != NULL) {
        for (count=0; count < k; count++) {
            if (getItem(rootNode, count) != -1) {
                printf("%d ", getItem(rootNode, count));
            }
            preOrder(getChild(rootNode, count));
        }
        preOrder(getChild(rootNode, count));
    }
}

int main() {
    struct KaryNode *root = createNode();
    root = insert(30);
    insert(40);
    insert(50);
    insert(25);
    preOrder(root);
    return 0;
}