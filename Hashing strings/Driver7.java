import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter path to file: ");
        File file = new File(input.nextLine());
        try {
            input = new Scanner(file);
            int num = input.nextInt();
            Hash table = new Hash();
            for (int i = 0; i < num; i++) {
                String word = input.next();
                System.out.println("String == " + word);
                table.insertWord(word);
                System.out.println();
            }
            System.out.println("Total Collisions Hash #1: " + table.getCollisions1());
            System.out.println("Total Collisions Hash #2: " + table.getCollisions2());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}

