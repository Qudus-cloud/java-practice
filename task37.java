public class task37 {
    Node front;
    Node rear;
    void enqueue(int value){
    Node  newNode = new Node(value);
    if (rear == null){
        rear=front=newNode;
        return;
    }
        rear.next =newNode;
        rear= newNode;
    }
        front.next=newNode;
        front= newnode;
}



