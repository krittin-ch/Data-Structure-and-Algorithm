public class KaryNode {
    int K = 4;
    private int item[] = new int[K-1];
    private KaryNode child[] = new KaryNode[K];

    public KaryNode() {
        for (int count=0; count < K-1; count++) {
            item[count] = -1;
        }
    }

    public int getK() {
        return K;
    }

    public int getItem(int index) {
        return item[index];
    }

    public void setItem(int index, int newItem) {
        item[index] = newItem;
    }

    public KaryNode getChild(int index) {
        return child[index];
    }

    public void setChild(int index, KaryNode nextNode) {
        child[index] = nextNode;
    }
}
