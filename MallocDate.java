package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 男女匹配算法
 * 公司内男女配对安排
 * 每次动态分配
 */
public class MallocDate {
    public List<HashMap<String, String>> mallocList(String[] manArray,
                                                    String[] womanArray) {
        List<HashMap<String, String>> mapList = new ArrayList<>();
        if (manArray == null || manArray.length == 0 ||
                womanArray == null || womanArray.length == 0)
            return mapList;

        helper(mapList, manArray, womanArray, new HashMap<>(),
                (int) (Math.random() * (manArray.length)),
                (int) (Math.random() * (womanArray.length)));
        return mapList;
    }

    private void helper(List<HashMap<String, String>> mapList,
                        String[] manArray, String[] womanArray,
                        HashMap<String, String> hashMap,
                        int manStart, int womanStart) {
        if (manStart >= manArray.length || womanStart >= womanArray.length)
            return;

        for (int i = manStart; i < manArray.length + manStart; i++) {
            for (int j = womanStart; j < womanArray.length + womanStart; j++) {

                if (!hashMap.containsKey(manArray[i % manArray.length]) &&
                        !hashMap.containsValue(womanArray[j % womanArray.length])) {
                    hashMap.put(manArray[i % manArray.length],
                            womanArray[j % womanArray.length]);
                    System.out.println(manArray[i % manArray.length] + " -> " + womanArray[j % womanArray.length]);
                    helper(mapList, manArray, womanArray,
                            hashMap, i + 1, j + 1);
                }

                if (hashMap.containsKey(manArray[i % manArray.length]) &&
                        !hashMap.containsValue(womanArray[j % womanArray.length])) {
                    helper(mapList, manArray, womanArray,
                            hashMap, i + 1, j);
                }

                if (!hashMap.containsKey(manArray[i % manArray.length]) &&
                        hashMap.containsValue(womanArray[j % womanArray.length])) {
                    helper(mapList, manArray, womanArray,
                            hashMap, i, j + 1);
                }

            }
        }
        mapList.add(new HashMap<>(hashMap));
    }

    @Test
    public void test() {
        String[] manArray = new String[]{"许名勇", "李四", "王五", "赵六"};
        String[] womanArray = new String[]{"小红", "小美", "小柔", "小花"};
        mallocList(manArray, womanArray);
    }
}
