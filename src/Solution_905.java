import java.util.Arrays;

/**
 * 双指针法
 */
public class Solution_905 {
    public int[] sortArrayByParity(int[] A) {
        if (A.length < 2) {
            return A;
        }
        //定义两个指针
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < j && isEven(A[i])) {
                i++;
            }
            while (i < j && !isEven(A[j])) {
                j--;
            }
            if (i < j) {
                //交换
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }

    //判断是否为偶数
    private boolean isEven(int num) {
        return num % 2 == 0;
    }

/*    public static void main(String[] args) {
        int[] res = new Solution_905().sortArrayByParity(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(Arrays.toString(res));
    }*/
}
