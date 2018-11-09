package com.company;

import org.junit.Test;

public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],
                             int length,
                             int[] duplication) {
        if (numbers == null || numbers.length == 0) return false;
        quickSort(numbers, 0, length - 1);
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        duplication[0] = -1;
        return false;
    }

    public void quickSort(int numbers[], int left, int right) {
        int i = left;
        int j = right;
        if (left < right) {
            int temp = numbers[i];
            while (i < j) {
                while ((i < j) && numbers[j] >= numbers[i]) j--;
                if (i < j) numbers[i++] = numbers[j];
                while ((i < j) && numbers[i] <= numbers[j]) i++;
                if (i < j) numbers[j--] = numbers[i];
            }
            numbers[j] = temp;
            quickSort(numbers, left, j - 1);
            quickSort(numbers, j + 1, right);
        }
    }

    @Test
    public void test() {
        int[] a = new int[]{2, 1, 3, 0, 4};
        quickSort(a, 0, a.length - 1);
        int[] duplication = new int[a.length];
        System.out.println(duplicate(a, a.length, duplication));
        System.out.println(duplication[0]);
    }

}
