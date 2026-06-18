public class task11 {
    static int a=10;
    static void display()
    {
        System.out.println("STATIC Method");
    }
    static
    {
        System.out.println("STATIC Block");
    }
}
class Main{
    public static void main(String[] args) {
        int a=20;
        System.out.println(a);
        System.out.println(task11.a);
        task11.display();
    }
}  

