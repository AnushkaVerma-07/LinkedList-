public class reverseLinkedList {

    // Definition for the Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;  // Use 'this' to refer to the instance variable
            next = null;
        }
    }

    // Head of the linked list
    Node head;

    // Method to reverse the linked list
    public static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Method to print the linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Method to add a new node at the end of the list
    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Main method to test the linked list reversal
    public static void main(String[] args) {
        reverseLinkedList list = new reverseLinkedList();

        // Adding nodes to the list
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        // Printing original list
        System.out.println("Original Linked List:");
        printList(list.head);

        // Reversing the linked list
        list.head = reverseList(list.head);

        // Printing reversed list
        System.out.println("Reversed Linked List:");
        printList(list.head);
    }
}
