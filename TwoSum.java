import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /* public int[] twoSum(int[] nums, int target) {
         for (int i = 0; i < nums.length; i++) {
             int complement = nums[i];
             for (int j = 1; j < nums.length; j++) {
                 if (complement + nums[j] == target) {
                     return new int[]{i, j};
                 }
             }
         }
         throw new IllegalArgumentException("No two sum solution");
     }*/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                return new int[]{i, hashMap.get(complement)};
            }
        }
        return null;
    }
}
