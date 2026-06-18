class Node2{                 // Defines a Node class
    int data;                // Stores the value of the node
    Node2 left;               // Reference to the left node
    Node2 right;              // Refrence to the right node 


    Node2(int data) {         // Constructor to create a node
        this.data = data;    // Assign value to the node
        this.left = null;    // Set next as null (no next node yet)
        this.right =null;
    }
}
