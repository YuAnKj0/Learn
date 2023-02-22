package com.yuan.javabasic.juc;

import java.security.PublicKey;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ykj
 * @date 2023/1/31/9:12
 * @apiNote
 */
public class AwaitSignalExample {
   private  Lock lock=new ReentrantLock();
   private Condition condition=lock.newCondition();
   
   public void  before(){
      lock.lock();
      try {
         System.out.println("before");
         condition.signal();
      }finally {
         lock.unlock();
      }
      
   }
   public void after(){
      lock.lock();
      try {
         condition.await();
         System.out.println("after");
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }finally {
         lock.unlock();
      }
   
   }
}
