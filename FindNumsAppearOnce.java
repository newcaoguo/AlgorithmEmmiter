package com.company;

import org.junit.Test;

import java.util.HashMap;

public class FindNumsAppearOnce {
    //两个不相等的元素在位级表示上必定会有一位存在不同。
    //将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
    //diff &= -diff 得到出 diff 最右侧不为 0 的位，
    //也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，
    //利用这一位就可以将两个元素区分开来。
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], true);
            } else {
                map.put(array[i], false);
            }
        }
        int index = 0;//区分是第几个不重复的值
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i])) {
                index++;
                if (index == 1) {
                    num1[0] = array[i];
                } else {
                    num2[0] = array[i];
                }
            }
        }
    }

    @Test
    public void test() {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        // {1, 1, 4, 1, 1, 6}
        // {0,5,5,0,5}
        //{1, 1, 4, 6, 1, 1}
        //{0,5,5,5,0}
        FindNumsAppearOnce(new int[]{1, 1, 6, 1, 1, 4}, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }

}
