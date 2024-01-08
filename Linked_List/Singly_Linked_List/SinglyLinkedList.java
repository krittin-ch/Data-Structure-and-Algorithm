package Singly_Linked_List;

public class SinglyLinkedList {
    Node newNode;
    Node head;
    Node curr;
    Node prev;

    public void add(Object newItem) {
        if(head == null) {
            newNode = new Node(newItem);
        }
        else {
            newNode = new Node(newItem, head);
        }
        head = newNode;
    }

    public boolean searchItem(Object Item) {
        boolean status = false;
        curr = head;
        prev = null;
        while(!curr.getItem().equals(null)) {
            if(curr.getItem().equals(Item)) {
                status = true;
                break;
            }
            else {
                prev = curr;
                curr = curr.getNext();
            }
        }
        return status;
    }

    public void deleteNode(Object Item) {
        if(searchItem(Item)) {
            if(prev == null) {
                head = curr.getNext();
            }
            else {
                prev.setNext(curr.getNext());
            }
        }
        else {
            System.out.print("Not found item");
        }
    }

    public void insert(Object insertitem, Object newItem) {
        if(searchItem(insertitem)) {
            newNode = new Node(newItem);
            if(prev == null) {
                newNode.setNext(head);
                head = newNode;
            }
            else {
                prev.setNext(newNode);
                newNode.setNext(curr);
            }
        }
        else {
            if(head == null) {
                head = newNode;
            }
            else if (curr == null) {
                newNode.setNext(curr);
            }
            else {
                System.out.print("null");
            }
        }
    }
}




// public class SinglyLinkedList {
//     Node newNode;
//     Node head;
//     Node curr;
//     Node prev;

//     // Add to the first

//     public void add(Object newItem) {
//         if (head==null) {
//             newNode = new Node(newItem);
//         }
//         else {
//             newNode = new Node(newItem, head);
//         }
//         head = newNode;
//     }

//     public boolean searchItem(Object Item) {
//         curr = head;
//         prev = null;
//         boolean status = false;
//         while(!curr.getItem().equals(null)) {
//             if(curr.getItem().equals(Item)) {
//                 status = true;
//                 break;
//             }
//             else {
//                 prev = curr;
//                 curr = curr.getNext();
//             }
//         }
//         return status;
//     }

//     public void deleteNode(Object Item) {
//         if(searchItem(Item)) {
//             if(prev == null) {
//                 head = curr.getNext();
//             }
//             else {
//                 prev.setNext(curr.getNext()); // set connection between previos node of head and next node of curruent node
//             }
//         }
//         else {
//             System.out.println("Not found item.");
//         }
//     }

//     public void insert(Object iteminsert, Object newItem) {
//         if(searchItem(iteminsert)) {
//             newNode = new Node(newItem);
//             if (prev == null) {
//                 head = newNode;
//                 head.setNext(curr);
//             }
//             else {
//                 prev.setNext(newNode);
//                 newNode.setNext(curr);
//         }
//     }
//         else {
//             if(head == null) {
//                 newNode.setNext(curr);
//                 head = newNode;
//             }
//             else if (curr.equals(null)) {
//                 prev.setNext(newNode);
//             }
//             else {
//                 System.out.println("Not found item.");
//             }
//         }
//     }

//     public void showdata() {
//         curr = head;
//         while(curr != null) {
//             System.out.print(curr.getItem() + " ");
//             curr = curr.getNext();
//         }
//         System.out.println();
//     }

//     public static void main(String args[]) {
//         SinglyLinkedList linklist = new SinglyLinkedList();
//         linklist.add(9);
//         linklist.add(10);
//         linklist.add(11);
//         linklist.add(12);
//         linklist.showdata();
//         linklist.deleteNode(10);
//         linklist.showdata();
//         linklist.insert(11, 1000);
//         linklist.showdata();
//     }
// }
