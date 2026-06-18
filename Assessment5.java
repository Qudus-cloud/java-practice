import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
public class Assessment5 {
    public static void main(String[] args) {
    
        // Ask user for numbers 
        int[] userNumbers = getUserNumbers();

        // Generate 6 unique random numbers
        int[] drawnNumbers = generateRandomNumbers();

        // Save both arrays to a text file
        writeToFile(userNumbers, drawnNumbers);

        // Create arrays to load data back from file
        int[] userFromFile = new int[6];
        int[] drawnFromFile = new int[6];
        // Load the numbers stored in the file
        readFromFile(userFromFile, drawnFromFile);

        // Compare user numbers with drawn numbers
        int matches = compareArrays(userFromFile, drawnFromFile);

        // Print result
        System.out.println("\nNumber of matches: " + matches);
    }

    //for generating the 6 unique random numbers
public static int[] generateRandomNumbers() {
        Random rand = new Random();
        int[] numbers = new int[6];
        int y = 0;
        //loop until 6 numbers are store
        while (y< 6) {
            int num = rand.nextInt(50) + 1;
             // Only add if number is not already in the array
            if (!contains(numbers, num)) {
                numbers[y] = num;
                y++;
            }
        }

        System.out.print("Drawn numbers: ");
        printArray(numbers);
        // Return the array
        return numbers;
    }
    // get 6 unique numbers for users
    public static int[] getUserNumbers() {
        //scanner for user input
        Scanner input = new Scanner(System.in);
        int[] userNums = new int[6];
        int y = 0;

        System.out.println("Enter 6 unique numbers between 1-50:");

         while (y < 6) {
            System.out.print("Enter number " + (y + 1) + ": ");
            int num = input.nextInt();
             // check range 
            if (num < 1 || num > 50) {
                System.out.println(" Invalid: number must be between 1-50.");
            }
            else if (contains(userNums, num)) {
                System.out.println("Duplicate detected. Try a different number.");
            }
            else {
                userNums[y] = num;
                y++;
            }
        }
        //show user numbers
        System.out.print("Your numbers: ");
        printArray(userNums);
        // return the array
        return userNums;
    }
    // check if array contains a value
    public static boolean contains(int[] m, int n) {
        for (int value : m) {
            if (value == n) return true;
        }
        // if not return false
        return false;
    }
    // Compare both array and count matches
    public static int compareArrays(int[] a, int[] b) {
        int match = 0;

        for (int valueA : a) {
            for (int valueB : b) {
                if (valueA == valueB) {
                    match++;
                }
            }
        }
        //return number of mathches
        return match;
    }
    // write arrays to a file
public static void writeToFile(int[] user, int[] drawn) {
        try {
            //create file 
            FileWriter a = new FileWriter("assesement5.txt");
            // write user nums
            a.write("USER ");
            for (int n : user) a.write(n + " ");
             //write dramn nums
            a.write("\nDRAWN ");
            for (int n : drawn) a.write(n + " ");
            // close file 
            a.close();
            System.out.println("\n Numbers written to assesement5.txt");
        }
        catch (Exception e) {
            System.out.println("File Write Error: " + e.getMessage());
        }
    }
    public static void readFromFile(int[] user, int[] drawn) {
        try {
            File file = new File("assesement5.txt");
            Scanner read = new Scanner(file);

            // Read USER numbers
            read.next(); // Skip "USER"
            for (int i = 0; i < 6; i++) {
                user[i] = read.nextInt();
            }

            // Read DRAWN numbers
            read.next(); // Skip "DRAWN"
            for (int i = 0; i < 6; i++) {
                drawn[i] = read.nextInt();
            }

            read.close();

            // Print results to confirm correct input
            System.out.print("\nRead from file - USER: ");
            printArray(user);
            System.out.print("Read from file - DRAWN: ");
            printArray(drawn);

        }
        catch (FileNotFoundException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
     public static void printArray(int[] arr) {
        for (int n : arr) {
            // print each element
            System.out.print(n + " ");
        }
        // move to next line
        System.out.println();

    }
}