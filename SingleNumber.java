public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            // 进行异或运算
            // a⊕0=a
            //a⊕a=0
            a ^= nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 4, 4, 2, 2}));
    }
}
