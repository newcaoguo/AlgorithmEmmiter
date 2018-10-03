import org.junit.Test;

public class NumberOf1 {
    // x&(x-1)可以将整数最右边的1变成0，
    // 通过这个小技巧，
    // 我们只要循环判断n=n&(n-1)是否为0，
    // 即可统计1的个数。
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(NumberOf1(-2147483648));
    }
}
