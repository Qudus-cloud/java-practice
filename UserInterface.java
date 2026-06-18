// imporybscanner for user input
import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) {
        // create scanner object
        Scanner a = new Scanner(System.in);
        int choice = 0;

        do {
            // print menu
            System.out.println("===== Fitness Tracker Menu =====");
            System.out.println("1. Pretty print step statistics");
            System.out.println("2. Convert distance (km) into steps");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
             // read the user menu chioce
            choice = a.nextInt();
             // if option one is picked
            if (choice == 1) {
                // asl unser for thousands, hundreds and tens
                System.out.print("Enter thousands: ");
                int t = a.nextInt();

                System.out.print("Enter hundreds: ");
                int h = a.nextInt();

                System.out.print("Enter tens: ");
                int ten = a.nextInt();
                 // create stepstat object with input
                stepstat stats = new stepstat(t, h, ten);
                // output
                System.out.println("Pretty format: " + stats.prettyPrint());

              // if option two was picked instead
            } else if (choice == 2) {
                // ask for input
                System.out.print("Enter distance in km: ");
                double km = a.nextDouble();
                 
                Distance d = new Distance(km);
                //convert to steps
                stepstat converted = d.convert();
                 // ouput
                System.out.println("Equivalent steps: " + converted.prettyPrint());
            }
        // if exit was picked
        } while (choice != 3);
         // ouput
        System.out.println("Goodbye!");

        // close scanner
         a.close();
    }
}

