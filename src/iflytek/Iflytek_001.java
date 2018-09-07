package iflytek;

import java.util.Arrays;
import java.util.Scanner;

public class Iflytek_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; i++) {
                int n = sc.nextInt();
                int x = sc.nextInt();
                int a[] = new int[n];
                for (int j = 0; j < n; j++) {
                    a[j] = sc.nextInt();
                }
                System.out.println(Arrays.toString(a));
                getResult(a, x);
            }
        }

        sc.close();
    }

    public static void getResult(int a[], int x) {
        int n = a.length;
        int total = n * x;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        total = total - sum;

        Arrays.sort(a);
        int c = 0;
        for (int i = 0; i < n && total > 0; i++) {
            total -= 100 - a[i];
            c++;
        }

        System.out.println(c);
    }
}
