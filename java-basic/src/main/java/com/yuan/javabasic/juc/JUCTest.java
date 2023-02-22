package com.yuan.javabasic.juc;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ykj
 * @date 2023/1/29/17:54
 * @apiNote
 */
public class JUCTest {
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        AwaitSignalExample example=new AwaitSignalExample();
        // WaitNotifyExample example=new WaitNotifyExample();
        executor.execute(()->example.after());
        executor.execute(()->example.before());
    }
   
   
   
   
   
   /*public static class SynchronizedExample {
      public void func1() {
         synchronized (this) {
            for (int i = 0; i < 10; i++) {
               System.out.print(i + " ");
            }
         }
      }
   }
   
   public static void main(String[] args) {
      SynchronizedExample example = new SynchronizedExample();
      ExecutorService executorService=Executors.newCachedThreadPool();
      executorService.execute(()->example.func1());
      executorService.execute(()->example.func1());
      
   }*/
   
   
   /*public static void main(String[] args) {
      ExecutorService executorService=Executors.newCachedThreadPool();
      executorService.execute(()->{
         try {
            Thread.sleep(2000);
            System.out.println("Thread running");
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
      });
      executorService.shutdownNow();
      System.out.println("Main runing");
   }*/
   
   
   /*public static void main(String[] args) {
      ThreadLocal threadLocal=new ThreadLocal();
      Thread thread1 = new Thread(() -> {
      threadLocal.set(1);
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
         System.out.println(threadLocal.get());
         threadLocal.remove();
      });
      Thread thread2=new Thread(()->{
         threadLocal.set(2);
         threadLocal.remove();
      });
      thread1.start();
      thread2.start();
     
   }
   //输出结果 1*/
   
   
   /*private static Vector<Integer> vector=new Vector<>();
   public static void main(String[] args) {
      while (true){
         for (int i = 0; i < 100; i++) {
             vector.add(i);
         }
         ExecutorService executorService= Executors.newCachedThreadPool();
         executorService.execute(()->{
            synchronized (vector){
               for (int i = 0; i < vector.size(); i++) {
                  vector.remove(i);
               }
            }
         });
         executorService.execute(()->{
            synchronized (vector) {
               for (int i = 0; i < vector.size(); i++) {
                  vector.get(i);
               }
            }
         });
      executorService.shutdown();
      }  
   }*/
   
   /*public static void main(String[] args) throws InterruptedException {
      final int threadCount=1000;
      ThreadUnsafeExample example=new ThreadUnsafeExample();
      final CountDownLatch countDownLatch=new CountDownLatch(threadCount);
      ExecutorService executorService= Executors.newCachedThreadPool();
      for (int i = 0; i < threadCount; i++) {
          executorService.execute(()->{
             example.add();
             countDownLatch.countDown();
          });
          
      }
      countDownLatch.await();
      executorService.shutdown();
      System.out.println(example.get());
   }*/
}
