import java.util.Arrays;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
        /*if (nums == null || nums.length == 0) return -1;
        quickSort(nums, 0, nums.length - 1);
        int count = 1, max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1 < nums.length) && nums[i] == nums[i + 1]) count++;
            else if ((i + 1 >= nums.length)) count++;
            if ((i + 1 < nums.length) && nums[i] != nums[i + 1]) count = 0;
            if (count > max) {
                max = count;
                res = nums[i];
            }
        }
        return res;*/
    }

    public static void quickSort(int[] nums, int first, int last) {
        if (first >= last) return;
        int i = first;
        int j = last;
        int x = nums[i];
        while (i < j) {
            while ((i < j) && nums[j] >= x) j--;
            if (i < j) nums[i] = nums[j];
            while ((i < j) && nums[i] <= x) i++;
            if (i < j) nums[j] = nums[i];
        }
        nums[i] = x;
        quickSort(nums, first, i);
        quickSort(nums, i + 1, last);
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3, 2, 2, 2, 5}));
    }
}
