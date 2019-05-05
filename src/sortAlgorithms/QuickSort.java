package sortAlgorithms;

class QuickSort {
    /**
     * 快速排序，采用递归调用方式
     * 首先对整个数组进行分割，然后对左侧和右侧子序列进行分别排序
     * 递归的终止条件是，子序列只有一个元素或者零个元素
     *
     * @param a
     */
    static void quickSort(int[] a) {
        int n = a.length;
        sort(a, 0, n - 1);

    }

    private static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int k = partition(a, low, high);
        sort(a, low, k - 1);
        sort(a, k + 1, high);

    }

    /**
     * 切分函数，主要用来将子序列的第一个元素的位置确定下来
     * 位置确定后的序列，左侧元素都不大于它，右侧元素都不小于它
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] a, int low, int high) {
        int lo = low + 1;
        int hi = high;
        while (true) {
            while (a[lo] <= a[low] && lo <= hi) {
                lo++;
            }
            while (a[hi] >= a[low] && lo <= hi) {
                hi--;
            }
            if (lo >= hi) {
                break;
            }
            SortUtils.exchange(a,lo,hi);
        }
        SortUtils.exchange(a,hi,low);
        return hi;
    }
}
