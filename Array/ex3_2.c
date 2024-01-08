// 1D Array with specific dimension

// dataType arrayname[sizeofArray]

#include <stdio.h>

int main(void) {
    int array[4];
    int sizeofArray = sizeof(array)/sizeof(int);
    for(int i=0; i<sizeofArray; i++) {
        printf("array[%d] = ", i);
        scanf("%d", &array[i]);
    }
    int total = 0;
    for(int  i=0; i<sizeofArray; i++) {
        total+=array[i];
    }
    printf("total = %d", total);
    return 0;
}

