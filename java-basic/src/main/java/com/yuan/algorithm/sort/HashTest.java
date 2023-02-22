package com.yuan.algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ykj
 * @date 2023/1/11/21:42
 * @apiNote
 */
public class HashTest {
   
   private static final List<String> servers= Arrays.asList("192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4");
   
   public static String getServer(String key) {
      int hashCode = key.hashCode();
      int size = hashCode % servers.size();
      return servers.get(size);
   }
   
   public static void main(String[] args) {
      for (int i = 0; i < 10; i++) {
         String server = getServer(String.valueOf(i));
         System.out.println("select server: "+server);
      }
   }
}
