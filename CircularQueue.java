public class CircularQueue {
        private int[] arr;
        private int front, rear, size, capacity;

        // Constructor
        public CircularQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = -1;
            rear = -1;
            size = 0;
        }

        // Enqueue
        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is Full!");
                return;
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = data;
            size++;
            System.out.println(data + " enqueued");
        }

        // Dequeue
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            int item = arr[front];
            if (front == rear) { // last element removed
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            size--;
            System.out.println(item + " dequeued");
            return item;
        }

        // Peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            return arr[front];
        }

        // Check empty
        public boolean isEmpty() {
            return front == -1;
        }

        // Check full
        public boolean isFull() {
            return ((rear + 1) % capacity) == front;
        }

        // Display
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return;
            }
            System.out.print("Queue: ");
            int i = front;
            while (true) {
                System.out.print(arr[i] + " ");
                if (i == rear) break;
                i = (i + 1) % capacity;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            CircularQueue cq = new CircularQueue(5);

            cq.enqueue(10);
            cq.enqueue(20);
            cq.enqueue(30);
            cq.enqueue(40);
            cq.display();

            cq.dequeue();
            cq.dequeue();
            cq.display();

            cq.enqueue(50);
            cq.enqueue(60);
            cq.display();

            cq.enqueue(70); // should show full
            System.out.println("Front Element: " + cq.peek());
        }
    }

