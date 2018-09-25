import org.junit.Test;

public class SimpleSelectSortExample {

    // 简单选择排序
    public void simpleSelectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
            }
            if (minIndex != i){
                nums[i] = nums[i] ^ nums[minIndex];
                nums[minIndex] = nums[i] ^ nums[minIndex];
                nums[i] = nums[i] ^ nums[minIndex];
            }
        }

    }

    @Test
    public void test() {
        int[] nums = new int[]{9, 5, 3, 10, 32, 5};
        simpleSelectSort(nums);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }
}
