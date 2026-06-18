import java.util.Scanner;
public class task5{
    public static void main (String[] args){
Scanner scanner = new Scanner (System.in);
System.out.println("Enter a number");
int x = scanner.nextInt();
switch(x){
    case 1: System.out.println("x=1");
            break;
    case 2: System.out.println("x=2");
            break;
    case 3: System.out.println("x=3");        
            break;
    case 4: System.out.println("x=4"); 
            break;
    case 5: System.out.println("x=5");              
            break;
    default: System.out.println("x not 1 top 5");
            break;
}
    scanner.close();
    }
}