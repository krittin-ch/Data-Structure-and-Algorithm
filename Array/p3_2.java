import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3_2 {
    public static void main(String[] arg) throws IOException {

        BufferedReader Stdin = new BufferedReader (new InputStreamReader(System.in));
        System.out.printf("n = ");
        int n = Integer.parseInt(Stdin.readLine());

        String student[] = new String[n];
        int score[] = new int[n];

        for(int i=0; i<n; i++) {
            System.out.printf("student is ");
            student[i] = Stdin.readLine();

            System.out.printf("score = ");
            score[i] = Integer.parseInt(Stdin.readLine());
        }

        for(int i=0; i<n; i++) {
            if(score[i] < 50) {
                System.out.println("Student: "+student[i]+", Score: "+score[i]);
            }
        }
        
        Stdin.close();
    }
}

/*
import java.util.Scanner;

public class p3_2 {
    public static void main(String[] arg) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        String[] student = new String[n];
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Student is: ");
            student[i] = scanner.nextLine();

            System.out.print("Score = ");
            score[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < n; i++) {
            if (score[i] < 50) {
                System.out.println("Student: " + student[i] + ", Score: " + score[i]);
            }
        }

        scanner.close();
    }
}

 */