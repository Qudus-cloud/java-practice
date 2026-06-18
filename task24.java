import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task24 {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter( "task24.txt");
            Writer write( "John 25 \n Bob 22 \n Alice 30"); 
            writer. close();

             File file = new File( "people.txt");
             Scanner scanner = new Scanner (file);
              
             while (scanner.hasNext()) {
             String name = scanner.next()
          int a = scanner.nextInt();
            System.out.printin(name + a);
             scanner. close();
             catch.(I0Exception e) {
             System.out.println(e.getMessage());
        }
    }
}
