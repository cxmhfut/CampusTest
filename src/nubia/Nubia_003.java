package nubia;

import java.util.Scanner;

public class Nubia_003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String arr[] = sc.nextLine().split(" ");
            String key = sc.nextLine();
            getResult(arr, key);
        }

        sc.close();
    }

    public static void getResult(String arr[], String key) {
        int count = 0;

        for (String s : arr) {
            if (s.contains(key)) {
                count++;
            }
        }

        System.out.println(count);
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[0]);
    }
}
