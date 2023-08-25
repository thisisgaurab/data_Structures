import java.io.File;
import java.util.Scanner;

public class Driver3 {
    public static myLinkedList list;   // altered line for linked list implementation
    public static Scanner  input;
    public static File f;
    public static String  fname;
    public static void main(String[] args) {
        System.out.print("Please enter a path or name of input file : ");
        input = new Scanner(System.in);
        fname = input.nextLine();
        f = new File(fname);
        try {
            input = new Scanner(f);
        } catch (Exception E) {
            System.out.println("File not found");
        }
        int line;
        int size= input.nextInt();

        Stack S1= new Stack();
        Stack S2= new Stack();

        for (int i = 0; i < size; i++) {
            line = input.nextInt();
            while (!S1.isEmpty() && line>S1.top()){
                S2.push(S1.pop());
            }
            S1.push(line);
            while (!S2.isEmpty()){
                S1.push(S2.pop());
            }
        }
        System.out.println("SORTED LIST");
        System.out.println("_____________");
        int i=0;
        while(!S1.isEmpty()){
            System.out.println(i + 1 + " : " + S1.pop());
            i++;

        }
    }
}