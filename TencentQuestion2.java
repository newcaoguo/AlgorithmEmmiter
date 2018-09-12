import java.util.Random;

/**
 * 对于一个只有0和1的二维矩阵，
 * 上下或者左右相邻元素都为1则为一块，
 * 求一共有多少取值为1的连续块。
 */
public class TencentQuestion2 {

    // 共享成员变量,矩阵
    static int[][] rect = null;

    // 生成指定的随机矩阵,计算块数
    private static void createRect() {
        // 设定矩阵的高和宽
        int h = 4;
        int w = 4;
        // 生成指定随机矩阵int[i][j],并展示在控制台;将元素值为1的元素存入List,并展示在控制台
        Random rdm = new Random();
        rect = new int[h][w];
        System.out.println("随机生成矩阵如下图: ");
        for (int i = 0; i < rect.length; i++) {
            for (int j = 0; j < rect[i].length; j++) {
                int k = rdm.nextInt(2);
                rect[i][j] = k;
                System.out.print(" " + rect[i][j]);
            }
            System.out.println();
        }
        System.out.println("开始进行计算");
        // 开始计时
        long time = System.currentTimeMillis();
        // 计数
        int count = 0;
        // 遍历矩阵找1,块的定位
        for (int i = 0; i < rect.length; i++) {
            for (int j = 0; j < rect[i].length; j++) {
                // 当找到1时,开始处理其所在的块
                if (rect[i][j] == 1) {
                    block(i, j);
                    count++;
                }
            }
        }
        // 输出块数
        // System.out.println("计算结束");
        System.out.println("该矩阵中, 共有 " + count + " 块");
        // 输出计时结果
        System.out.println("计算用时 (ms) :" + (System.currentTimeMillis() - time));
    }

    // 判断连续块,递归
    private static void block(int i, int j) {
        // 修改(i,j)坐标对应的数组元素的值(避免递归时反复判断相邻元素)
        rect[i][j] = 4;
        // 分别判断上下左右
        if (i < rect.length - 1 && rect[i + 1][j] == 1) {
            block(i + 1, j);
        }
        if (i > 0 && rect[i - 1][j] == 1) {
            block(i - 1, j);
        }
        if (j < rect[i].length - 1 && rect[i][j + 1] == 1) {
            block(i, j + 1);
        }
        if (j > 0 && rect[i][j - 1] == 1) {
            block(i, j - 1);
        }
    }

    public static void main(String[] args) {
        createRect();
    }
}
