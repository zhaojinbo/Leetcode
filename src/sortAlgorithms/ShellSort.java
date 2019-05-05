package sortAlgorithms;

class ShellSort {
    /**
     * 希尔排序，是插入排序的进化版
     * 在插入排序的最外面加上一层循环，用来控制每个子序列的间隔
     * 间隔从n/3开始缩小，知道缩小至1
     * 当gap等于1时，这次的排序就是插入排序
     * @param a
     */
    static void sort(int[] a) {
        int n = a.length;
        int gap = 1;
        while (gap < n / 3)
            gap = 3 * gap + 1;//1，4，13，40，121，364，，，
        while (gap >= 1) {
            for (int i = gap; i < n; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (a[j + gap] < a[j])
                        SortUtils.exchange(a, j + gap, j);
                    else
                        break;
                }
            }
            gap /= 3;
        }

    }
}
