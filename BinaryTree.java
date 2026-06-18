public class BinaryTree {
    Node2 root;
    BinaryTree(){
        root=null;
    }
    public void createsampleTree(){
        root =new Node2(10);
        root.left = new Node2(5);
        root.right = new Node2(20);
        root.right.right = new Node2(25);
        root.left.left = new Node2(3);
        root.left.right = new Node2(7);
    }
        