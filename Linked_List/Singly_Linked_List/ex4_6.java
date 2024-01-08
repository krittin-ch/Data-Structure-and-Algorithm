package Singly_Linked_List;

public class ex4_6 {
    public static void main(String[] args) {
        Node n = new Node(9); // Node n contains item = 9, next = null
        Node second = new Node(8,n);
        Node first = new Node(7,second); // Node first contains item = 8, next = n 

        Node curr = new Node();
        Node prev = new Node();
        curr = first;
        prev = null;
        while (curr != null) {
            if (curr.getItem().equals(7)) {
                System.out.println(curr.getItem());
                System.out.println(prev.getItem());
            }
            else {
                prev = curr;
                curr = curr.getNext();
            }
        }
    }

}
