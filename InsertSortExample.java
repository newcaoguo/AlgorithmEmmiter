import org.junit.Test;

public class InsertSortExample {
    // 插入排序
    public void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                nums[j] = nums[j] ^ nums[j - 1];
                nums[j - 1] = nums[j] ^ nums[j - 1];
                nums[j] = nums[j] ^ nums[j - 1];
            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{9, 5, 3, 10, 32, 5};
        insertSort(nums);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }
}
