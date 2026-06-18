public class task32 {
    public String exponents(int count, int value){
        String result="";
        int state=1;
        for (int i=0;i<count;i++){
            result=result+state+"";
            state= state*value;
        }
        return result;
    }
        public static void main(String[] args) {
            task32 a = new task32();
            String b =a.exponents(3,34);
            System.out.println(b);

    }
}

