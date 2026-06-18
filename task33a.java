public class task33a {
    task33 head;
    void insert(int data){
        task33 newtask33 = new task33(data);
        if (head==null){
            head=newtask33;
            return;
        }
        task33 current =head;
        while(current.next !=null){
            current = current.next;
        }
        current.next =newtask33;

    }
     void display(){
            task33 current = head;
            while(current !=null){
            System.out.print(current.data + "->");
            current = current.next;
        }
       System.out.println("null");
    }
     void atfirst(int data){
            task33 newtask33 =new task33(data);
            newtask33.next =head;
            head =newtask33;
            return;
}
}