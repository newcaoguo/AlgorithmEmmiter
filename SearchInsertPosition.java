public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = i;
            if (nums[i] > target) return index; // 比第一个数字小的时候
            if (nums[i] == target) return index; // 出现等于的时候
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
