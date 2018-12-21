import java.util.Arrays;

public class HeapSortExample {

    public void swap(int[] array, int i, int j) {
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }

    public void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest])
            largest = left;
        if (right < n && array[right] > array[largest])
            largest = right;

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }


    public void heapSort(int[] array, int n) {
        //1.构建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    @Test
    public void test() {
        int[] array = new int[]{5, 3, 8, 9};
        heapSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
  
}
