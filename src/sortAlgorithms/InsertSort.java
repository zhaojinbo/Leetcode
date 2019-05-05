package sortAlgorithms;

class InsertSort {
    /**
     * 插入排序
     * 当前索引左侧的元素都是有序的，需要找到合适的位置将当前索引下的元素插入进去
     * 为了腾出空间，前面的元素可能需要向右移动
     * @param a
     */
    static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j + 1] < a[j]) {
                    SortUtils.exchange(a,j+1,j);
                } else {
                    break;
                }
            }
        }
    }
}
