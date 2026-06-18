import java.util.Scanner; 
public class assessment2 {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in) ;
     System.out.println("Enter High value");
     int x = scanner.nextInt();
     System.out.println("Enter Low value");
     int y = scanner.nextInt();
     while ( x<= y){
        System.out.println("Error");
        x = scanner.nextInt();
        System.out.println("Enter Low value");
        y = scanner.nextInt();
    }
    int z = y+ 1;
while (z < x) {
    System.out.println(z);
    z++;
} 
    if (y< 10){
        System.out.println("low is less than 10");
    }else{
        System.out.println("low is greater than 10");
     }
     switch(y){
        case 1 : System.out.println("y is 1");
                 break;
        case 2 : System.out.println("y is 2");  
                 break;
        default : System.out.println("y is not 1 or 2");  
                 break;   
        }
         System.out.println("Do-While Loop:");
         int count = 0;
        do  {
            System.out.println("Hello");
            y++;
        }
        while (y< y) ;
        System.out.println("Countdown:");
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
}
            
         }

        scanner.close();
        }
    }
      
