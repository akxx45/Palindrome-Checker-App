import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String str) {

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
}

class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String str) {

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
}

class PalindromeService {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String str) {
        return strategy.isPalindrome(str);
    }
}

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("Choose Strategy: 1. Stack  2. Deque");
        int choice = sc.nextInt();

        PalindromeService service = new PalindromeService();

        if (choice == 1) {
            service.setStrategy(new StackStrategy());
        } else {
            service.setStrategy(new DequeStrategy());
        }

        boolean result = service.check(str);

        if (result) {
            System.out.println("The string \"" + str + "\" is a Palindrome");
        } else {
            System.out.println("The string \"" + str + "\" is not a Palindrome");
        }
    }
}