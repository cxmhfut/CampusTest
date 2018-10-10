package baidu;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
    }

    static int f[] = new int[40];

    public static int Fibonacci(int n) {
        if(n==0){
            return 0;
        }

        if(f[n] != 0){
            return f[n];
        }

        if(n==1 || n==2){
            f[1] = 1;
            f[2] = 1;
            return 1;
        }

        for(int i=3;i<=n;i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }
}
