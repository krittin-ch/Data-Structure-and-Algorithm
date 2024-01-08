import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3_1 {
    public static void main(String[] arg) throws IOException {
        BufferedReader Stdin = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("n = ");
        int n = Integer.parseInt(Stdin.readLine());

        int x[] = new int[n];
        int y[] = new int[n];

        for(int i=0; i<n; i++) {
            System.out.printf("x["+i+"] = ");
            x[i] = Integer.parseInt(Stdin.readLine());

            System.out.printf("y["+i+"] = ");
            y[i] = Integer.parseInt(Stdin.readLine());
        }

        int total = 0;
        for(int i = 0; i<n; i++) {
            total += Math.pow(x[i] + y[i], 2);
        }

        System.out.println("total = " + total);
    }    
}
