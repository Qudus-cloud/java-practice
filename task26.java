import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
public class task26 extends JFrame {
    private Container c;
    private JLabel labelText;
    private JLabel labelImage;
    public task26(){
        super("What's for dinner?");
        c=getContentPane();
        c.setLayout(new FlowLayout());
        labelText = new JLabel("Spaghetti tonight");
        labelText.setForeground(Color.WHITE);
        labelText.setBackground(Color.BLUE);
        labelText.setOpaque(true);
        labelImage=new JLabel(new ImageIcon("C:\\Users\\HP\\Desktop\\abc.jpg"));
        labelImage.setToolTipText("Difficulty");
        c.add(labelText);
        c.add(labelImage);
        setSize(600,600);
        setVisible(true);
    
    }
    public static void main(String[] args) {
        task26 t =new task26();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
