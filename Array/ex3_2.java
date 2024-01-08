// 1D Array with specific dimension

// dataType arrayname[] = new dataType[sizeofArray]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex3_2 {
    public static void main(String[] arga) throws IOException {
        BufferedReader Stdin = new BufferedReader (new InputStreamReader(System.in));
        int array[] = new int[4];
        int sizeofArray = array.length;

        for(int i=0; i<sizeofArray; i++) {
            array[i] = Integer.parseInt(Stdin.readLine());
        }

        int total = 0;
        for(int i=0; i<sizeofArray; i++) {
            total += array[i];
        }
        System.out.println("total = "+ total);
    }
}