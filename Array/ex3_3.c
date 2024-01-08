#include <stdio.h>

int main() {
    int row = 4;
    int col = 2;
    int array[row][col];
    for(int i=0; i<row; i++) {
        for(int j=0; j<col; j++) {
            printf("array[%d][%d] = ", i, j);
            scanf("%d", &array[i][j]);
        }
    }
    int total = 0;
    for(int i=0; i<row; i++) {
        for(int j=0; j<col; j++) {
            total += array[i][j];
        }
    }
    printf("total = %d", total);
}