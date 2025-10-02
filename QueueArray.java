public class QueueArray {
        private int[] arr;
        private int front, rear, size, capacity;

        // Constructor
        public QueueArray(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        // Enqueue - Insert element
        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is Full!");
                return;
            }
            rear = (rear + 1) % capacity; // Circular increment
            arr[rear] = data;
            size++;
        }

        // Dequeue - Remove element
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            int item = arr[front];
            front = (front + 1) % capacity; // Circular increment
            size--;
            return item;
        }

        // Peek - Get front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            return arr[front];
        }

        // isEmpty
        public boolean isEmpty() {
            return size == 0;
        }

        // isFull
        public boolean isFull() {
            return size == capacity;
        }

        // Display Queue
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return;
            }
            System.out.print("Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[(front + i) % capacity] + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            QueueArray q = new QueueArray(5);

            q.enqueue(10);
            q.enqueue(20);
            q.enqueue(30);
            q.enqueue(40);
            q.enqueue(50);
            q.display();

            System.out.println("Dequeued: " + q.dequeue());
            q.display();

            q.enqueue(60);
            q.display();

            System.out.println("Front Element: " + q.peek());
        }
    }
