package nubia;

import java.util.Scanner;

public class Nubia_002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();
            sort(input);
        }

        sc.close();
    }

    public static void sort(String strs) {
        String numsStr[] = strs.split(",");
        int nums[] = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        boolean isChanged = true;
        for (int i = 0; i < nums.length - 1 && isChanged; i++) {
            isChanged = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    isChanged = true;
                }
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println(nums[nums.length - 1]);
    }
}
