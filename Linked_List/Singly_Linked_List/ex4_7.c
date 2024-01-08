#include "C:\\Users\\kritt\\Documents\\Personal_Project\\Data_Structure_and_Algorithm\\Linked_List\\Singly_Linked_List\\Node.h"

int main() {
    struct Node *fourth = createNode(10, NULL);
    struct Node *third = createNode(9, NULL);
    struct Node *second = createNode(8, third);
    struct Node *first = createNode(7, second);

    setNext(third, fourth);

    struct Node *x;
    struct Node *curr;
    struct Node *prev;

    x = createNode(50, NULL);

    setNext(x, third);
    setNext(second, x);

    curr = first;
    prev = NULL;

    for(int i=0; i<10; i++) {
        if(getItem(curr) == 50) {
            println("%d", getItem(curr));
        }
        else {
            prev = curr;
            curr = getNext(curr);
        }
    }

    return 0;
}