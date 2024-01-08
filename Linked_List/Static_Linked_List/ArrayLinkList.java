package Static_Linked_List;

class ArrayNode {
    int item;
    int next;
}

public class ArrayLinkList {
    int MaxNode = 10;
    int newNode;
    int head = -1;
    int curr;
    int prev;
    int Null = -1;
    int countNode = 0;
    ArrayNode[] node= new ArrayNode[MaxNode];

    public ArrayLinkList() {
        for(newNode = 0; newNode<MaxNode; newNode++) {
            node[newNode] = new ArrayNode(); 
            // We need this line because the line 16th has created the array of null (which is an Object), but we want the primitive dataType. That's why we have to define again.
            // you will encounter a NullPointerException because you are attempting to access the item and next fields of a null reference.
            node[newNode].item = Null;
            node[newNode].next = Null;         
        }
    }

    public boolean isFull() {
        if (countNode != MaxNode) {
            return true;
        } else {
            return false;
        }
    }

    public boolean findEmptyNode() {
        newNode = 0;
        for(newNode = 0; newNode<MaxNode; newNode++) {
            if(node[newNode].item == Null) {
                break;
            }
        }
        if (newNode == MaxNode) {
            return false;
        } else {
            return true;
        }
    }

    public void add(int newItem) {
        if(isFull() && findEmptyNode()) {
            node[newNode].item = newItem;
            if (head != Null) {
                node[newNode].next = head;
            }
            head = newNode;
            countNode++;
    } else {
        System.out.print("Array Link List is Full");
    }
}

    public boolean searchItem(int item) {
        curr = head;
        prev = Null;
        boolean status = false;
        while(curr !=Null) {
            if(node[curr].item == item) {
                status = true;
                break;
            } else {
                prev = curr;
                curr = node[curr].next;
            }
        }
        return status;
    }

    public void deleteNode(int item) {
        if(searchItem(item)) {
            node[curr].item = Null;
            if (prev == Null) {
                head = node[curr].next;
            } else {
                node[prev].next = node[curr].next;
            }
            countNode--;
        } else {
            System.out.print("Not found item");
        }
    }

    public void insert(int insertItem, int newItem) {
        if(isFull() && findEmptyNode()) {
            node[newNode].item = newItem;
            if(searchItem(insertItem)) {
                if(prev == Null) {
                    node[newNode].next = curr;
                    head = newNode;
                } else {
                    node[newNode].next = curr;
                    node[prev].next = newNode;
                }
            } else {
                if(head == Null) {
                    head = newNode;
                } else if(curr == Null) {
                    node[prev].next = newNode;
                }
            }
        } else {
            System.out.print("Array Link List is Full");
        }
    }

    public void showdata() {
        curr = head;
        while(curr!=Null) {
            System.out.print(node[curr].item + " ");
            curr = node[curr].next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayLinkList ls = new ArrayLinkList();
        ls.add(4);
        ls.add(6);
        ls.add(9);
        ls.insert(6, 100);
        ls.showdata();
    }

}
