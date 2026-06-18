import java.io.FileWriter;
import java.io.IOException;
public class task22 {
     public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter("task22.txt",+ve);
            writer.write("Hello i am here");
            writer.close();
            FileWriter writer = new FileWriter("task22.txt",+ve);
            writer.write ("i am HIM");
            writer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

