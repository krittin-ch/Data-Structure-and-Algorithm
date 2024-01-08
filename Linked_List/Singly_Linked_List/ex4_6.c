#include "C:\\Users\\kritt\\Documents\\Personal_Project\\Data_Structure_and_Algorithm\\Linked_List\\Singly_Linked_List\\Node.h"

int main() {
    struct Node *n = createNode(9, NULL);
    struct Node *second = createNode(8, n);
    struct Node *first = createNode(7, second);

    struct Node *curr;
    struct Node *prev;
    curr = first;
    prev = NULL;

    for(int i=0; i<3; i++) {
        if(getItem(curr) == 8) {
            printf("%d", getItem(curr));
        }
        else {
            prev = curr;
            curr = getNext(curr);
        }
    }
}