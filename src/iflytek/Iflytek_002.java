package iflytek;

import java.util.Scanner;

public class Iflytek_002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int queue[] = new int[n];
            for (int i = 0; i < n; i++) {
                queue[i] = sc.nextInt();
            }
            pinganDays(queue);
        }

        sc.close();
    }

    public static void pinganDays(int queue[]) {
        int len = queue.length;
        int a[] = new int[len];
        boolean isChanged = true;
        int day = 0;
        while (isChanged) {
            isChanged = false;
            int start = 0;
            int next = getNext(a, start);
            while (start < len && next < len) {
                if (queue[start] > queue[next]) {
                    a[next] = 1;
                    isChanged = true;
                }
                start = next;
                next = getNext(a, start);
            }

            if (isChanged) day++;
        }

        System.out.println(day);
    }

    public static int getNext(int a[], int start) {
        for (int i = start + 1; i < a.length; i++) {
            if (a[i] == 0) {
                return i;
            }
        }
        return a.length;
    }
}
