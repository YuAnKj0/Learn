package com.yuan.algorithm.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Ykj
 * @date 2023/1/11/21:13
 * @apiNote
 */
public class RandomTest {
   private static final List<String> servers= Arrays.asList("192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4");
   
   public static void main(String[] args) {
      for (int i = 0; i < 10;i++) {
         String s =getRandom();
         System.out.println("selected server:"+s);
}
   }
   
   private static String getRandom() {
      Random random=new Random();
      int index = random.nextInt(servers.size());
      return servers.get(index);
      
   
   
   }
}
