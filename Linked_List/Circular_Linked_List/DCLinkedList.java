// doubly linked circular linked list

package Circular_Linked_List;

import Doubly_Linked_List.*;

public class DCLinkedList {
    public static void main(String[] args) {
        DoubleLink n = new DoubleLink(5);
        DoubleLink fourth = new DoubleLink(4);
        DoubleLink third = new DoubleLink(3);
        DoubleLink second = new DoubleLink(2);
        DoubleLink first = new DoubleLink(1);

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(n);
        n.setNext(second);

        n.setPrecede(fourth);
        fourth.setPrecede(third);
        third.setPrecede(second);
        second.setPrecede(first);
        first.setPrecede(n);
    }
}
