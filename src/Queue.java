public class Queue {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node front = null;
    public Node rear = null;

    void enqueue(int data){
        Node newNode = new Node(data);

        if(rear == null){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    void dequeue(){
        if(front == null){
            return;
        }

        Node  current = front;
        front = front.next;
        if(front == null)
            rear = null;

        current.next = null;
    }

    int peek(){
        if(front!=null)
            return front.data;
        return Integer.MIN_VALUE;
    }

    void displayQueue(){
        Node current = front;
        System.out.println("Elements of queue ");
        while( current != null ){
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.displayQueue();

        q.dequeue();
        q.dequeue();
        q.displayQueue();

        q.enqueue(40);
        q.enqueue(50);
        q.displayQueue();
        System.out.println("Front element is "+ q.peek());

    }
}
