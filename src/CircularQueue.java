public class CircularQueue {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int size) {
            this.size = size;
            arr = new int[size];
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return (rear == -1 && front == -1);
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue overflow");
                return;
            }

            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue underflow");
                return -1;
            }
            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue underflow");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.peek());

    }
}
