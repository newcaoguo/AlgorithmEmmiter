import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NotRepeatNum {
    /**
     * 给一个数组，找两个不重复的数，要求时间复杂度为O（n）
     */
    public HashMap<Integer, Boolean> findNotRepeatNum(int[] nums) {
        HashMap<Integer, Boolean> mMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mMap.containsKey(nums[i])) {
                //singleNumList.remove(nums[i]);
                mMap.put(nums[i], false);
            } else {
                mMap.put(nums[i], true);
            }
        }
        return mMap;
    }

    @Test
    public void test() {
        System.out.println("Single number are: ");
        HashMap<Integer, Boolean> mNotRepeatNum = findNotRepeatNum(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 9});
        for (Map.Entry<Integer, Boolean> mHashMap : mNotRepeatNum.entrySet()) {
            if (mHashMap.getValue()) System.out.println(mHashMap.getKey());
        }
        System.out.println();
    }
}
