public class task30 {
    
    public String print(int number){
        String result="";
        while(number>0){
            int rem=number%2;
            result=rem+result;
            number/=2;
        }
        return result;
    }
    public static void main(String[] args) {
    task30 a = new task30();
    String b = a.print(13);
    System.out.println(b);
}
}
