package TwoPointer.canBePalindromeWithOneLetterRemoved;

public class CanBePalindrome {
    public static boolean CanBe(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                String option1 = s.substring(0, left) + s.substring(left + 1, right) + s.substring(right);
                String option2 = s.substring(0, left + 2) + s.substring(left + 1, right) + s.substring(right);
                return isPalindrome(option1) || isPalindrome(option2);
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}
