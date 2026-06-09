import java.util.HashSet;

public class HashSetExample {

    public static void main() {
        /**
         * HashSet is a collection that implements the Set interface. It does not allow duplicate elements and does not maintain any order of insertion. It provides constant-time performance for basic operations like add, remove, and contains.
         */
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(30);
        hashSet.add(20); // Duplicate element, will not be added

        System.out.println("HashSet: " + hashSet);

        boolean contains20 = hashSet.contains(20);
        System.out.println("HashSet contains 20: " + contains20);

        hashSet.remove(20);
        System.out.println("HashSet after removing 20: " + hashSet);
    }
}
