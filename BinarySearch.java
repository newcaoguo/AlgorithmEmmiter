public class BinarySearch {

    public static int binarySearch(int[] nums, int start, int end, int val) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;    //防止溢位
        if (val > nums[mid])
            return binarySearch(nums, mid + 1, end, val);
        if (val < nums[mid])
            return binarySearch(nums, start, mid - 1, val);

        return mid;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, -1, 5, 6, 3};
        System.out.println(binarySearch(nums, 0, nums.length - 1, 6));
    }
}
