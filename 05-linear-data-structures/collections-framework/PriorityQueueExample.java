import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main() {

        /**
         * PriorityQueue is a collection that implements the Queue interface and is based on a priority heap. It stores elements in a way that allows for efficient retrieval of the highest (or lowest) priority element. By default, it uses natural ordering of the elements, but you can also provide a custom comparator to define the priority.
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(8);
        priorityQueue.add(1);
        priorityQueue.add(3);

        System.out.println("PriorityQueue: " + priorityQueue);

        Integer head = priorityQueue.peek();
        System.out.println("Head of the PriorityQueue: " + head);

        Integer removedElement = priorityQueue.poll();
        System.out.println("Removed element: " + removedElement);
        System.out.println("PriorityQueue after removal: " + priorityQueue);
    }
}
