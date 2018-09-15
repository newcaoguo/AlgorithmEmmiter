/**
 * 获得字符串的最长回文串
 */
public class MaxArray {

    public static void main(String[] args) {
        String str = "aaabccc";
        System.out.println(getMaxArray(str));
    }

    public static boolean isSymmetric(String mString) {
        int i = 0;
        int j = mString.length() - 1;
        while (i < j) {
            if (mString.charAt(i++) != mString.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static String getMaxArray(String mString) {
        if (isSymmetric(mString)) return mString;
        String result = null;
        int length;
        int maxLength = Integer.MIN_VALUE;
        for (int i = mString.length(); i > 1; i--) {
            for (int j = 0; j < i; j++) {
                String temp = mString.substring(j, i);
                length = temp.length();
                if (isSymmetric(temp) && maxLength < length) {
                    result = temp;
                    maxLength = length;
                }
            }
        }
        return result;
    }

}