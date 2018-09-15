package baidu;

import java.util.*;

public class Baidu_001 {
    public static void main(String[] args) {
        int busCount = 4;
        int busStops[][] = new int[][]{
                {2,5},
                {30,35},
                {17,26},
                {37,40}
        };

        distanceCovered(busCount,busStops);
    }

    public static void distanceCovered(int busCount, int busStops[][]) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < busCount; i++) {
            for (int j = busStops[i][0]; j < busStops[i][1]; j++) {
                set.add("" + j + (j + 1));
            }
        }

        System.out.println(set.size());
    }
}
