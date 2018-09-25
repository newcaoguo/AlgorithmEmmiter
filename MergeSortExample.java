import org.junit.Test;

public class MergeSortExample {

    public void merge(int[] nums, int start, int mid, int end, int[] tmp) {
        // 合并 [start ... mid] - [mid + 1 ... end] 两个数组
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }

        for (int n = 0; n < k; n++) {
            nums[start + n] = tmp[n];
        }
    }

    public void mergeSort(int[] nums, int start, int end, int[] tmp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid, tmp);
            mergeSort(nums, mid + 1, end, tmp);
            merge(nums, start, mid, end, tmp);
        }
    }

    @Test
    public void test() {
        int[] nums = {6, 9, 8, 2, 3, 1, 20, 3, 6, 98, 10};
        int[] tmp = new int[nums.length];

        mergeSort(nums, 0, nums.length - 1, tmp);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }
}
