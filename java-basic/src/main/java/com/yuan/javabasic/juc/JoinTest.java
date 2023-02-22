package com.yuan.javabasic.juc;

/**
 * @author Ykj
 * @date 2022/12/1/10:28
 * @apiNote
 */
public class JoinTest {
   
   public static void main(String[] args) {
      
      final Thread t1=new Thread(new Runnable() {
         @Override
         public void run() {
            System.out.println("T1 is running");
      
         }
      });
      final Thread t2=new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               t1.join();
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
            System.out.println("T2 is running");
         
         }
      });
      final Thread t3=new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               t2.join();
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
            System.out.println("T3 is running");
         
         }
      });
      t3.start();//启动顺序任意
      t1.start();
      t2.start();
      t1.run();
      
      
   }
}
