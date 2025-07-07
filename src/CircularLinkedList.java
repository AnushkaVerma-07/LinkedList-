public class CircularLinkedList {
    class Node{
        int data;
        Node  next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void add(int data){
        Node newNode = new Node(data);
        if( head==null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public void display(){
        Node curr = head;
        if (head == null){
            System.out.println("List is empty");
            return;
        }

        System.out.println("Nodes of list are:");
        do{
            System.out.print(" "+ curr.data);
            curr = curr.next;
        }while(curr != head);
        System.out.println();

    }

    public static void main(String[] args) {
        CircularLinkedList obj = new CircularLinkedList();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.display();
    }   
}
