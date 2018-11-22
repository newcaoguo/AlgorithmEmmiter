package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GetMedian {

    ArrayList<Integer> mArray = new ArrayList<>();

    public void Insert(Integer num) {
        mArray.add(num);
    }

    public Double GetMedian() {
        Object[] objects = mArray.toArray();
        int[] tempArray = new int[objects.length];
        int i = 0;
        for (Object a : objects) {
            tempArray[i++] = (int) a;
        }
        Arrays.sort(tempArray);
//        quickSort(tempArray, 0, tempArray.length - 1);
        int index = tempArray.length - 1;
        if (index % 2 == 1)
            return (double) (tempArray[index / 2] +
                    tempArray[index / 2 + 1]) / 2;
        else
            return (double) tempArray[index / 2];
    }

    public void quickSort(int[] data, int left, int right) {

        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int x = data[i];
        while (i < j) {
            while (i < j && data[j] > x) j--;
            if (i < j) data[i] = data[j];

            while (i < j && data[i] < x) i++;
            if (i < j) data[j] = data[i];
        }
        data[i] = x;
        quickSort(data, left, i - 1);
        quickSort(data, i + 1, right);
    }

    @Test
    public void test() {
        //5,2,3,4,1,6,7,0,8
        Insert(5);
        System.out.print(GetMedian() + " ");

        Insert(2);
        System.out.print(GetMedian() + " ");

        Insert(3);
        System.out.print(GetMedian() + " ");

        Insert(4);
        System.out.print(GetMedian() + " ");

        Insert(1);
        System.out.print(GetMedian() + " ");

        Insert(6);
        System.out.print(GetMedian() + " ");

        Insert(7);
        System.out.print(GetMedian() + " ");

        Insert(0);
        System.out.print(GetMedian() + " ");

        Insert(8);
        System.out.print(GetMedian() + " ");

    }

    //"5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00 "
}
