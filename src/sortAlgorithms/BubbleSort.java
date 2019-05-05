package sortAlgorithms;

class BubbleSort {
    /**
     * 冒泡排序，第一层循环表示比较的轮数（其实是未排序元素的最右端下标减一）
     * 每一轮都比较相邻两个元素，将大的移到后面，一轮下来最大值被移到了最右端
     * 下一轮将剩余元素中最大的已到剩余元素的最右端
     * @param a
     */
    static void sort(int[] a) {
        for (int i = a.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (a[j] > a[j + 1]) {
                    SortUtils.exchange(a, j, j + 1);
                }
            }
        }
    }
}
