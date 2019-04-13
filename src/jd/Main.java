package jd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = 1;
            int i = 1;
            int price = 1;
            while (sum < n) {

                i++;
                sum += i;
            }
        }
    }
}
