public class MiddleOfLinkedList {

    // Static Node class to represent each element of the linked list
    static class Node {
        int data;
        Node next;
        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    // Helper function to find the length of the linked list
    static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // Function to get the middle value of the linked list
    static int getMiddle(Node head) {
        int length = getLength(head);

        // Traverse till we reach half of the length
        int mid_index = length / 2;
        while (mid_index > 0) {
            head = head.next;
            mid_index--;
        }
        return head.data;
    }

    // Main method to test the getMiddle function
    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 10 -> 20 -> 30 -> 40 -> 50 -> 60
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        // Finding and printing the middle element
        System.out.println("Middle Element: " + getMiddle(head));
    }
}

