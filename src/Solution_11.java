public class Solution_11 {
    /**
     * 时间复杂度：4 ms，95.43%
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int width = right - left;
            int hei = 0;
            if (height[left] < height[right]) {
                hei = height[left];
                left++;
            } else {
                hei = height[right];
                right--;
            }
            max = Math.max(max, hei * width);
        }
        return max;
    }

    /**
     * 时间复杂度O(N^2)
     */
    public int maxAreaOne(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int res;
                if ((res = caculateVolume(height, i, j)) > max) {
                    max = res;
                }
            }
        }
        return max;
    }

    private int caculateVolume(int[] height, int i, int j) {
        int hei = height[i] > height[j] ? height[j] : height[i];
        int width = j - i;
        return hei * width;
    }
}
