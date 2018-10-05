public class ReOrderArray {
    /**
     * 输入一个整数数组，
     * 实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，
     * 偶数和偶数之间的相对位置不变。
     */
    public void reOrderArray(int[] array) {
        int[] oddArray = new int[array.length];
        int[] evenArray = new int[array.length];
        int odd = 0, even = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) evenArray[even++] = array[i];
            else if (array[i] % 2 == 1) oddArray[odd++] = array[i];
        }
        for (int i = 0; i < odd; i++) {
            array[i] = oddArray[i];
        }
        for (int i = 0; i < even; i++) {
            array[i + odd] = evenArray[i];
        }
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public void test() {

    }
}
