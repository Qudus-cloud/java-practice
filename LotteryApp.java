

public class LotteryApp {

    public static void main(String[] args) {
        int[] userNumbers = new int[6];
        int[] drawnNumbers = new int[6];

        // 1. get user numbers
        userNumbers = getUserNumbers();

        // 2. generate lottery numbers
        drawnNumbers = generateRandomNumbers();

        // 3. write to file
        writeToFile(userNumbers, drawnNumbers);

        // 4. read back from file
        int[] userFromFile = new int[6];
        int[] drawnFromFile = new int[6];
        readFromFile(userFromFile, drawnFromFile);

        // 5. compare numbers
        int matches = compareArrays(userFromFile, drawnFromFile);
        System.out.println("\nNumber of matches: " + matches);
    }

    // ------------------------------------------------------------
    // Generate UNIQUE random numbers between 1–50
    // ------------------------------------------------------------
    public static int[] generateRandomNumbers() {
        Random rand = new Random();
        int[] numbers = new int[6];
        int count = 0;

        while (count < 6) {
            int num = rand.nextInt(50) + 1;

            if (!contains(numbers, num)) {
                numbers[count] = num;
                count++;
            }
        }

        System.out.print("Drawn numbers: ");
        printArray(numbers);
        return numbers;
    }

    // ------------------------------------------------------------
    // Get user 6 unique numbers between 1–50
    // ------------------------------------------------------------
    public static int[] getUserNumbers() {
        Scanner input = new Scanner(System.in);
        int[] userNums = new int[6];
        int count = 0;

        System.out.println("Enter 6 unique numbers between 1-50:");

        while (count < 6) {
            System.out.print("Enter number " + (count + 1) + ": ");
            int num = input.nextInt();

            if (num < 1 || num > 50) {
                System.out.println("❌ Out of range. Try again.");
            } else if (contains(userNums, num)) {
                System.out.println("❌ Duplicate detected. Try again.");
            } else {
                userNums[count] = num;
                count++;
            }
        }

        System.out.print("Your numbers: ");
        printArray(userNums);
        return userNums;
    }

    // ------------------------------------------------------------
    // Check if array contains number
    // ------------------------------------------------------------
    public static boolean contains(int[] arr, int n) {
        for (int value : arr) {
            if (value == n) return true;
        }
        return false;
    }

    // ------------------------------------------------------------
    // Compare arrays and count matches
    // ------------------------------------------------------------
    public static int compareArrays(int[] a, int[] b) {
        int match = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    match++;
                }
            }
        }
        return match;
    }

    // ------------------------------------------------------------
    // Write to text file
    // ------------------------------------------------------------
    public static void writeToFile(int[] user, int[] drawn) {
        try {
            FileWriter fw = new FileWriter("lottery.txt");
            fw.write("USER ");
            for (int n : user) fw.write(n + " ");
            fw.write("\nDRAWN ");
            for (int n : drawn) fw.write(n + " ");
            fw.close();
            System.out.println("\n✔ Written to file successfully.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------
    // Read from file
    // ------------------------------------------------------------
    public static void readFromFile(int[] user, int[] drawn) {
        try {
            File file = new File("lottery.txt");
            Scanner read = new Scanner(file);

            read.next(); // skip "USER"
            for (int i = 0; i < 6; i++) {
                user[i] = read.nextInt();
            }

            read.next(); // skip "DRAWN"
            for (int i = 0; i < 6; i++) {
                drawn[i] = read.nextInt();
            }

            read.close();

            System.out.print("\nRead from file - USER: ");
            printArray(user);
            System.out.print("Read from file - DRAWN: ");
            printArray(drawn);

        } catch (FileNotFoundException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------
    // Print array
    // ------------------------------------------------------------
    public static void printArray(int[] arr) {
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }
}
