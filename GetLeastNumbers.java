package com.company;

import org.junit.Test;

import java.util.ArrayList;

public class GetLeastNumbers {
    public int[] topK(int[] nums, int k) {
        if (k > nums.length) {
            return new int[]{};
        }
        // min k
        int[] top = new int[k];
        for (int i = 0; i < top.length; i++) {
            // 初始化值
            top[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < top[0]) {
                // 如果比堆顶值小，则替换堆顶并执行下沉操作
                top[0] = nums[i];
                adjustHeap(top, 0, top.length);
            }
        }
        return top;
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp 值放到最终的位置
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k == 0) return new  ArrayList<Integer>() ;
        int[] kData = topK(input, k);
        ArrayList<Integer> mIntegerArrayList = new ArrayList<>();
        for(int a : kData){
            mIntegerArrayList.add(a);
        }
        return mIntegerArrayList;
    }

    @Test
    public void test() {
        //[4,5,1,6,2,7,3,8],4
        int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> mIntegerArrayList =
                GetLeastNumbers_Solution(input, 4);
        for(Integer a : mIntegerArrayList){
            System.out.print(a + " ");
        }
    }
}
