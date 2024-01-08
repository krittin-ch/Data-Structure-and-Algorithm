import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3_5 {
    public static int[][] multiply(int[][] array1, int[][] array2) {
        
        int row = array1.length;
        int col = array2[0].length;
        if(array1[0].length == array2.length) {
            int[][] array3 = new int[row][col];
            for(int i=0; i<row; i++) {
                for(int k=0; k<col; k++) {
                    int val = 0 ;
                    for(int j=0; j<array2.length; j++) {
                            val += array1[i][j]*array2[j][k];
                    }
                    array3[i][k] = val;
                }
            }

            return array3;
        }
        else {
            return null;
        }
        
    }
    public static void main(String[] arg) throws IOException {
        int row1 = 2;
        int col1 = 3;
        int row2 = 3;
        int col2 = 2;

        int[][] m1 = new int[row1][col1];
        int[][] m2 = new int[row2][col2];
        int[][] m3;

        BufferedReader Stdin = new BufferedReader (new InputStreamReader(System.in));

        for(int i=0; i<row1; i++) {
            for(int j=0; j<col1; j++) {
                System.out.printf("m1["+i+"]["+j+"] = ");
                m1[i][j] = Integer.parseInt(Stdin.readLine());
            }
        }

        for(int i=0; i<row2; i++) {
            for(int j=0; j<col2; j++) {
                System.out.printf("m2["+i+"]["+j+"] = ");
                m2[i][j] = Integer.parseInt(Stdin.readLine());
            }
        }

        m3 = multiply(m1, m2);

        for(int i=0; i<row1; i++) {
            for(int j=0; j<col2; j++) {
                System.out.println(m3[i][j]);
            }
        }
    }   
}
