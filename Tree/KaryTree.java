public class KaryTree {    
    KaryNode root = new KaryNode();
    KaryNode newNode;
    KaryNode parent;
    int indexparent;
    KaryNode nodeDelete;
    int indexDelete;
    KaryNode nodeChange;
    int indexChange;
    int indx;
    int k = root.getK() - 1;

    public boolean isEmpty() {
        return root.getItem(0) == -1;
    }

    public int checkItem(KaryNode node, int newItem) {
        int indexfind;
        for (indexfind=0; indexfind<k; indexfind++) {
            int item = node.getItem(indexfind);
            if ((newItem<item) || (item == -1)) {
                break;
            }
        }
        return indexfind;
    }

    public void insertItem(KaryNode node, int newItem) {
        indx = checkItem(node, newItem);
        if ((indx != k) && (node.getItem(indx) == -1)) {
            node.setItem(indx, newItem);
        } else {
            if (node.getChild(indx) == null) {
                newNode = new KaryNode();
                newNode.setItem(0, newItem);
                node.setChild(indx, newNode);
            } else {
                insertItem(node.getChild(indx), newItem);
            }
        }
    }

    public KaryNode insert(int newItem) {
        if (isEmpty()) {
            newNode = new KaryNode();
            newNode.setItem(0, newItem);
            root = newNode;
        } else {
            insertItem(root, newItem);
        }
        return root;
    }

    public void search(KaryNode node, int indx, int searchKey) {
        if (indx != k) {
            if (searchKey == node.getItem(indx)) {
                nodeDelete = node;
                indexDelete = indx;
            } else if (searchKey < node.getItem(indx)) {
                parent = node;
                indexparent = indx;
                node = node.getChild(indx);
                if (node != null) {
                    search(node, 0, searchKey);
                } else {
                    nodeDelete = null;
                }
            } else {
                search(node, indx += 1, searchKey);
            }
        } else {
            if (node.getChild(indx) != null) {
                parent = node;
                indexparent = indx;
                search(node.getChild(indx), 0, searchKey);
            }
        }
    }

    public void inordersuccessor(KaryNode node) {
        if (node.getChild(0) != null) {
            parent = node;
            indexparent = 0;
            inordersuccessor(node.getChild(0));
        } else {
            nodeChange = node;
        }
    }

    public void preordersuccessor(KaryNode node) {
        if (node.getChild(k) == null) {
            for (int count = k -1; count <= indx; count--) {
                if (node.getItem(count) != -1) {
                    if (node.getChild(count+1) != null) {
                        parent = node;
                        indexparent = count;
                        preordersuccessor(node.getChild(count+1));
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
            preordersuccessor(node.getChild(k));
        }
    }

    public void deleteItems(KaryNode node, int indx) {
        int Sibling = -1;
        KaryNode ChildL = node.getChild(indx);
        KaryNode ChildR = node.getChild(indx + 1);
        if (indx != k-1) {
            Sibling = node.getItem(indx + 1);
        }
        if ((ChildL == null) && (ChildR == null) && (Sibling == -1) && (indexDelete == 0)) {
            parent.setChild(indexparent, null);
        } else if ((ChildL == null) && (ChildR == null) && (Sibling == -1)) {
            nodeDelete.setItem(indexDelete, -1);
        } else if ((ChildL == null) && (ChildR == null) && (Sibling != -1)) {
            for (int count = indx; count<k-1; count++) {
                node.setItem(count, node.getItem(count+1));
                node.setChild(count, node.getChild(count+1));
            }
            if (node.getChild(k) != null) {
                KaryNode child = node.getChild(k);
                node.setItem(k-1, child.getItem(0));
                parent = node;
                indexparent = k;
                deleteItems(child, 0);
            } else {
                node.setItem(k-1, -1);
            }
        } else if ((ChildL != null) && (ChildR != null)) {
            parent = node;
            indexparent = indx;
            inordersuccessor(ChildR);
            nodeDelete.setItem(indexDelete, nodeChange.getItem(0));
            nodeDelete = nodeChange;
            indexDelete = 0;
            deleteItems(nodeDelete, 0);
        } else {
            if ((Sibling == -1) && (indexDelete == 0)) {
                parent.setChild(indexparent, node.getChild(0));
            } else if (ChildL != null) {
                parent = node;
                indexparent = indx;
                preordersuccessor(ChildL);
                nodeDelete.setItem(indexDelete, nodeChange.getItem(indexChange));
                nodeDelete = nodeChange;
                indexDelete = indexChange;
                indexDelete = 0;
                deleteItems(nodeDelete, indexChange);
            } else {
                parent = node;
                indexparent = indx;
                inordersuccessor(ChildR);
                nodeDelete.setItem(indexDelete, nodeChange.getItem(0));
                nodeDelete = nodeChange;
                indexDelete = 0;
                deleteItems(nodeDelete, 0);
            }
        }
    }

    public void deleteNode(int deleteItem) {
        if (isEmpty()) {
            System.out.println("Tree Empty");
        } else {
            parent = root;
            indexparent = 0;
            nodeDelete = null;
            search(root, 0, deleteItem);
            if (nodeDelete == null) {
                System.out.println("Not Found Data");
            } else {
                deleteItems(nodeDelete, indexDelete);
            }
        }
    }

    public void preOrder(KaryNode rootNode) {
        int count;
        if (rootNode != null) {
            for (count = 0; count < k; count++) {
                if (rootNode.getItem(count) != -1) {
                    System.out.print(rootNode.getItem(count) + " ");
                }
                preOrder(rootNode.getChild(count));
            }
            preOrder(rootNode.getChild(count));
        }
    }

    public static void main(String[] args) {
        KaryTree kary = new KaryTree();
        KaryNode root;
        root = kary.insert(30);
        kary.insert(40);
        kary.insert(50);
        kary.insert(25);
        kary.insert(35);
        kary.insert(70);
        kary.insert(26);
        kary.insert(27);
        kary.insert(3);
        kary.insert(45);
        kary.insert(36);
        kary.insert(28);
        kary.insert(5);
        kary.insert(7);
        kary.insert(9);
        kary.preOrder(root);
        kary.deleteNode(5);
        kary.preOrder(root);
    }



}
