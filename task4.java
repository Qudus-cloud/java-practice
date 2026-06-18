import java.util.Scanner;
public class task4{
    public static void main (String[] args){
Scanner scanner = new Scanner (System.in);

System.out.println("Enter a number");
int i = scanner.nextInt();
if (i %2==0){
    System.out.println("i is an even number");
}
else
{
    System.out.println("i is an odd number");
}
scanner.close();
}
}


