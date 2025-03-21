public class Deletion {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

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


    //deletion from begining
    public void DeletionFirst(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        else{
            if( head != tail){
                head = head.next;
            }
            else
                head = tail = null;
        }
    }

    public void DeletionLast(){
        if( head==null){
            System.out.println("List is empty");
            return;
        }
        else{
            if(head!=tail){
                Node curr = head;
                while(curr.next !=tail){
                    curr=curr.next;
                }
                tail = curr;
                tail.next = null;
            }
            else{
                head = tail = null;
            }
        }
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

        Deletion d = new Deletion();
        d.addNode(1);
        d.addNode(5);
        d.addNode(3);
        d.display();
        d.DeletionFirst();
        d.DeletionLast();
        System.out.println("Updated List");
        d.display();
    }
}
