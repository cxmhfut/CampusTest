package didi;

import java.util.ArrayList;
import java.util.Scanner;

public class UglyNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(uglyNumber(n));
        }

        sc.close();
    }

    public static int uglyNumber(int n){
        if(n<7){
            return n;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int p1=0,p2=0,p3=0;
        int next = 1;
        arr.add(next);
        while (arr.size()<n){
            next = Math.min(arr.get(p1)*2,Math.min(arr.get(p2)*3,arr.get(p3)*5));
            if(next == arr.get(p1)*2){
                p1++;
            }
            if(next == arr.get(p2)*3){
                p2++;
            }
            if(next == arr.get(p3)*5){
                p3++;
            }
            arr.add(next);
        }
        return next;
    }
}
