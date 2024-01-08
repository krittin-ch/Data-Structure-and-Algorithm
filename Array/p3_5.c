#include <stdio.h>

int main() { 
    int row1 = 2;
    int col1 = 3;
    int row2 = 3;
    int col2 = 2;

    int m1[row1][col1];
    int m2[row2][col2];
    int m3[row1][col2];

    for(int i=0; i<row1; i++) {
        for(int j=0; j<col1; j++) {
            printf("m1[%d][%d] = ", i, j);
            scanf("%d", &m1[i][j]);
        }
    }

    for(int i=0; i<row2; i++) {
        for(int j=0; j<col2; j++) {
            printf("m2[%d][%d] = ", i, j);
            scanf("%d", &m2[i][j]);
        }
    }

    for(int i=0; i<row1; i++) {
        for(int j=0; j<col2; j++) {
            int val = 0;
            for(int k=0; k<row2; k++) {
                val += m1[i][k] * m2[k][j];
            }
            m3[i][j] = val;
        }
    }

    for(int i=0; i<row1; i++) {
        for(int j=0; j<col2; j++) {
            printf("%d", m3[i][j]);
        }
    }

    return 0;
}