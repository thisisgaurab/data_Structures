import java.util.LinkedList;

public class Hash {
    private int Hash1Collisions, Hash2Collisions;

    // two static integer arrays to store the number of collisions
    static int[] hash1 = new int[500];
    private static int[] hash2 = new int[500];

    // creating and initializing the size of the hash table
    protected static final int table_size = 59;

    // creating two linkedlistarray to store the hash table for each algorithm
    private static LinkedList<String>[] table1 = new LinkedList[table_size];
    private static LinkedList<String>[] table2 = new LinkedList[table_size];

    public Hash(){
        // Initialize the linked lists in the table arrays
        for (int i = 0; i < table_size; i++) {
            table1[i] = new LinkedList<>();
            table2[i] = new LinkedList<>();
        }
        Hash1Collisions = 0;
        Hash2Collisions = 0;
    }

    // hash1 method
    public static int hash1(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += (int) word.charAt(i);
        }


        return sum;
    }


    // hash2 method
    public static int hash2(String word) {

        int bits = 0;

// Bit 0
        if (word.length() % 2 != 0) {
            bits += 1;
        }

// Bit 1
        if ("AEIOUaeiou".indexOf(word.charAt(0)) != -1) {
            bits += 2;
        }

// Bit 2
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += (int) word.charAt(i);
        }
        if (sum % 2 != 0) {
            bits += 4;
        }

// Bit 3
        boolean hasDuplicate = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.lastIndexOf(word.charAt(i)) != i) {
                hasDuplicate = true;
                break;
            }
        }
        if (hasDuplicate) {
            bits += 8;
        }

// Bit 4
        int first = (int) word.charAt(0);
        int last = (int) word.charAt(word.length() - 1);
        int middle = 0;
        if (word.length() % 2 == 0) {
            middle = (int) word.charAt(word.length() / 2 - 1);
        } else {
            middle = (int) word.charAt(word.length() / 2);
        }
        if ((first + middle + last) % 2 != 0) {
            bits += 16;
        }

// Bit 5
        boolean hasUppercase = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                hasUppercase = true;
                break;
            }
        }
        if (hasUppercase) {
            bits += 32;
        }

// Bit 6
        boolean isLexicographicallyLess = false;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) < word.charAt(word.length()- i - 1)) {
                isLexicographicallyLess = true;
                break;
            }
            else if (word.charAt(i) > word.charAt(word.length() - i - 1)) {
                break;
            }
        }
        if (isLexicographicallyLess) {
            bits += 64;
        }


// Bit 7
        if (word.length() <= 6) {
            bits += 128;
        }

        return bits;
    }



        public void insertWord(String word) {
        // Insert the word into both hash tables
        int position1 = hash1(word) % table_size;
        int position2 = hash2(word) % table_size;

        Hash1Collisions+=(!table1[position1].contains(word) && !table1[position1].isEmpty())?1:0;

        Hash2Collisions+=(!table2[position2].contains(word) && !table2[position2].isEmpty())?1:0;

        if(!table1[position1].contains(word)){
            table1[position1].add(0, word);
        }

        if(!table2[position2].contains(word)){
            table2[position2].add(0, word);
        }

        System.out.println("Hash function #1 : "+ hash1(word) + " Table position: "+ position1);
        System.out.println("Hash function #2 : "+ hash2(word) + " Table position: "+ position2);



    }

    public int getCollisions1(){
        return Hash1Collisions;
    }

    public int getCollisions2(){
        return Hash2Collisions;
    }

}