#include <stdio.h>

void insertionSort(int arr[], int n) {
    int i, j, temp;
    for (i = 1; i < n; i++) {
        temp = arr[i];
        j = i - 1;

        while (j >= 0 && arr[j] > temp) {
            arr[j + 1] = arr[j];
            j--;
        } 
        arr[j + 1] = temp;
    }
}

void showArray(int arr[], int n) {
    printf("Array: [");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("]\n");
}

int main() {
    int arr[] = {12, 7, 17, 42, 1, 20, 21, 85, 13, 69};
    int n = sizeof(arr) / sizeof(arr[0]);

    showArray(arr, n);
    insertionSort(arr, n);
    showArray(arr, n);

    return 0;
}
