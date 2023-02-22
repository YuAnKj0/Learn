package com.yuan.javabasic.juc;

/**
 * @author Ykj
 * @date 2023/1/31/9:05
 * @apiNote
 */
public class WaitNotifyExample {
   public synchronized void before(){
      System.out.println("before");
      notifyAll();
   }
   public synchronized void after() {
      try {
         wait();
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
      System.out.println("after");
   }
}
