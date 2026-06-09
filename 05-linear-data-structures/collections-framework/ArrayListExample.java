import java.util.ArrayList;

public class ArrayListExample {

    public static void main() {

        /**
         * ArrayList is a resizable array implementation of the List interface. It allows duplicate elements and maintains the order of insertion. It provides dynamic resizing and allows random access to elements.
         */
        ArrayList<Integer> numbers = new ArrayList<>();

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
