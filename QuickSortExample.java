import org.junit.Test;

public class QuickSortExample {

    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int x = nums[i];
        while (i < j) {
            while (i < j && nums[j] > x) j--;
            if (i < j) nums[i] = nums[j];

            while (i < j && nums[i] < x) i++;
            if (i < j) nums[j] = nums[i];
        }
        nums[i] = x;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    @Test
    public void test() {
        int[] nums = {23, 2, 354, 134, 12, 58, 423, 483, 131, 56};

        quickSort(nums, 0, nums.length - 1);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }
}
