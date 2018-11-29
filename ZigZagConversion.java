package com.company;

public class ZigZagConversion {
    /**
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * @return
     */
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
