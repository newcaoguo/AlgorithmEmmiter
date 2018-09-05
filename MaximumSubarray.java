public class MaximumSubarray {
    /**
     * 计算子串中最大子串之和
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + (sum < 0 ? 0 : sum);
            max = max > sum ? max : sum;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, 3, -5, 6, 8}));
    }
}
