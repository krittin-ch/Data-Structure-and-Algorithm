// singly linked circular linked list

package Circular_Linked_List;

import Singly_Linked_List.*;

public class SCLinkedList {
    public static void main(String[] args) {
    Node n = new Node(4, null);
    Node third = new Node(3, n);
    Node second = new Node(2, third);
    Node first = new Node(1, second);

    n.setNext(first);
    }
}
