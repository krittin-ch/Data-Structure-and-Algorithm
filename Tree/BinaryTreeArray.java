class TreeArray {
    int item;
    int lChild;
    int rChild;
}

public class BinaryTreeArray {
    int MaxNode = 10;
    int root = -1;
    int Null = -1;
    int newNode;
    int countNode = 0;
    int parent;
    int NodeDelete;
    char child;
    int countLevel;
    TreeArray[] node = new TreeArray[MaxNode];

    public BinaryTreeArray() {
        for (newNode = 0; newNode < MaxNode; newNode++) {
            node[newNode] = new TreeArray();
            node[newNode].item = Null;
            node[newNode].lChild = Null;
            node[newNode].rChild = Null;
        }
    }

    public boolean isFull() {
        return countNode != MaxNode;
    }

    public boolean isEmpty() {
        return root == Null;
    }

    public boolean findEmptyNode() {
        newNode = 0;
        for (newNode = 0; newNode < MaxNode; newNode++) {
            if (node[newNode].item == Null) {
                break;
            }
        }
        return newNode != MaxNode;
    }

    public void insertItem(int root, int newItem) {
        if (newItem < node[root].item) {
            if (node[root].lChild == Null) {
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

    public void insert(int newItem) {
        if (isFull() && findEmptyNode()) {
            node[newNode].item = newItem;
            countNode++;
            if (root != Null) {
                insertItem(root, newItem);
            } else {
                root = newNode;
            }
        } else {
            System.out.println("Tree Array is Full");
        }
    }

    public void search(int root, int searchKey) {
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

    public void inOrderSuccessor(int root) {
        if (node[root].lChild != Null) {
            parent = root;
            countLevel++;
            inOrderSuccessor(node[root].lChild);
        } else {
            node[NodeDelete].item = node[root].item;
            if (countLevel == 0) {
                node[parent].rChild = Null;
            } else {
                node[parent].lChild = Null;
            }
        }
    }

    public void deleteItem(int deleteItem) {
        if (isEmpty()) {
            System.out.println("Tree Empty");
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
                inOrderSuccessor(node[NodeDelete].rChild);
            } else {
                if (node[NodeDelete].lChild != Null) {
                    if (child == 'l') {
                        node[parent].lChild = node[NodeDelete].lChild;
                    } else {
                        node[parent].rChild = node[NodeDelete].lChild;
                    }
                } else {
                    if (child == 'l') {
                        node[parent].lChild = node[NodeDelete].rChild;
                    } else {
                        node[parent].rChild = node[NodeDelete].rChild;
                    }
                }
            }
        }
    }

    public void preOrder(int root) {
        if (root != Null) {
            System.out.print(node[root].item + " ");
            preOrder(node[root].lChild);
            preOrder(node[root].rChild);
        }
    }

    public void inOrder(int root) {
        if (root != Null) {
            inOrder(node[root].lChild);
            System.out.print(node[root].item + " ");
            inOrder(node[root].rChild);
        }
    }

    public void postOrder(int root) {
        if (root != Null) {
            postOrder(node[root].lChild);
            postOrder(node[root].rChild);
            System.out.print(node[root].item + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTreeArray tree = new BinaryTreeArray();
        int root = 0;
        tree.insert(60);
        tree.insert(20);
        tree.insert(10);
        tree.insert(40);
        tree.insert(30);
        tree.insert(50);
        tree.insert(70);

        System.out.println("Preorder Traversal:");
        tree.preOrder(root);

        tree.deleteItem(20);

        System.out.println("\nPreorder Traversal after deletion:");
        tree.preOrder(root);
    }
}
