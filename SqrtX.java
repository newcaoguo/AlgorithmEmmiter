public class SqrtX {
    /**
     * 要找x的平方根，
     * x的平方根肯定小于x/2。
     * 要在[1,x/2]有序序列当中找一个数，
     * 用二分法.
     */
    public int mySqrt(int x) {
        long high = (x / 2) + 1;
        long low = 0;
        while (high >= low) {
            long mid = (high + low) / 2;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return (int) high;
    }

    public static void main(String[] args) {

    }
}

