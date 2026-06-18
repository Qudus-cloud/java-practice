import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class task23 {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("task23.txt");
            String line;
            while (line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

