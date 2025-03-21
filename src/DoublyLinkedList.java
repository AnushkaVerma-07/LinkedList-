public class DoublyLinkedList {
    class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addData(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.prev = null;
            tail.next = null;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
    }
    public void display(){
        Node curr = head;
        if (head == null){
            System.out.println("List is empty");
            return;
        }

        System.out.println("Nodes of list are:");
        while(curr != null){
            System.out.println(curr.data +" ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList obj = new DoublyLinkedList();
        obj.addData(1);
        obj.addData(2);
        obj.addData(3);
        obj.display();
    }
}
