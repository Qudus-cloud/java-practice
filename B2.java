public class B2 extends A2{
    int a=40;
    void diplay(){
        System.out.println("child");
        System.out.println(a);
        System.out.println(super.a);
        super.display();
    }
}
