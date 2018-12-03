package com.company;

public class IntegerToRoman {

    public String intToRoman(int num) {
        if (num <= 0) return "";
        String[] romans = {"M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}
