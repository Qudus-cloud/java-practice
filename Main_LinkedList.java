public class Main_LinkedList{

    public static void main(String[] args) {

        LinkedList list = new LinkedList(); // Create a LinkedList object

        list.insert(10);   // Insert first value
        list.insert(20);   // Insert second value
        list.insert(30);   // Insert third value

        list.display();    // Display all values

        list.addAtStart(40);

        list.display();

        list.insertAtPosition(50, 3);

        list.display();

        list.deleteFirst();

        list.deleteLast();

        list.display();

        list.deleteAtPosition(2);

        list.display();

        System.out.println(list.search(20)); // true
        System.out.println(list.search(40)); // false
    }
}

