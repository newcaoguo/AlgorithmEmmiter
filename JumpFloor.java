import org.junit.Test;

public class JumpFloor {
    //运行时间：359ms
    //占用内存：9300k
    /*public int JumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }*/
    //运行时间：11ms
    //占用内存：9176k
    public int JumpFloor(int target) {
        int res = 0;
        int f0 = 1;
        int f1 = 2;
        if (target == 1) res = f0;
        if (target == 2) res = f1;
        while (target > 2) {
            target--;
            res = f0 + f1;
            f0 = f1;
            f1 = res;
        }
        return res;
    }


    /**
     * 1 : 1
     * 2 : 2
     * 3 : 3
     * 4 : 5
     * 5 : 8
     * 6 : 13
     * 7 : 21
     * 8 : 34
     * 9 : 55
     * 10 : 89
     */
    @Test
    public void test() {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + " : " + JumpFloor(i));
        }
    }
}
