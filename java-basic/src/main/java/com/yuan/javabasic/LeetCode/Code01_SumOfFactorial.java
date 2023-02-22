package com.yuan.javabasic.LeetCode;

/**
 * @author Ykj
 * @date 2022/10/12/15:50
 * @apiNote 给定一个参数N，返回N的阶乘：1!+2!+3!+...+N! 的结果
 */
public class Code01_SumOfFactorial {
    
    
    private static long f1(int N){
        int ans=0;
        int cur=1;
        for (int i = 1; i <= N; i++) {
            cur=cur*i;
            ans+=cur;
        }
        return ans;
        
    }
    
    public static void main(String[] args) {
        long result = f1(4);
        System.out.println(result);
    }
    
}
