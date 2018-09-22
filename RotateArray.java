import org.junit.Test;

public class RotateArray {

    /*
     *  Input: [1,2,3,4,5,6,7] and k = 3
     *  Output: [5,6,7,1,2,3,4]
     */
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }

    }

    @Test
    public void test() {
        rotate(new int[]{1}, 1);
    }
}
