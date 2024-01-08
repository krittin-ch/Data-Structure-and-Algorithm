// 1D Array

public class ex3_1 { 
    public static void main(String[] args) {
        // dataType arrayname[] = {value0, value1, ...}
        int array[] = {1, 2, 3, 4};
        int total = 0;
        for(int i=0; i< array.length; i++) {
            total+=array[i];
        }
        System.out.println("total = " + total);
    }
}
