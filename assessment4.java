// Main program
import java.util.Scanner;
public class assessment4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Ask the user what type of beverage they want to create
        System.out.println("What Type of Beverage do you want");
        System.out.println("MilkBeverage");
        System.out.println("AlcoholicBeverage");
        int choice =input.nextInt();
        input.nextLine();

        if (choice == 1){
            // collect data for milk beverage
            System.out.println("Enter flavour");
            String flavour = input.nextLine();

            System.out.println("Enter size(small/meduim/large):");
            String size = input.nextLine();

            System.out.println("Enter cost");
            double cost = input.nextDouble();

            // create the milk beverage
            MilkBeverage m = new MilkBeverage("Milk Beverage", cost, size, flavour);
            m.printAttributes();
        }
        else if (choice == 2){
            // collect data for Alcoholic Beverage
            System.out.println("Enter strength");
            String strength = input.nextLine();

            System.out.println("Enter size(small/meduim/large):");
            String size = input.nextLine();

            System.out.println("Enter cost");
            double cost = input.nextDouble();

            // create the Alcoholic Beverage
           AlcoholicBeverage a = new AlcoholicBeverage("Alcoholic Beverage",cost, size, strength);
            a.printAttributes();
        }
        else{
            // is they did not pick milk beverage or Alcoholic Beverage
            System.out.println("not availabale");
        }
        // close scanner
        input.close();
 
    }
    
}
