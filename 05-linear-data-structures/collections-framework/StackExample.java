import java.util.Stack;

public class StackExample {

    public static void main() {

        /**
         * Stack is a collection that follows the Last-In-First-Out (LIFO) principle. It allows elements to be added and removed from the top of the stack. The Stack class in Java provides methods like push, pop, peek, and size to perform stack operations.
         */
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.size());

    }
}
