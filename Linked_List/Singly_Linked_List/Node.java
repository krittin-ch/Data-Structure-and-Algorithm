// Singly Linked-List

package Singly_Linked_List;


public class Node {
    private Object item;
    private Node next;

    public Node() {
        next = null;
    }

    public Node(Object newItem) {
        item = newItem;
    }

    public Node(Object newItem, Node nextNode) {
        item = newItem;
        next = nextNode;
    }

    public void setItem(Object newItem) {
        item = newItem;
    }

    public void setNext(Node nextNode) {
        next = nextNode;
    }

    public Object getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }
}



// public class Node {
//     private Object item; // Variable item is assigned as Object. [Can be changed to pther dataTypes]
//     private Node next; // Variable next used to connect to a next Node. If no reference, next = null
//     // begin constructor
//     public Node() { // First method that is activated when this class is used. Used to create the starting point, called Head Node
//         next = null;
//     }
//     public Node(Object newItem) { // Constructor recieves variable newItem and set item = newItem with next = null, that is no connection to a next node
//         item = newItem;
//         next = null;
//     }
//     public Node(Object newItem, Node nextNode) { // Constructor recieves 2 variables, item = newItem and next = nextNode
//         item = newItem;
//         next = nextNode;
//     } // end constructor
//     // begin method
//     public void setItem(Object newItem) { // Set the value of item from newItem, item = newItem
//         item = newItem;
//     }
//     public Object getItem() {  // Get value of item
//         return item;
//     }
//     public void setNext(Node nextNode) { // Set the value of item from nextNode, next = nextNoed
//         next = nextNode;
//     }
//     public Node getNext() { // Get value of next
//         return next;
//     }
// }