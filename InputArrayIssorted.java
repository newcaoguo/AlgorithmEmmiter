public class InputArrayIssorted {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};
            else if (numbers[i] + numbers[j] < target) i++;
            else if (numbers[i] + numbers[j] > target) j--;
        }
        return null;
    }

    public static void show() {
        int[] ints = twoSum(new int[]{1, 2, 3, 6}, 4);
        for(int a : ints){
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args) {
        show();
    }
}
