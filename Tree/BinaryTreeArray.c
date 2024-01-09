#include <stdlib.h>
#include <stdio.h>
#define true 1
#define false 0
typedef int boolean;

struct TreeArray {
    int item;
    int lChild;
    int rChild;
};

int MaxNode = 10;
int root = -1;
int Null = -1;
int newNode;
int countNode = 0;
int parent;
int NodeDelete;
char child;
int countLevel;
struct TreeArray node[10];

void createTreeArray() {
    for (newNode=0; newNode<MaxNode; newNode++) {
        node[newNode].item = Null;
        node[newNode].lChild = Null; 
        node[newNode].rChild = Null;
    }
}

boolean isFull() {
    return countLevel != MaxNode;
}

boolean isEmpty() {
    return root == Null;
}

boolean FindEmptyNode() {
    newNode = 0;
    for (newNode = 0; newNode<MaxNode; newNode++) {
        if (node[newNode].item == Null) {
            break;
        }
    }
    return newNode != MaxNode;
}

void insertItem(int root, int newItem) {
    if (newItem < node[root].item) {
        if(node[root].lChild == Null) {
            node[root].lChild = newNode;
        } else {
            insertItem(node[root].lChild, newItem);
        }
    } else {
        if (node[root].rChild == Null) {
            node[root].rChild = newNode;
        } else {
            insertItem(node[root].rChild, newItem);
        }
    }
}

void insert(int newItem) {
    if (isFull() && FindEmptyNode()) {
        node[newNode].item = newItem;
        if (root != Null) {
            insertItem(root, newItem);
        } else {
            root = newNode;
        }
        countLevel++;
    } else {
        printf("Tree Array is Full");
    }
}

void search(int root,int searchKey) {
    if (searchKey == node[root].item) {
        NodeDelete = root;
    } else if (searchKey < node[root].item) {
        parent = root;
        child = 'l';
        search(node[root].lChild, searchKey);
    } else {
        parent = root;
        child = 'r';
        search(node[root].rChild, searchKey);
    }
}

void inordersuccessor(int root) {
    if (node[root].lChild != Null) {
        parent = root;
        ++countLevel;
        inordersuccessor(node[root].lChild);
    } else {
        node[NodeDelete].item = node[root].item;
        if (countLevel == 0) {
            node[NodeDelete].item = Null;
        } else {
            node[parent].item = Null;
        }
    }
}

void deleteItem(int deleteItem) {
    if (isEmpty()) {
        printf("Tree Empty\n");
    } else {
        parent = root;
        NodeDelete = Null;
        search(root, deleteItem);
        int lChild = node[NodeDelete].lChild;
        int rChild = node[NodeDelete].rChild;
        if ((lChild == Null) && (rChild == Null)) {
            if (child == 'l') {
                node[parent].lChild = Null;
            } else {
                node[parent].rChild = Null;
            }
        } else if ((lChild != Null) && (rChild != Null)) {
            countLevel = 0;
            inordersuccessor(node[NodeDelete].rChild);
        } else {
            if (lChild != Null) {
                if (child == 'l') {
                    node[parent].lChild = node[NodeDelete].lChild;
                } else {
                    node[parent].rChild = node[NodeDelete].lChild;
                }
            } else {
                if (child == 'r') {
                    if (child == 'l') {
                        node[parent].lChild = node[NodeDelete].rChild;
                    } else {
                        node[parent].rChild = node[NodeDelete].rChild;
                    }
                }
            }
        }
    }
}

void preOrder(int root) {
    if(root != Null) {
        printf("%d ", node[root].item);
        preOrder(node[root].lChild);
        preOrder(node[root].rChild);
    }
}

void inOrder(int root) {
    if(root != Null) {
        preOrder(node[root].lChild);
        printf("%d ", node[root].item);
        preOrder(node[root].rChild);
    }
}

void postOrder(int root) {
    if(root != Null) {
        preOrder(node[root].lChild);
        preOrder(node[root].rChild);
        printf("%d ", node[root].item);
    }
}

int main() {
    createTreeArray();
    int root = 0;
    insert(60);
    insert(20);
    insert(10);
    insert(40);
    insert(30);
    deleteItem(40);
    insert(50);
    insert(70);
    preOrder(root);
}
