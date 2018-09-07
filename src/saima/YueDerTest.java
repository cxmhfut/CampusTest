package saima;

import java.util.Scanner;

public class YueDerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String source = sc.nextLine();
            String target = sc.nextLine();
            yuederTest(source, target);
        }

        sc.close();
    }

    public static void yuederTest(String source, String target) {
        char ch[] = source.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if (isLetterOrDigit(c)) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        int yes = 0;

        char chSource[] = sb.toString().toCharArray();
        char chTarget[] = target.toCharArray();
        int len = chSource.length > chTarget.length ? chTarget.length : chSource.length;
        int i = 0;
        while (i < len) {
            if (chSource[i] == chTarget[i])
                yes++;
            i++;
        }

        System.out.printf("%.2f%%",(float) yes * 100 / (float)chSource.length);
    }

    public static boolean isLetterOrDigit(char c) {
        if ((c >= '0' && c <= '9') ||
                (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z')) {
            return true;
        }

        return false;
    }
}
