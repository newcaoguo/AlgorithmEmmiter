package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintMinNumber {
    /**
     * 输入一个正整数数组，
     * 把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
     * 则打印出这三个数字能排成的最小数字为321323。
     */
    List<String> mList = new ArrayList<>();
    String mStr = "";

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return mStr;
        PrintMinNumber(numbers, 0, numbers.length - 1);
        long min = Long.MAX_VALUE;
        for (String s : mList) {
            System.out.println(s);
            if (min > Long.parseLong(s)) min = Long.parseLong(s);
        }
        return min + "";
    }

    public void PrintMinNumber(int[] numbers, int from, int to) {
        if (from == to) {
            for (int i = 0; i <= to; i++) {
                mStr += numbers[i];
            }
            mList.add(mStr);
            mStr = "";
        } else {
            for (int i = from; i <= to; i++) {
                if (!isSwap(numbers, from, i)) continue;
                swap(numbers, i, from);
                PrintMinNumber(numbers, from + 1, to);
                swap(numbers, i, from);
            }
        }
    }

    //去重
    public boolean isSwap(int[] numbers, int from, int to) {
        for (int i = from; i < to; i++) {
            if (numbers[to] == numbers[i]) return false;
        }
        return true;
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    @Test
    public void test() {
        System.out.println(PrintMinNumber(new int[]{3334, 3, 3333332}));
    }
}
