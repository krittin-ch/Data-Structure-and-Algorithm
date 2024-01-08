package Doubly_Linked_List;

public class UseDoubleLink {
    public static void main(String args[]) {
        DoubleLink n = new DoubleLink(6);
        DoubleLink first = new DoubleLink(9, n, null);
        n.setPrecede(first);
    }
}
