package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Huawei_002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input1 = sc.nextLine();
            String input2 = sc.nextLine();
            System.out.println(isContain(input1, input2));
        }

        sc.close();
    }

    public static boolean isContain(String input1, String input2) {
        int a[] = new int[26];

        char ch[] = input2.toCharArray();
        for (char c : ch) {
            a[c - 'A'] = 1;
        }

        System.out.println(Arrays.toString(a));

        ch = input1.toCharArray();
        for (char c : ch) {
            if (a[c - 'A'] == 1) {
                a[c - 'A'] = 0;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
