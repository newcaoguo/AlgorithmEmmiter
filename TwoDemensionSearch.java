import org.junit.Test;

public class TwoDemensionSearch {
    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length * array[0].length; i++) {
            int row = getRow(Math.ceil(i / array[0].length));
            int column = i % array[0].length;
            if (array[row][column] == target) return true;
        }
        return false;
    }

    public int getRow(double data) {
        int tmp = (int) Math.round(data);
        if (tmp >= data) {
            return tmp;
        } else {
            return (int) Math.round(data + 0.5);
        }
    }


    @Test
    public void test() {
        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {4, 7, 10, 13},
        };
        System.out.println(Find(7, array));
    }
}