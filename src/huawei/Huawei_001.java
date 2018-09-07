package huawei;

import java.util.Scanner;

public class Huawei_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            add(a, b);
        }

        sc.close();
    }

    public static void add(String a, String b) {
        char chA[] = (new StringBuilder(a)).reverse().toString().toCharArray();
        char chB[] = (new StringBuilder(b)).reverse().toString().toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int carry = 0;
        int len = a.length() > b.length() ? a.length() : b.length();

        while (i < len) {
            int x = i < chA.length ? chA[i] - 'a' : 0;
            int y = i < chB.length ? chB[i] - 'a' : 0;

            int z = x + y + carry;
            carry = z / 26;
            sb.append((char) (z % 26 + 'a'));
            i++;
        }

        if (carry == 1) {
            sb.append('b');
        }

        System.out.println(sb.reverse().toString());
    }
}
