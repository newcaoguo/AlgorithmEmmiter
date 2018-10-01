import org.junit.Test;

public class JumpFloorII {
    //运行时间：21ms
    //占用内存：9412k
    // J(n) = J(n-1) + J(n-2) + ... + J(2) + J(1)
    /*public int JumpFloorII(int target) {
        int res = 0;
        if (target == 0 || target == 1) return 1;
        if (target == 2) return 2;
        for (int i = 0; i < target; i++) {
            res += JumpFloorII(i);
        }
        return res;
    }*/
    //运行时间：19 ms
    //占用内存：9468k
    public int JumpFloorII(int target) {
        if (target == 1 || target == 0) return 1;
        return 1 << (target - 1);
    }

    @Test
    public void test() {
        /**
         * 1
         * 2
         * 4
         * 8
         * 16
         * 32
         * 64
         * 128
         * 256
         */
        for (int i = 0; i <= 10; i++) {
            System.out.println(JumpFloorII(i));
        }
    }
}
