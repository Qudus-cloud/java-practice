public class task3{
    public int getName(){
        int name;
        System.out.println("please input a string");
        name= Genio.getInteger();
        return name;
    }
        public static void main(String []args){
            task3 obj1 =new task3();
            int App = obj1.getName();
            System.out.println("the name is:" + App);
        }
    }

        
