import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {

        if (numRows <= 0) return null;
        List<List<Integer>> mList = new ArrayList<>();
        if (numRows >= 1) {
            List<Integer> dataList = new ArrayList<>();
            dataList.add(1);
            mList.add(dataList);
        }

        if (numRows >= 2) {
            List<Integer> dataList = new ArrayList<>();
            dataList.add(1);
            dataList.add(1);
            mList.add(dataList);
        }

        if (numRows >= 3) {

            for (int i = 3; i <= numRows; i++) {
                List<Integer> dataList = new ArrayList<>();
                List<Integer> preList = mList.get(i - 2);
                dataList.add(1);
                for (int j = 2; j < i; j++) {
                    dataList.add(preList.get(j - 2) + preList.get(j - 1));
                }
                dataList.add(1);
                mList.add(dataList);
            }

        }

        return mList;
    }
}
