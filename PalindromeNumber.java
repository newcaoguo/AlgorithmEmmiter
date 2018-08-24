public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (reverse(x) == x && x >= 0)
            return true;
        else
            return false;
    }

    // 123
    // 3  12

    public static int reverse(int x) {
        int temp = x;
        int result = 0;
        while (temp != 0) {
            int pop = temp % 10;
            temp /= 10;
            if ((result > Integer.MAX_VALUE / 10) ||
                    ((result == (Integer.MAX_VALUE / 10)) && pop > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 ||
                    (result > Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(8));
        System.out.println(isPalindrome(8));
    }
}
