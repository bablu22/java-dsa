import java.util.TreeMap;

public class TreeMapExample {

    public static void main() {

        /**
         * TreeMap is a sorted collection that implements the Map interface. It stores key-value pairs in a sorted order based on the natural ordering of the keys or a custom comparator. It does not allow duplicate keys and provides efficient retrieval of values based on keys.
         */
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(2, "Duplicate Key"); // Duplicate key, will overwrite the previous value

        System.out.println("TreeMap: " + treeMap);

        String value = treeMap.get(2);
        System.out.println("Value for key 2: " + value);

        treeMap.remove(1);
        System.out.println("TreeMap after removing key 1: " + treeMap);
    }
}
