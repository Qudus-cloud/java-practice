class LinkedList{

    Node head;               // Reference to the first node of the list

    void insert(int data) {  // Method to insert a new value

        Node newNode = new Node(data); // Create a new node object

        // Check if the list is empty
        if (head == null) {          // If no node exists
            head = newNode;          // Make new node the first node
            return;                  // Stop method execution
        }

        Node current = head;         // Start from the first node

        // Move current to the last node
        while (current.next != null) { // While next node exists
            current = current.next;    // Move to the next node
        }

        current.next = newNode;      // Link last node to new node
    }

    void display() {                 // Method to print the list

        Node current = head;         // Start from the first node

        // Traverse through the list
        while (current != null) {    // While current node exists
            System.out.print(current.data + " -> "); // Print value
            current = current.next;  // Move to next node
        }

        System.out.println("null");  // End of the list
    }

    // Method for seraching for a node

        boolean search(int value) {

        Node current = head;         // start from first node

        // Traverse the list
        while (current != null) {

            if (current.data == value) { // value found
                return true;             // stop and return true
            }

            current = current.next;      // move to next node
        }

        return false;  // value not found after full traversal
    }

// Method for adding a node at the start
    void addAtStart(int value) {

    Node newNode = new Node(value); // create new node

    newNode.next = head;            // new node points to old head

    head = newNode;                 // head now points to new node
    }

// Method for inserting at any position
    void insertAtPosition(int value, int position) {

        Node newNode = new Node(value);

        // Case 1: insert at start (position 0)
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;

        // Move to node beforehe position
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of range");
                returng;
            }
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

// Method for deleting first node
    void deleteFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
    }

// Method for deleting last node
    void deleteLast() {

        // Empty list
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Only one node
        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        // Move to second-last node
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

// Method for deleting at any position

    void deleteAtPosition(int position) {

        // Empty list
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Delete first node
        if (position == 0) {
            head = head.next;
            return;
        }

        Node current = head;

        // Move to node before the one to delete
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) {
                System.out.println("Position out of range");
                return;
            }
            current = current.next;
        }

        current.next = current.next.next;
    }

}

