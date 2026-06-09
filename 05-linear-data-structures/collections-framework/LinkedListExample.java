import java.util.LinkedList;

public class LinkedListExample {
    
    public static void main() {
        
        /**
         * LinkedList is a doubly-linked list implementation of the List and Deque interfaces. It allows duplicate elements and maintains the order of insertion. It provides efficient insertion and deletion operations, but random access to elements is slower compared to ArrayList.
         */
        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println(numbers);

        System.out.println(numbers.get(1));

        numbers.set(1, 100);
        System.out.println(numbers);

        numbers.remove(0);
        System.out.println(numbers);
        System.out.println(numbers.size());

        Object arr[]=numbers.toArray();

        for(Object obj:arr){
            System.out.println(obj);
        }
    }
}
