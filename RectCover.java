import org.junit.Test;

public class RectCover {
    /**
     * 我们可以用 2 * 1 的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用 n 个 2 * 1 的小矩形无重叠地覆盖一个 2 * n 的大矩形，
     * 总共有多少种方法？
     */
    /**
     * n = 1 - 只有横放一个矩形一种解决办法
     * n = 2 - 有横放一个矩形，竖放两个矩形两种解决办法
     * n = 3 - n = 2 的基础上加1个横向，n=1的基础上加2个竖向
     * n = 4 - n = 3 的基础上加1个横向，n=2的基础上加2个竖向
     * ...
     * n = n - n = f(n-1) + f(n-2)
     */
    //运行时间：533ms
    //占用内存：9388k
    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        return RectCover(target - 1) + RectCover(target - 2);
    }
    //运行时间：19ms
    //占用内存：9488k
    /*public int RectCover(int target) {
        int res = 0;
        int f1 = 1;
        int f2 = 2;
        if (target == 1) res = f1;
        if (target == 2) res = f2;
        while (target > 2) {
            target--;
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }*/

    @Test
    public void test() {
        System.out.println(RectCover(100));
    }
}
