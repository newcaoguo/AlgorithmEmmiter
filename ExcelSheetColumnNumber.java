import org.junit.Test;

public class ExcelSheetColumnNumber {

    /**
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     */
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = (int) (Math.pow(26, s.length() - i - 1) * (s.charAt(i) - 'A' + 1)
                    + res);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(titleToNumber("AA"));
    }
}
