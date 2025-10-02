public class CustomQueueFixed {
        private int[] data;
        private int front, rear, size, capacity;

        public CustomQueueFixed(int capacity) {
            this.capacity = capacity;
            data = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        // Enqueue
        public void enqueue(int value) throws Exception {
            if (isFull()) {
                throw new Exception("Queue is Full!");
            }
            rear = (rear + 1) % capacity;  // circular increment
            data[rear] = value;
            size++;
        }

        // Dequeue
        public int dequeue() throws Exception {
            if (isEmpty()) {
                throw new Exception("Queue is Empty!");
            }
            int val = data[front];
            front = (front + 1) % capacity;
            size--;
            return val;
        }

        // Peek
        public int peek() throws Exception {
            if (isEmpty()) {
                throw new Exception("Queue is Empty!");
            }
            return data[front];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return;
            }
            System.out.print("Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(data[(front + i) % capacity] + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) throws Exception {
            CustomQueueFixed q = new CustomQueueFixed(5);

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

            System.out.println("Front: " + q.peek());
        }
}
