public int[] topK(int[] mData, int k) {
        if (k > mData.length)
            throw new IllegalArgumentException("");
        int[] kData = new int[k];
        //1.初始化数据
        for (int i = 0; i < kData.length; i++) {
            kData[i] = Integer.MAX_VALUE;
        }
        //2.
        for (int i = 0; i < mData.length; i++) {
            if (mData[i] < kData[0]) {
                kData[0] = mData[i];
                adjustHeap(kData, 0, kData.length);
            }
        }
        return kData;
    }

    public static void heapSort(int[] arr) {
        //1.构建大顶堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.交换堆顶元素与末尾元素,并且重新调整堆结构,
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, i);//重新对堆进行调整
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将 temp 值放到最终的位置
    }

    /**
     * 交换元素
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Test
    public void test() {
        int[] data = new int[]{3, 5, 2, 1, 9};
        heapSort(data);
        System.out.println(Arrays.toString(data));
        int[] topK = topK(data, 5);
        System.out.println(Arrays.toString(topK));
    }
