package nubia;

import java.util.Scanner;

public class Nubia_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input[] = sc.nextLine().split(",");
            int h = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            System.out.println(getResult(h, m));
        }

        sc.close();
    }

    public static double getResult(int h, int m) {
        if (m == 0) {
            return 0;
        }
        if (m == 1) {
            return h;
        }

        return h + 2 * h - h / (Math.pow(2, m - 2));
    }
}
