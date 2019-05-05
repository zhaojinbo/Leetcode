package sortAlgorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {9,3,6,1,7,2,6,3,5,8,4,1,50,43,6,33,22,11,26,38,27,16,15,19,25,30};
//        InsertSort.sort(a);
//        SelectSort.sort(a);
//        ShellSort.sort(a);
        MergeSort.sortFromTop(a);
//        MergeSort.sortFromBottom(a);
//        QuickSort.quickSort(a);
//        HeapSort.sort(a);
//        BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
