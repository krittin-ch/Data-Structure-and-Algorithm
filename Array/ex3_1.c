// 1D Array

#include <stdio.h>

int  main() {
    // dataType arrayname[] = {value0, value1, ...}
    int array[] = {1, 2, 3, 4};
    int total = 0;
    for(int i = 0; i < sizeof(array)/sizeof(int); i++) { // sizeof is unit in bytes, so sizeof(array)/siizeof(int) = (4*4)/4
        total+=array[i];
    }
    printf("total = %d", total);
}


