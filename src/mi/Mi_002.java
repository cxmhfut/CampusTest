package mi;

import java.util.Arrays;
import java.util.Scanner;

public class Mi_002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String data = sc.nextLine();
            solution(data);
        }

        sc.close();
    }

    public static void solution(String data) {
        String args[] = data.split(",");
        int weight = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        String weightsStr[] = args[2].split(" ");
        String valuesStr[] = args[3].split(" ");
        int weights[] = new int[n];
        int values[] = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(weightsStr[i]);
            values[i] = Integer.parseInt(valuesStr[i]);
        }
        solution(weight, n, weights, values);
    }

    public static void solution(int weight, int n, int weights[], int values[]) {
        int F[][] = new int[n + 1][weight + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= weight; w++) {
                if (w <= weights[i - 1]) {
                    F[i][w] = Math.max(F[i - 1][w], F[i][w - 1] + values[i - 1]);
                } else {
                    F[i][w] = F[i][w - 1];
                }
            }
        }

        System.out.println(Arrays.toString(F));
        System.out.println(F[n][weight]);
    }
}
