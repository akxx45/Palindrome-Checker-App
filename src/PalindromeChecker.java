import java.util.Scanner;

class PalindromeService {

    public boolean checkPalindrome(String str) {

        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        PalindromeService service = new PalindromeService();

        boolean result = service.checkPalindrome(str);

        if (result) {
            System.out.println("The string \"" + str + "\" is a Palindrome");
        } else {
            System.out.println("The string \"" + str + "\" is not a Palindrome");
        }
    }
}