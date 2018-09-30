import org.junit.Test;

public class MinNumberInRotateArray {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，
     * 我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，
     * 输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
     * 该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    
    // 最笨的一种：遍历整个数组，找出其中最小的数。这样肯定拿不到offer
    
    // Second Method 
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }
    
    // Third Method 
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int middle = -1;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }

    @Test
    public void test(){
    }
}
