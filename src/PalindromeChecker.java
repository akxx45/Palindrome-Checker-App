import java.util.*;

public class PalindromeChecker {

    public static boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeMethod(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static boolean twoPointerMethod(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        long startTime, endTime;

        startTime = System.nanoTime();
        boolean result1 = stackMethod(str);
        endTime = System.nanoTime();
        System.out.println("Stack Method: " + result1 + " | Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        boolean result2 = dequeMethod(str);
        endTime = System.nanoTime();
        System.out.println("Deque Method: " + result2 + " | Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        boolean result3 = twoPointerMethod(str);
        endTime = System.nanoTime();
        System.out.println("Two Pointer Method: " + result3 + " | Time: " + (endTime - startTime) + " ns");
    }
}