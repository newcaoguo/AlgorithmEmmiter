public class PlusOne {
    /**
     * 1011
     * 1009
     * 1099
     * 9999
     */
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] plusOne = plusOne(new int[]{0});
        for (int i : plusOne) {
            System.out.print(i + " ");
        }
    }
}
