public class ValidPalindrome {
    /**
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * <p>
     * Input: "race a car"
     * Output: false
     */
    public static boolean isPalindrome(String s) {
        int i = 0;
        char[] chars = new char[s.length()];
        for (char c : s.toCharArray()) {
            if (isAlphanmertic(c)) {
                chars[i++] = c;
            }
        }
        StringBuilder lowerCaseSB = new StringBuilder();
        for (int j = 0; j < i; j++) {
            lowerCaseSB.append(chars[j]);
        }
        String lowerCaseStr = lowerCaseSB.toString();
        lowerCaseStr = lowerCaseStr.toLowerCase();
        // 当字符串只有 一个 或者 没有字符 的时候，代表 true
        // raceacar
        if (lowerCaseStr.length() <= 1) return true;
        int count = 0;
        int left = 0;
        int right = lowerCaseStr.length() - 1;
        char leftChar = lowerCaseStr.charAt(left++);// r
        char rightChar = lowerCaseStr.charAt(right--);// r
        count += 2;
        if (leftChar != rightChar) return false;
        while ((leftChar == rightChar) && (left <= right)) {
            if (left == right)
                count++;
            if (left < right)
                count += 2;
            leftChar = lowerCaseStr.charAt(left++);// a c e
            rightChar = lowerCaseStr.charAt(right--);//a c a
            if (leftChar != rightChar) return false;
        }
        if (count == lowerCaseStr.length()) return true;
        return false;
    }

    /**
     * 判断是否为字母
     *
     * @param c
     * @return
     */
    public static boolean isAlphanmertic(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0p"));
    }
}
