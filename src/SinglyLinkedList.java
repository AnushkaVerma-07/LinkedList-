public class SinglyLinkedList {
    //Create a class Node which has two attributes: data and next.
    // Next is a pointer to the next node.
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    //addNode() will add a new node to the list:
    //Create a new node.
    //It first checks, whether the head is equal to null which means the list is empty.
    //If the list is empty, both head and tail will point to the newly added node.
    //If the list is not empty, the new node will be added to end of the list such that tail's next will point to the newly added node.
    // This new node will become the new tail of the list.


    //Represent the head and tail of the singly linked list
    public Node head= null;
    public Node tail= null;
    public void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    //display() will display all the nodes present in the list
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
        SinglyLinkedList l = new SinglyLinkedList();
        l.addNode(1);
        l.addNode(2);
        l.addNode(3);

        l.display();
    }
}
