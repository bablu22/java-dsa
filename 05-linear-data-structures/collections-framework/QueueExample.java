import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main() {

        /**
         * Queue is a collection that follows the First-In-First-Out (FIFO) principle. It allows elements to be added at the rear and removed from the front. The LinkedList class is commonly used to implement a Queue in Java.
         */
        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue: " + queue);

        int removedElement = queue.remove();
        System.out.println("Removed Element: " + removedElement);
        System.out.println("Queue after removal: " + queue);

        int peekedElement = queue.peek();
        System.out.println("Peeked Element: " + peekedElement);

        queue.offer(40);
        System.out.println("Queue after offering 40: " + queue);

    }
}
