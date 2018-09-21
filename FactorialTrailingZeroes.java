import org.junit.Test;

public class FactorialTrailingZeroes {

    /*public int trailingZeroes(int n) {
        long res = factorial(n);
        int zoreCount = 0;
        while (res != 0) {
            long reminder = res % 10;
            if (reminder == 0) zoreCount++;
            else break;
            res /= 10;
        }
        return zoreCount;
    }

    *//*public static long factorial(int n) {
        int res = 1;
        while (n != 0) {
            res = n * res;
            n--;
        }
        return res;
    }*//*

    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }*/

    public int trailingZeroes(int n) {
        int zero_num = 0;
        while (n != 0){
            n = n/5;
            zero_num += n;
        }
        return zero_num;
    }


    @Test
    public void test() {
        // 120 -> 24
        System.out.println(trailingZeroes(7));
    }


}
