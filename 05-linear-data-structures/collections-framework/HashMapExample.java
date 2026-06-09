import java.util.HashMap;

public class HashMapExample {

    public static void main() {
        /**
         * HashMap is a collection that implements the Map interface. It stores key-value pairs and allows null values and one null key. It provides constant-time performance for basic operations like get and put, but does not maintain any order of insertion.
         */
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);

        System.out.println("HashMap: " + hashMap);

        int value = hashMap.get("Two");
        System.out.println("Value for key 'Two': " + value);

        hashMap.remove("Two");
        System.out.println("HashMap after removing key 'Two': " + hashMap);
    }
}
