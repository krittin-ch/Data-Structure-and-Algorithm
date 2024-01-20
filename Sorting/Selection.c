void main() {
    int arr[] = {12, 7, 17, 42, 1, 20, 21, 85, 13, 69};
    int len = sizeof(arr)/sizeof(int);

    for (int i=0; i<len-1; i++) {
        int minIndex = i;

        for (int j=i+1; j<len; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }

    printf("Sorted array: ");
    for (int i=0; i<len; i++) {
        printf("%d ", arr[i]);
    }
}