public class BinaryTree {
    TreeNode root;
    TreeNode newNode;
    TreeNode parent;
    TreeNode NodeDelete;
    char child;
    int countLevel;

    public boolean isEmpty() {
        return root == null;
    }

    public void insertItem(TreeNode bst, int newItem) { // Place newItem on left child if newItem < bst and place newItem on right child if newItem < bst.
        if (newItem < bst.getItem()) {
            if (bst.getLChild() == null) {
                newNode = new TreeNode(newItem);
                bst.setLChild(newNode);
            } else {
                insertItem(bst.getLChild(), newItem);
            }
        } else {
            if (bst.getRChild() == null) {
                newNode = new TreeNode(newItem);
                bst.setRChild(newNode);
            } else {
                insertItem(bst.getRChild(), newItem);
            }
        }
    } 

    public TreeNode insert(int newItem) { // Create root when empty. If not insertItem
        if(isEmpty()) {
            newNode = new TreeNode(newItem);
            root = newNode;
        } else {
            insertItem(root, newItem);
        }
        return root;
    }

    public void search(TreeNode bst, int searchKey) { // Finding the node to delete
        if (searchKey == bst.getItem()) {
            NodeDelete = bst;
        } else if (searchKey < bst.getItem()) {
            parent = bst;
            child = 'l';
            search(bst.getLChild(), searchKey);
        } else {
            parent = bst;
            child = 'r';
            search(bst.getRChild(), searchKey);
        }
    }


    public void inordersuccessor(TreeNode bst) {
        if (bst.getLChild() != null) {
            countLevel++;
            parent = bst;
            inordersuccessor(bst.getLChild());
        } else {
            NodeDelete.setItem(bst.getItem());
            if (countLevel == 0) { // This means NodeDelete = root = parent
                root.setRChild(null);
            } else {
                parent.setLChild(null);
            }
        }
    }

    public void deleteItem(int deleteItem) {
        if (isEmpty()) {
            System.out.println("Tree Empty");
        } else {
            parent = root;
            NodeDelete = null;
            search(root, deleteItem); // Obtain parent of NodeDelete, child, left of right of parent, NodeDelete value
            TreeNode lChild = NodeDelete.getLChild();
            TreeNode rChild = NodeDelete.getRChild();

            if ((lChild == null) && (rChild == null)) {
                // Delete leaf node
                if (child == 'l') {
                    parent.setLChild(null); // If NodeDelete is on left side, then set LChild of parent as null
                } else {
                    parent.setRChild(null); // If NodeDelete is on right side, then set RChild of parent as null
                }
            } else if ((lChild != null) && (rChild != null)) {
                // Delete node which contain 2 childrens
                countLevel = 0;
                inordersuccessor(NodeDelete.getRChild()); // Use this method when it is a complete binary tree
            } else {
                // Delete node with only one child
                if (NodeDelete.getLChild() != null) { // When NodeDelete is deleted, use its child as neww parent child (that's substitute its child as itself)
                    if (child == 'l') {
                        parent.setLChild(NodeDelete.getLChild());
                    } else {
                        parent.setRChild(NodeDelete.getLChild());
                    }
                } else {
                    if (child == 'l') {
                        parent.setLChild(NodeDelete.getRChild());
                    } else {
                        parent.setRChild(NodeDelete.getRChild());
                    }
                }
            }
        }
    }

        public void preOrder(TreeNode rootNode) {
            if (rootNode != null) {
                System.out.print(rootNode.getItem() + " ");
                preOrder(rootNode.getLChild());
                preOrder(rootNode.getRChild());
            }
        }

        public void inOrder(TreeNode rootNode) {
            if(rootNode != null) {
                inOrder(rootNode.getLChild());
                System.out.print(rootNode.getItem() + " ");
                inOrder(rootNode.getRChild());
            }
        }

        public void postOrder(TreeNode rootNode) {
            if (rootNode != null) {
                postOrder(rootNode.getLChild());
                postOrder(rootNode.getRChild());
                System.out.print(rootNode.getItem() + " ");
            }
        }

        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();
            TreeNode root;
            root = tree.insert(60);
            tree.insert(20);
            tree.insert(10);
            tree.insert(40);
            tree.insert(30);
            tree.insert(50);
            tree.insert(70);
            System.out.println("Insert: 60 20 10 40 30 50 70");
            System.out.print("Preorder: ");
            tree.preOrder(root);
            System.out.println();
            tree.deleteItem(20);
            System.out.print("Preorder: ");
            tree.preOrder(root);
            System.out.println();
            System.out.print("Inorder: ");
            tree.inOrder(root);
            System.out.println();
            System.out.print("Postorder: ");
            tree.postOrder(root);
        }
        
    }






