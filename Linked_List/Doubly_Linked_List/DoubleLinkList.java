    package Doubly_Linked_List;

    public class DoubleLinkList {
        DoubleLink newNode;
        DoubleLink head;
        DoubleLink last;
        DoubleLink curr;
        DoubleLink prev1;
        DoubleLink prev2;

        public void add(Object newItem) {
            newNode = new DoubleLink(newItem);
            if(head == null) {
                last = newNode;
            }
            else {
                head.setPrecede(newNode);
                newNode.setNext(head);
            }
            head = newNode;
        } 

        public boolean searchItem(Object item) {
            curr = head;
            prev1 = null;
            prev2 = null;
            boolean status = false;

            while (curr != null) {
                if(curr.getItem().equals(item)) {
                    prev2 = curr.getNext();
                    status = true;
                    break;
                }
                else {
                    prev1 = curr;
                    curr = curr.getNext();
                }
            }
            return status;
        }

        public void deleteNode(Object item) {
            if(searchItem(item)) {
                if(prev1 == null) {
                    head = curr.getNext();
                    if(prev2 != null) {
                        prev2.setPrecede(null);
                    }
                    else {
                        last = prev1;
                    }
                }
                else if(prev2 == null) {
                    prev1.setNext(null);
                    curr.setPrecede(null);
                    last = prev1;
                }
                else {
                    prev1.setNext(prev2);
                    prev2.setPrecede(prev1);
                }
            }
            else {
                System.out.print("Not found item");
            }
        }

        public void insert(Object insertItem, Object newItem) {
            prev2 = curr; // is a node after the insertion (which is the same as previous curr location)
            newNode = new DoubleLink(newItem);
            if(searchItem(insertItem)) {
                if(prev1 == null) {
                    newNode.setNext(curr);
                    prev2.setPrecede(newNode);
                    head = newNode;
                    if(prev2 != null) {
                        prev2.setPrecede(newNode);
                    }
                }
                else {
                    newNode.setNext(prev2);
                    newNode.setPrecede(prev1);
                    prev2.setPrecede(newNode);
                    prev1.setNext(newNode);
                }
            }
            else { // insert as last if cannot find item
                if(head == null) {
                    last = newNode;
                    head = newNode;
                }
                else {
                    newNode.setPrecede(last);
                    last.setNext(newNode);
                    last = newNode;
                }
            }
        }

        public void showdata() {
            curr = head;
            while (curr!=null) {
                System.out.print(curr.getItem() + " ");
                curr = curr.getNext();
            }
            System.out.println();
        }

        public static void main(String args[]) {
            DoubleLinkList linkList = new DoubleLinkList();
            linkList.add(10);
            linkList.add(12);
            linkList.insert(12, 78);
            linkList.showdata();
        }
    }
