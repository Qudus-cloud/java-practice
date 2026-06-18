import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
public class task27 extend JFrame{
    private Container c;
    private JLabel idLabel,passwordLabel, message;
    private JTextField id;
    private JPasswordField password;
    private JTextArea legal;
    public task27(){
        super{"login screen"};
        c=getContentPane();
        c.getLayout(new FlowLayout());
        idLabel =new JLabel("Enter ur ID");
        id = new JTextField("",12);

        passwordLabel=new JLabel("Enter password");
        password = new JPasswordField(8)
        password.setEchoChar('#');

        message = new JLabel("Login above");

        legal= new JTextArea("warning: any attempt to illegally \n" +"login to this server is punishabel by law \n");
        legal.setEditable(false);

        c.add(idLabel);
        c.add(id);
        c.add(passwordLabel);
        c.add(password);
        c.add(message);
        c.add(legal);

        TextFieldHandler tfh = new TextFieldHandler();

        id.addActionListener(tfh);
        password.addActionListener(tfh);

        setSize(500,500);
        setVisible(true);

        private class TextFieldHandler implements ActionListener{
            public void action parformed(ActionEvent e){
                if ((id.getText().equal("java"))&& (new String(password.getpassword())).equal("interesting")){
                    message.setForeground(Color.MAGENTA);
                    message.setText("welcome");

                }
                else{
                    message.setForeground(Color.RED);
                    message.setText("Sorry.Tty again");
                }
            }
        }
        public static void main(String[] args){
            task27 log = new task27();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }
}
