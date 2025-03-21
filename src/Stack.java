public class Stack {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    boolean isEmpty(){
        return head == null;
    }

    void push(int data){
        Node newNode = new Node(data);
        if (newNode == null){
            System.out.println("Stack OverFlow");
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    void pop(){
        if (isEmpty()){
            System.out.println("Stack UnderFlow");
            return;
        }
        else {
            Node temp = head;
            head = head.next;
            temp = null;
        }
    }

    int peek() {
        if (!isEmpty())
            return head.data;

        else{
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
    }

    void displayStack(){
        Node current = head;
        System.out.println("Elements of stack ");
        while( current != null ){
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);
        st.displayStack();
        System.out.println("Top element is " + st.peek());

        System.out.println("Removing two elements");
        st.pop();
        st.pop();
        st.displayStack();
        System.out.println("Top element is " + st.peek());

    }
}
