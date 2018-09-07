package iflytek;

import java.util.Scanner;

public class iflytek_test_002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            getResult(m, n);
        }

        sc.close();
    }

    public static void getResult(int m, int n) {
        boolean flag = true;
        for (int i = m; i <= n; i++) {
            if (isPerfectNumber(i)) {
                flag = false;
                System.out.print(i + " ");
            }
        }

        if (flag) {
            System.out.println("no");
        } else {
            System.out.println();
        }
    }

    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        int temp = n;
        while (temp != 0) {
            int num = temp % 10;
            sum += num * num * num;
            temp = temp / 10;
        }

        return sum == n;
    }
}
