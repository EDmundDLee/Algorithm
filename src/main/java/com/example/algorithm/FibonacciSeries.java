package com.example.algorithm;

/**
 * @author lijiaxu
 * @Description 斐波那契数列问题
 * @date 2023/5/6 09:27
 */
public class FibonacciSeries {
    //该数列由0和1开始，后面的每一项数字都是前面两项数字的和

    /**
     * 暴力递归
     */
//    public static void main(String[] args) {
//        int fib = fib(10);
//        System.out.println(fib);
//    }

    public static int fib(int n) {
        if(n ==0 ||n==1 ) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

    // N =10 的话  fib(9)+fib（8） fib（9） = fib(8)+fib(7) fib（8）计算了两次

    /**
     * 带备忘录的递归
     *
     * 自顶向下解法
     */

//    public static void main(String[] args) {
//        int n = 30;
//
//        int [] memo =new int [n+1];
//
//        int helper = helper(memo, n);
//        System.out.println(helper);
//    }
    public static int helper(int[] memo,int n) {
        // base case
        if(n ==0|| n==1) {
            return n;
        }

        // 已经计算过了 不需要再计算了
        if(memo[n] !=0 ) {
            return memo[n];
        }

        memo[n] = helper(memo,n-1) + helper(memo,n-2) ;
        System.out.println(memo[n]);
        return memo[n];
    }

    /**
     * 自底向上的解法 带备忘录
     * db数组的迭代解法
     */

    public static void main(String[] args) {

//        System.out.println(bottomUp(20));
        System.out.println(bottomUpOptimize(21));
    }

    public static int bottomUp (int N) {
        //初始化数组
        int [] dp= new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for ( int i=2 ;i<=N ;i++) {
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[N];
    }

    /**
     * 优化空间复杂度、时间复杂度 （数组初始化为2）
     */

    public static int bottomUpOptimize (int N) {
        if(N ==0 || N ==1) {
            return N;
        }
        //初始化数组
       int prev =0;
        int curr = 1;
        for ( int i=2 ;i<=N ;i++) {
            int sum = prev +curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
