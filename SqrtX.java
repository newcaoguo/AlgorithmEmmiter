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
    
    // 二分法
    public double sqrt(int n) {
        double max = n;
        double min = 0;
        double p = 1e-5; //此处为精度，当满足该精度时，返回该近似值
        double x = (max + min) / 2;
        while (Math.abs((x * x) - n) > p) {
            if (x * x < n) min = x;
            else if (x * x > n) max = x;
            x = (max + min) / 2;
        }
        return x;
    }
    // 牛顿迭代法
    public double sqrt(int n) {
        double x = 1.0;//设置初值
        double p = 1e-5;//设置精度
        while ((Math.abs(x * x - n)) > p) {
            x = (x + n / x) / 2.0;
        }
        return x;
    }

    public static void main(String[] args) {

    }
}

