public class TreeNode {
    private int item;
    private TreeNode lChild;
    private TreeNode rChild;

    public TreeNode(int newItem) {
        item = newItem;
        lChild = null;
        rChild = null;
    }

    public TreeNode(int newItem, TreeNode newLChild, TreeNode newRChild) {
        item = newItem;
        lChild = newLChild;
        rChild = newRChild;
    }

    public void setItem(int newItem) {
        item = newItem;
    }

    public int getItem() {
        return item;
    }

    public void setLChild(TreeNode newLChild) {
        lChild = newLChild;
    }

    public TreeNode getLChild() {
        return lChild;
    }

    public void setRChild(TreeNode newRChild) {
        rChild = newRChild;
    }

    public TreeNode getRChild() {
        return rChild;
    }


}