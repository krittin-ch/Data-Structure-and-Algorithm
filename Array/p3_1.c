#include <stdio.h>
#include <math.h>

int main() {
    printf("n = ");
    int n;
    scanf("%d", &n);

    int x[n];
    int y[n];

    for(int i=0; i<n; i++) {
        printf("x[%d] = ", i);
        scanf("%d", &x[i]);

        printf("y[%d] = ", i);
        scanf("%d", &y[i]);
    }

    int total = 0;

    for(int i=0; i<n; i++) {
        total += pow((x[i] + y[i]),2);
    }

    printf("total = %d", total);
    return 0;
}