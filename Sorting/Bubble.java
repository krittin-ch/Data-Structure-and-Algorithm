package Sorting;

public class Bubble {
    public static void main(String[] args) {
        int arr[] = {12, 7, 17, 42, 1, 20, 21, 85, 13, 69};
        int len = arr.length;   
        int s = 1;

        while (s != 0) {
            s = 0;
            for (int i=0; i<len-1; i++) {
                if (arr[i] > arr[i+1]) {
                    int a = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = a;
                    s += 1;
                }
            }
            for (int i=0; i<len; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");;
        }
        for (int i=0; i<len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}