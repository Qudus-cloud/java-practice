import java.io.FileWriter;
import java.io.IOException;
public class task21 {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter("task21.txt");
            writer.write("Hello i am here");
            writer.close();
            writer.write ("i am HIM");
            writer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
