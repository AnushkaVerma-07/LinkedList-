public class InsertionAtDoublyLL {
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

    // Adding element at the begining of the doubly linkedlist

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.prev = null;
            tail.next = null;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
        }
    }

    // Adding element at the last of the doubly linkedlist
    public void addLast(int data){
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

    public void addAtIndex(int pos, int data){
        Node newNode = new Node(data);
        if(pos < 1){
            System.out.println("Invalid index");
            return;
        }
        if(pos == 1){
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
        }

        Node curr = head;
        for(int i = 1; i < pos-1; i++){
            curr = curr.next;
        }

        Node temp = null;
        //The temp node points to the node that is next to current
        temp = curr.next;
        temp.prev = curr;

        //newNode will be added between current and temp
        curr.next = newNode;
        newNode.prev = curr;
        newNode.next = temp;
        temp.prev = newNode;
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
        InsertionAtDoublyLL obj = new InsertionAtDoublyLL();
        obj.addFirst(1);
        obj.addFirst(2);
        obj.addFirst(3);
        obj.display();
        obj.addLast(4);
        obj.addLast(5);
        obj.display();
        obj.addAtIndex(2,5);
        obj.display();
    }
}
