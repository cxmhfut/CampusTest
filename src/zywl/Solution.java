package zywl;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            getResult(arr);
        }

        sc.close();
    }

    public static void getResult(int arr[]) {
        int oneMax = one(arr);
        int twoMax = two(arr);
        System.out.println(oneMax);
        System.out.println(twoMax);
    }

    public static int two(int arr[]) {
        int n = arr.length;
        int res = 0;
        for (int mid = 1; mid < n - 3; mid++) {
            int leftMax = jiaoyi(arr, 0, mid);
            int rightMax = jiaoyi(arr, mid + 1, n - 1);
            int curMax = leftMax + rightMax;
            if (curMax > res) {
                res = curMax;
            }
        }

        return res;
    }

    public static int one(int arr[]) {
        return jiaoyi(arr, 0, arr.length - 1);
    }

    public static int jiaoyi(int arr[], int start, int end) {
        int in, out;
        in = start;
        int res = 0;

        while (in < end) {
            out = in + 1;
            while (out <= end) {
                int curMax = arr[out] - arr[in];
                if (curMax > res) {
                    res = curMax;
                }
                out++;
            }
            in++;
        }

        return res;
    }
}
