package com.company;

import org.junit.Test;

public class StrToInt {


    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        boolean isPositive = true;
        int base = 1;

        if (str.charAt(0) == '+') isPositive = true;
        else if (str.charAt(0) == '-') isPositive = false;
        else base = 0;

        long res = 0;
        int k = 0;
        for (int i = str.length() - 1; i >= base; i--) {
            if (str.charAt(i) <= '9' &&
                    str.charAt(i) >= '0')
                res += (str.charAt(i) - '0') * Math.pow(10, k++);
            else return 0;
        }
        if (isPositive)
            return (int) res;
        else return (int) -res;
    }

    @Test
    public void test() {


        System.out.println(StrToInt("-2147483648"));
    }

}
