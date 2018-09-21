package iqiyi;

import java.util.*;

public class Iqiyi_002 {
    public int rand7() {
        return 0;
    }

    public int rand9() {
        int x = 46;
        while (x > 45) {
            x = rand7() + (rand7() - 1) * 7;
        }

        return 1 + x % 9;
    }
}