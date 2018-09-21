package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 大数相乘
 */
public class Huawei_004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            System.out.println(multiply(a, b));
        }

        sc.close();
    }

    public static String multiply(String a, String b) {
        String tempA = a.length() > b.length() ? a : b;
        String tempB = a.length() > b.length() ? b : a;
        if (tempB.equals("0")) return "0";
        char chA[] = new StringBuilder(tempA).reverse().toString().toCharArray();
        char chB[] = new StringBuilder(tempB).reverse().toString().toCharArray();

        List<String> results = new ArrayList<>();

        int carry = 0;
        int i = 0;
        int maxLen = 0;
        while (i < chB.length) {
            int x = chB[i] - '0';
            if (x != 0) {
                int j = i;
                StringBuilder res = new StringBuilder();
                while (j > 0) {
                    res.append(0);
                    j--;
                }
                for (char c : chA) {
                    int y = c - '0';
                    int z = x * y + carry;
                    carry = z / 10;
                    res.append(z % 10);
                }
                if (carry != 0) {
                    res.append(carry);
                }
                carry = 0;
                if (res.length() > maxLen) maxLen = res.length();
                results.add(res.toString());
            }
            i++;
        }

        return add(results, maxLen);
    }

    public static String add(String a, String b) {
        char chA[] = new StringBuilder(a).reverse().toString().toCharArray();
        char chB[] = new StringBuilder(b).reverse().toString().toCharArray();

        int len = chA.length > chB.length ? chA.length : chB.length;

        StringBuilder res = new StringBuilder();

        int carry = 0;
        int i = 0;
        while (i < len) {
            int x = i < chA.length ? chA[i] - '0' : 0;
            int y = i < chB.length ? chB[i] - '0' : 0;
            int z = x + y + carry;
            carry = z / 10;
            res.append(z % 10);
            i++;
        }

        if (carry != 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    public static String add(List<String> nums, int len) {
        int i = 0;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i < len) {
            int sum = 0;
            for (String num : nums) {
                int cur = i < num.length() ? num.charAt(i) - '0' : 0;
                sum += cur;
            }
            sum += carry;
            carry = sum / 10;
            res.append(sum % 10);
            i++;
        }

        if (carry != 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }
}
