public class DeletionAtDoublyLL {
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

    public void DeleteFirst(){
        head=head.next;
    }

    public void DeleteLast(){
        tail = tail.prev;
        tail.next= null;
    }

    public void DeleteAtIndex(int pos){
        if(head == null && pos <1){
            System.out.println("Invalid index");
        }
        if(pos == 1){
            DeleteFirst();
        }
        else{
            Node curr = head;
            for(int i = 1; i < pos; i++){
                curr = curr.next;
            }
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
        }
        System.out.println("Deletion successfull at position "+ pos);
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
        DeletionAtDoublyLL obj = new DeletionAtDoublyLL();
        obj.addData(10);
        obj.addData(20);
        obj.addData(30);
        obj.addData(40);
        obj.addData(50);
        obj.display();
        obj.DeleteFirst();
        obj.display();
        obj.DeleteLast();
        obj.display();
        obj.DeleteAtIndex(2);
        obj.display();
    }
}
