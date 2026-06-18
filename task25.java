import javax.swing.JFrame;
import java.awt.Container;
public class task25 extends JFrame{
    private Container c;
    public task25(){
        super("application");
        c=getContentPane();
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        task25 t = new task25();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
