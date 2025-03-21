public class Insertion {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head= null;
    public Node tail= null;

    //Insertion at Begining
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        Node temp = head;
        head = newNode;
        head.next = temp;
    }

    //Insertion at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }


    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        System.out.println("Nodes of list are:");
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Insertion l = new Insertion();
        l.addFirst(1);
        l.addFirst(2);
        l.addLast(3);
        l.display();

    }
}
