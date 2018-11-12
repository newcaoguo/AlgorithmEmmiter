package com.company;

import org.junit.Test;

public class IsNumeric {

    public boolean isNumeric(char[] data) {
        if (data == null || data.length == 1) return false;
        int index = 0;
        //是否有符号位存在，存在则跳过
        if (data[0] == '+' || data[0] == '-') {
            index++;
        }
        //解析A部分是否正确
        while (index < data.length) {
            //查看是否“.”,如果是直接跳出。
            if (data[index] == '.') {
                index++;
                break;
            }
            //查看是否“e|E”,如果是直接跳出，不移动下标在B部分进行处理。
            if (data[index] == 'e' || data[index] == 'E') break;
            if (data[index] >= '0' && data[index] <= '9') {
                index++;
                continue;
            }
            return false;
        }

        //解析B部分是否正确
        while (index < data.length) {
            //查看是否“e|E”,如果是直接跳出。
            if (data[index] == 'e' || data[index] == 'E') {
                index++;
                if (index >= data.length) return false;
                break;
            }
            if (data[index] >= '0' && data[index] <= '9') {
                index++;
                continue;
            }
            return false;
        }

        //查看c部分有没有正负号，如果有跳过
        if (index < data.length &&
                (data[index] == '+' || data[index] == '-')) {
            index++;
        }
        //解析C部分是否正确
        while (index < data.length) {
            if (data[index] >= '0' && data[index] <= '9') {
                index++;
                continue;
            }
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isNumeric("2e".toCharArray()));
    }

}
