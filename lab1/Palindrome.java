public class Palindrome {

    public static String reverseString(String s) {
        String reversed = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            reversed = reversed + s.charAt(i);
        }

        return reversed;
    }

    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        return s.equals(reversed);
    }

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            String word = args[i];

            if (isPalindrome(word)) {
                System.out.println(word + " is a palindrome");
            } else {
                System.out.println(word + " is not a palindrome");
            }
        }
    }
}