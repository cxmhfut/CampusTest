package iflytek;

import java.util.Scanner;

public class iflytek_test_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            getResult(n, m);
        }

        sc.close();
    }

    public static void getResult(int n, int m) {
        double sum = 0;
        double cur = n;

        for (int i = 0; i < m; i++) {
            sum += cur;
            cur = Math.sqrt(cur);
        }

        System.out.printf("%.2f", sum);
    }
}
