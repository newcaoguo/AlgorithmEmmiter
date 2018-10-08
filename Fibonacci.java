import org.junit.Test;

public class Fibonacci {

    // 1. 递归做法耗时：705 ms
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        else if (n <= 2) return 1;
        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }
    // F0=0，F1=1，Fn=Fn-1+Fn-2（n>=2，n∈N*）
    // 2. 非递归做法，递推做法，耗时 20 ms
    public int Fibonacci(int n) {
        int fn = 0;
        int f0 = 0;
        int f1 = 1;
        if (n == 0) fn = f0;
        if (n == 1) fn = f1;
        while (n >= 2) {
            n--;
            fn = f0 + f1;//1
            f0 = f1;//1
            f1 = fn;//1
        }
        return fn;
    }
    // 3.记忆化搜索做法，耗时 16 ms
    // 运行时间：16ms
    //占用内存：9316k
    public int[] result = new int[40];
    public int Fibonacci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (result[n] > 0) return result[n];
        result[n] = Fibonacci(n - 1) + Fibonacci(n - 2);
        return result[n];
    }
    @Test
    public void test() {
        System.out.println(Fibonacci(5));
    }
}
