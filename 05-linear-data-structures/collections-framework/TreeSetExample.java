import java.util.TreeSet;

public class TreeSetExample {

    public static void main() {

        /**
         * TreeSet is a sorted collection that implements the Set interface. It stores elements in a sorted order and does not allow duplicate elements.
         */
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(20); // Duplicate element, will not be added
    
        System.out.println("TreeSet: " + treeSet);
        boolean contains20 = treeSet.contains(20);
        System.out.println("TreeSet contains 20: " + contains20);

        treeSet.remove(20);
        System.out.println("TreeSet after removing 20: " + treeSet);


    }
}
