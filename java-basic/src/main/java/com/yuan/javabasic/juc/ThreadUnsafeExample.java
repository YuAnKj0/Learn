package com.yuan.javabasic.juc;

/**
 * @author Ykj
 * @date 2023/1/29/17:55
 * @apiNote
 */
public class ThreadUnsafeExample {
   
   private int cnt=0;
   public void add(){
      cnt++;
   }
   public int get(){
      return cnt;
   }
   
   
}
