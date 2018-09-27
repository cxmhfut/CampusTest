package mi;

import java.util.Scanner;

public class Mi_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(getResult(n));
        }

        sc.close();
    }

    public static int getResult(int n) {
        int res = 0;

        while (n != 0) {
            int i = 1;

            while (i * i * i <= n) {
                i++;
            }
            if (i != 1) i--;
            n -= i * i * i;
            res++;
        }

        return res;
    }
}
