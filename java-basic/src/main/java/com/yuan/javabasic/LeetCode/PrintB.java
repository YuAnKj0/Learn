package com.yuan.javabasic.LeetCode;

/**
 * @author Ykj
 * @date 2022/10/12/15:00
 * @apiNote  位运算符   
 *    左移 <<  
 *    原码，补码，反码
 *    int类型的范围 -2^32~2^31-1
 *    取反的符号：~a:对a取反
 * 
 * 
 * 
 * 
 */
public class PrintB {
   
   
   public static void main(String[] args) {
      //int num=1;
      //print(num);
     /* int a=Integer.MAX_VALUE;
      print(a);
      System.out.println("");
      
      int b=1232314;
      int c=~b;
      int d=Integer.MIN_VALUE;
      print(b);
      System.out.println("");
      print(c);
      System.out.println("");
      print(d);*/
      
      /*int a=32;
      int b=4234;
      print(a);
      System.out.println("");
      print(b);
      System.out.println("");
      print(a | b);
      System.out.println("");
      print(a^b);
      System.out.println("");
      print(a&b);
      System.out.println("");
      int c=1024;
      print(a);
      System.out.println("");
      print(c>>1);
      System.out.println("");
      print(c>>>1);*/
      
      int a=5;
      int b=-a;
      b = (~a + 1);
      print(a);
      print(b);
      
      
      
      
      
   }
   
   private static void print(int num) {
      for (int i=31;i>=0;i--){
         System.out.print((num&(1<<i))==0?"0":"1");
        
      }
      System.out.println("");
   }
}
