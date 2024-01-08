//2D Array

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex3_3 {
    public static void main(String[] args) throws IOException {
        int row = 4;
        int col = 2;
        BufferedReader Stdin = new BufferedReader (new InputStreamReader(System.in));
        int array[][] = new int[row][col];

        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                System.out.print("array["+i+"]["+j+"] = ");
                array[i][j] = Integer.parseInt(Stdin.readLine());
            }
        }
        int total = 0;
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[j].length; j++) {
                total += array[i][j];
            }
        }
        System.out.println("total = " + total);
    }
}

