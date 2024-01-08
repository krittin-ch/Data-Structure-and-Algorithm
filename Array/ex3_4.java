// Memory (RAM) and Java Object

public class ex3_4 {
    public static void main(String[] arg) {
        // Integer intRef; // intRef has sane structure as Object Integer
        // intRef = new Integer(9);
        Integer intRef = 9;
        // intRef holds memory address of the Integer object with value 9 [Hence, intRef does not contain value 9 but the memory address to value 9]

        System.out.println(intRef);
    }   
}

