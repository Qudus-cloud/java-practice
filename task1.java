import java.util.Scanner;
class HelloWorld{
    public static void main(String[] args){
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what's your name");
        String name = scanner.nextLine();
        System.out.printf("Hello %s How old are you?",  name);
        int age = scanner.nextInt();
        scanner.close();
    }
}
}


