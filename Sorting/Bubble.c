#include <stdio.h>

int main() {
    int arr[10] = {12, 7, 17, 42, 1, 20, 21, 85, 13, 69};
    int s = 1;

    while (s != 0) {
        s = 0;
        for (int i = 0; i < sizeof(arr)/sizeof(int) - 1; i++) {
        if (arr[i] > arr[i+1]) {
            int a = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = a;
            s += 1;
            }
        }
        printf("%d", s);
        printf("\n");
        for (int i = 0; i < sizeof(arr)/sizeof(int); i++) {
            printf("%d ", arr[i]);
            }
        printf("\n");
    }
    return 0;
}
