public class DeletionAtIndex {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    //Deletion at given index
    public void Deletion(int index){
        if (index < 0 || head == null) {
            System.out.println("Invalid index or empty list.");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;
        int count = 0;

        // Traverse to the node at the given index
        while (current != null && count < index) {
            prev = current;
            current = current.next;
            count++;
        }

        // If the index is out of bounds
        if (current == null) {
            System.out.println("Index out of bounds.");
            return;
        }

        // Remove the node at the index by updating the previous node's next pointer
        prev.next = current.next;
    }

    public void display(){
        Node current = head;
        if (head==null){
            System.out.println("List is Empty");
            return;
        }
        System.out.println("Nodes of list are:");
        while(current!=null){
            System.out.println(current.data+" ");
            current= current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeletionAtIndex d = new DeletionAtIndex();
        d.addNode(2);
        d.addNode(5);
        d.addNode(6);
        d.addNode(7);
        d.display();
        d.Deletion(2);
        d.display();
    }
}



