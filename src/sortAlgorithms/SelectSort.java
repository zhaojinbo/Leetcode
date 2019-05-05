package sortAlgorithms;

class SelectSort {
    /**
     * 每次找出右侧没有排序部分中的最小值，并将该值与当前索引位置的值交换位置
     * 每次找寻最小值时首先以当前索引位置的值作为最小值
     * 当前索引左侧的部分已经有序
     *
     * @param a
     */
    static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            if (i != min_index)
                SortUtils.exchange(a, min_index, i);
        }
    }
}
