// Inserting Node

package Singly_Linked_List;

public class ex4_7 {
    public static void main(String[] arg) {
        Node fourth = new Node(10);
        Node third = new Node(9, fourth); 
        Node second = new Node(8,third);
        Node first = new Node(7,second);

        // Insert x between second and third
        Node x = new Node(); // item of x = null, next of x = null
        x.setItem(8.5); // set item of x = 8.5
        x.setNext(third); // nextNode of x is third

        second.setNext(x); // nextNode of second is x

        Node curr = new Node();
        Node prev = new Node();
        curr = first;

        for(int i=0; i<4; i++) {
            if(curr.getItem().equals(8.5)) {
                System.out.println(curr.getNext());
                System.out.println(prev.getNext());
            }
            else {
                prev = curr;
                curr = curr.getNext();
            }
        }
    }
}
