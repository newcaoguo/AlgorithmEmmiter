import org.junit.Test;

public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // 取出 n 的最低位
            int least = n & 0x01;
            // n右移一位
            n = n >> 1;
            // 下面两个步骤需要注意：一定要先左移，再赋值。
            // 否则当n=2147483648时，result = result | least 会溢出。
            // 将result左移一位
            result = result << 1;
            // 将n的最低位加到result最后一位
            result = result | least;
        }
        return result;

    }


    @Test
    public void test() {
        System.out.println(reverseBits(43261596));
    }
}
