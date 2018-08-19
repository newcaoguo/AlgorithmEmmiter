import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {

        if (rowIndex < 0) return null;
        List<List<Integer>> mList = new ArrayList<>();
        if (rowIndex >= 0) {
            List<Integer> dataList = new ArrayList<>();
            dataList.add(1);
            mList.add(dataList);
        }

        if (rowIndex >= 1) {
            List<Integer> dataList = new ArrayList<>();
            dataList.add(1);
            dataList.add(1);
            mList.add(dataList);
        }

        if (rowIndex >= 2) {

            for (int i = 2; i <= rowIndex + 1; i++) {
                List<Integer> dataList = new ArrayList<>();
                List<Integer> preList = mList.get(i - 1);
                dataList.add(1);
                for (int j = 1; j < i; j++) {
                    dataList.add(preList.get(j - 1) + preList.get(j - 0));
                }
                dataList.add(1);
                mList.add(dataList);
            }
        }
        return mList.get(rowIndex );
    }

    public static void main(String[] args) {
        List<Integer> list = getRow(3);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
