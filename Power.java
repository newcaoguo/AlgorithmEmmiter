import org.junit.Test;

public class Power {
    //给定一个double类型的浮点数base和int类型的整数exponent。
    //求base的exponent次方。
    /*public double Power(double base, int exponent) {

        return  Math.pow(base, exponent);
    }*/

    public double Power(double base, int exponent) {
        double res = 1;
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        for (int i = 0; i < exponent; i++) {
            res = res * base;
        }
        if (isNegative) return 1 / res;
        return res;
    }

    @Test
    public void test() {
        System.out.println(Power(2, -3));
    }
}
