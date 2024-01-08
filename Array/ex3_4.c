// Memory (RAM) and C pointer

// ia is a pointer variable. It stores the memory address of another variable.
// *ia is the value at the memory address stored in the pointer ia. It is the dereferenced value.

#include <stdio.h>

int main() {
    // ia ia is a variable of type "pointer to int" (int*). It stores the memory address (pointer) of an integer variable
    // *ia is the dereference operator, and it is used to access the value stored at the memory address pointed to by ia. When used on the left side of an assignment, it allows you to modify the value at that memory address.
    int i;      // Declare an integer variable [i is an integer]
    int *ia;    // Declare a pointer to an integer [ia is an address to]
    i = 10;     // Assign the value 10 to the integer variable i
    ia = &i;    // Assign the address of i to the pointer ia
    *ia = 50;   // Dereference the pointer and assign the value 50 to the memory location it points to (i)

    // At this point, the value of i has been changed to 50 through the pointer
    
    printf("Value of i: %d\n", i);    // Output: Value of i: 50
    printf("Value in ia: %p\n", (void *)ia); // Output: Value in ia: [some memory address]
    printf("Value at the memory address pointed by ia: %d\n", *ia); // Output: Value at the memory address pointed by ia: 50

    return 0;

}