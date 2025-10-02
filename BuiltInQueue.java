
import java.util.Queue;
import java.util.LinkedList;

    public class BuiltInQueue {
        public static void main(String[] args) {
            Queue<Integer> q = new LinkedList<>();

            // Enqueue
            q.add(10);
            q.add(20);
            q.add(30);
            q.add(40);

            System.out.println("Queue: " + q);

            // Dequeue
            System.out.println("Dequeued: " + q.remove());
            System.out.println("Queue after dequeue: " + q);

            // Peek
            System.out.println("Front Element: " + q.peek());

            // Size
            System.out.println("Queue Size: " + q.size());
        }
    }

