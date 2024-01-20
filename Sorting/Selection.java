package Sorting;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int arr[] = {12, 7, 17, 42, 1, 20, 21, 85, 13, 69};
        int len = arr.length;

        for (int i=0; i<len-1; i++) {
            int minIndex = i;

            for (int j = i+1; j<len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }       
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;    
        }
        System.out.println("Sorted array: " + Arrays.toString(arr));   
    }
}