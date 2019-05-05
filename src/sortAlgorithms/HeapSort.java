package sortAlgorithms;

class HeapSort {
    /**
     * 堆排序
     * 分为三步，第一步创建大顶堆
     * 第二步将堆的顶部元素与最后一个元素交换位置，然后将堆元素个数减一
     * 然后通过下沉来调整，使堆有序化
     * 重复第二步和第三步，直到堆中元素只剩一个
     *
     * @param a
     */
    static void sort(int[] a) {
        int n = a.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(a, i, n);
        }
        while (n > 1) {
            exchange(a, 1, n--);
            sink(a, 1, n);
        }

    }

    /**
     * 下沉方法
     *
     * @param a
     * @param k 待下沉的节点
     * @param N 总节点个数
     */
    private static void sink(int[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j + 1 <= N) {//这里的判断是因为元素个数可能是偶数个，不能形成完全二叉树
                if (less(a, j, j + 1))
                    j++;
            }
            if (less(a, j, k))
                break;
            exchange(a, j, k);
            k = j;
        }
    }

    /**
     * 比较大小，需要将下标统一减去1
     * 因为默认情况下，上面的方法认为数据存在数组的[1,n]范围内
     * 而实际上是[0,n-1]范围
     * @param a
     * @param i
     * @param j
     * @return
     */
    private static boolean less(int[] a, int i, int j) {
        return a[i - 1] < a[j - 1];
    }

    /**
     * 交换方法，同样需要下标减去1
     * @param a
     * @param i
     * @param j
     */
    private static void exchange(int[] a, int i, int j) {
        int temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }
}
