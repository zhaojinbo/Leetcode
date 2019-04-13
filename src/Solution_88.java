public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int[] newArray = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (index2 < n) {
                if (nums1[index1] <= nums2[index2] && index1 < m) {
                    newArray[i] = nums1[index1];
                    index1++;
                } else {
                    newArray[i] = nums2[index2];
                    index2++;
                }
            }else{
                newArray[i] = nums1[index1];
                index1++;
            }
        }
        System.arraycopy(newArray, 0, nums1, 0, m + n);
    }
}
