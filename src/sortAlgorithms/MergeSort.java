package sortAlgorithms;

class MergeSort {
    // 辅助数组
    private static int[] aid;

    /**
     * 归并排序，自顶向下的递归排序方法
     *
     * @param a
     */
    static void sortFromTop(int[] a) {
        int n = a.length;
        aid = new int[n];
        sort(a, 0, n - 1);
    }

    /**
     * 递归调用，进行排序
     * 先将数组分为两半，分别对前半段和后半段排序，之后进行合并
     *
     * @param a
     * @param low
     * @param high
     */
    private static void sort(int[] a, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    /**
     * 归并排序，自底向上的排序方法
     * 先将小的子序列合并，再将大的子序列合并
     *
     * @param a
     */
    static void sortFromBottom(int[] a) {
        int n = a.length;
        aid = new int[n];
        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i < n; i += 2 * sz) {
                merge(a, i, Math.min(i + sz - 1, n - 1), Math.min(i + 2 * sz - 1, n - 1));
            }
        }
    }

    /**
     * 合并算法，将传过来的数组中low到high范围内的两个有序子序列进行合并
     * 两个有序子序列的范围分别是[low,mid] [mid+1,high]
     *
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(int[] a, int low, int mid, int high) {
        int first = low;
        int second = mid + 1;
        for (int i = low; i <= high; i++) {
            aid[i] = a[i];
        }
        for (int i = low; i <= high; i++) {
            if (first > mid) {
                a[i] = aid[second++];
            } else if (second > high) {
                a[i] = aid[first++];
            } else if (aid[first] <= aid[second]) {
                a[i] = aid[first++];
            } else {
                a[i] = aid[second++];
            }
        }
    }
}
