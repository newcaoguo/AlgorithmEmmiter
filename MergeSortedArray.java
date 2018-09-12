public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        if (n == 0) return;
        int i = 0, j = 0;
        int[] nums = new int[nums1.length + nums2.length];
        int k = 0;
        //  1, 2, 3, 0, 0, 0
        //  2, 5, 6
        while (i < m || j < n) {
            if (i < m && j < n && nums1[i] <= nums2[j]) {
                nums[k++] = nums1[i++];
            }
            if (i < m && j < n && nums1[i] > nums2[j]) {
                nums[k++] = nums2[j++];
            }
            if (i < m && j >= n) {
                nums[k++] = nums1[i++];
            }
            if (j < n && i >= m) {
                nums[k++] = nums2[j++];
            }
        }
        for (int l = 0; l < k; l++) {
            nums1[l] = nums[l];
        }
    }

    public static void main(String[] args) {
        merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }
}
