import java.util.Scanner;

public class Toutiao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findMax(arr));

    }

    private static int findMax(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int k = 1;
            while (mid - k > 0 && arr[mid] == arr[mid - k]) {
                k++;
            }
            int x = 1;
            while (mid + x < arr.length-1 && arr[mid] == arr[mid + x]) {
                x++;
            }
            if (arr[mid] > arr[mid - k] && arr[mid] > arr[mid + x]) {
                return arr[mid];
            } else if (arr[mid] > arr[mid - k]) {
                low = mid + x;
            } else
                high = mid - k;
        }
        return arr[low];
    }

}
