package Sorting;

public class Insertion {

    void insertionSort(int arr[], int n) {
        for (int i=0; i<n; i++) {
            int temp = arr[i];
            int  j = i-1;

            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    void showArray(int arr[], int n) {
        System.out.print("Array : [");
        for (int i=0; i<n; i++) {
            System.out.printf("%d ",arr[i]);
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        int arr[] = {12, 7, 17, 42, 1, 20, 21, 85, 13, 69};
        int n = arr.length;

        Insertion inst = new Insertion();

        inst.showArray(arr, n);
        inst.insertionSort(arr, n);
        inst.showArray(arr, n);
    }
}
