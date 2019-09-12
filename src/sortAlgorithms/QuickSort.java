package sortAlgorithms;

class QuickSort {
    /**
     * 快速排序，采用递归调用方式
     * 首先对整个数组进行分割，然后对左侧和右侧子序列进行分别排序
     * 递归的终止条件是，子序列只有一个元素或者零个元素
     */
    static void quickSort(int[] a) {
        int n = a.length;
        sort(a, 0, n - 1);

    }

    private static void sort(int[] a, int from, int to) {
        if (from >= to) {
            return;
        }
        int k = partition(a, from, to);
        sort(a, from, k - 1);
        sort(a, k + 1, to);

    }

    /**
     * 切分函数，主要用来将子序列的第一个元素的位置确定下来
     * 位置确定后的序列，左侧元素都不大于它，右侧元素都不小于它
     */
    private static int partition(int[] a, int from, int to) {
        int i = from;
        int j = to + 1;
        while (true) {
            while (a[++i] < a[from]) {
                if (i == to) break;
            }
            while (a[--j] > a[from]) {
                if (j == from) break;
            }
            if (i >= j) {
                break;
            }
            SortUtils.exchange(a, i, j);
        }
        SortUtils.exchange(a, from, j);
        return j;
    }
}
