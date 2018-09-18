package com.newcaoguo.main.myapplication;

public class ExcelSheetColumnTitle {

    /**
     * 将十进制转换为二十六进制
     *
     * @param n
     * @return
     * @author newcaoguo
     * @date - 2018-9-18
     */
    public static String convertToTitle(int n) {
        String res = "";
        while (n != 0) {
            res = (char) ((n - 1) % 26 + 'A') + res;
            n = (n - 1) / 26;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
