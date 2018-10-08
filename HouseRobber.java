import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int robot(int index, int[] nums) {
        if (index >= nums.length) {
            return 0;
        }
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        int a = nums[index] + robot(index + 2, nums);
        int b = 0 + robot(index + 1, nums);
        int c = Math.max(a, b);
        cache.put(index, c);
        return c;
    }

    public int rob(int[] nums) {
        cache.clear();
        if (nums.length == 0) return 0;
        return robot(0, nums);
    }
    
    public int rob(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for(int index = 2; index < nums.length; index++){
            result[index] = Math
                .max(nums[index] + result[index - 2], result[index - 1]);
        }
        return result[nums.length - 1];
    }

}
