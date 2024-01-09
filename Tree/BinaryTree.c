#include "C:\Users\kritt\Documents\Personal_Project\Data_Structure_and_Algorithm\Tree\TreeNode.h"
#include <stdio.h>

#define true 1
#define false 0
typedef int boolean;


struct TreeNode *root;
struct TreeNode *newNode;
struct TreeNode *parent;
struct TreeNode *NodeDelete;
char child;
int countLevel;

boolean isEmpty() {
    return root == NULL;
}


void insertItem(struct TreeNode *bst, int newItem) { // Place newItem on left child if newItem < bst and place newItem on right child if newItem < bst.
    if (newItem < getItem(bst)) {
        if (getLChild(bst) == NULL) {
            newNode = createNode(newItem);
            setLChild(bst, newNode);
        } else {
            insertItem(getLChild(bst), newItem);
        }
    } else {
        if (getRChild(bst) == NULL) {
            newNode = createNode(newItem);
            setRChild(bst, newNode);
        } else {
            insertItem(getRChild(bst), newItem);
        }
    }
}

struct TreeNode *insert(int newItem) { // Create root when empty. If not insertItem
    if (isEmpty()) {
        newNode = createNode(newItem);
        root = newNode;
    } else {
        insertItem(root, newItem);
    }
}

void search(struct TreeNode *bst, int searchKey) { // Finding the node to delete
    if (getItem(bst) == searchKey) {
        NodeDelete = bst;
    } else {
        if (searchKey < getItem(bst)) {
            parent = bst;
            child = 'l';
            search(getLChild(bst), searchKey);
        } else {
            parent = bst;
            child = 'r';
            search(getRChild(bst), searchKey);
        }
    }
}

void inordersuccessor(struct TreeNode *bst) {
    if (getLChild(bst) !=   NULL) {
        countLevel++;
        parent = bst;
        inordersuccessor(getLChild(bst));
    } else {
        NodeDelete = getRChild(bst);
        if (countLevel == 0) {
            setRChild(root, NULL);
        } else {
            setLChild(parent, NULL);
        }
    }
}

void deleteItem(int deleteItem) {
    if (isEmpty()) {
        println("Tree Empty");
    } else {
        parent = root;
        NodeDelete = NULL;
        search(parent, deleteItem);
        struct TreeNode *lChild = createNode(getLChild(NodeDelete));
        struct TreeNode *rChild = createNode(getRChild(NodeDelete));

        if ((lChild == NULL) && (rChild == NULL)) {
            if (child == 'l') {
                setLChild(parent, NULL);
            } else {
                setRChild(parent, NULL);
            }
        } else if ((lChild != NULL) && (rChild != NULL)) {
            countLevel = 0;
            inordersuccessor(getRChild(NodeDelete));
        } else {
            if (getLChild(NodeDelete) != NULL) {
                if (child = 'l') {
                    setLChild(parent, getLChild(NodeDelete));
                } else {
                    setRChild(parent, getLChild(NodeDelete));
                }
            } else {
                if (child = 'l') {
                    setLChild(parent, getRChild(NodeDelete));
                } else {
                    setRChild(parent,getRChild(NodeDelete));
                }
            }
        }
    }
}

void preOrder(struct TreeNode *node) {
    if(node != NULL) {
        printf("%d ", getItem(node));
        preOrder(getLChild(node));
        preOrder(getRChild(node));
    }
}

void inOrder(struct TreeNode *node) {
    if(node != NULL) {
        preOrder(getLChild(node));
        printf("%d ", getItem(node));
        preOrder(getRChild(node));
    }
}

void postOrder(struct TreeNode *node) {
    if(node != NULL) {
        preOrder(getLChild(node));
        preOrder(getRChild(node));
        printf("%d ", getItem(node));
    }
}