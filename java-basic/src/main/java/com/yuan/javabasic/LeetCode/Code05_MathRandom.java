package com.yuan.javabasic.LeetCode;

/**
 * @author Ykj
 * @date 2022/10/13/17:06
 * @apiNote
 */
public class Code05_MathRandom {
   // 此函数只能用，不能修改
   // 等概率返回1~5
   //等概率返回5
   public static int f5(){
      return (int) (Math.random()*5+1);
   }
   //等概率得到0和1
   public static int a(){
      int ans=0;
      do {
         ans=f5();
      }while (ans==3);
      return ans<3?0:1;
   }
   //等概率返回0到6
   public static int b(){
      int ans=0;
      do {
         ans=(a()<<2)+(a()<<1)+a();
      }while (ans==7);
      return ans;
   }
   //等概率返回 equal probability return 0~7
   public static int c(){
      return b()+1;
   }
   
   // 这个结构是唯一的随机机制
   // 你只能初始化并使用，不可修改
   public static class RandomBox{
      private final int min;
      private final int max;
      
      public RandomBox(int mi,int ma){
         min=mi;
         max=ma;
      }
      public int random(){
         return (int) (min+Math.random()*(max-min+1));
      }
      public int min(){
         return min;
      }
      public int max(){
         return max;
      }
   }
   //利用条件RandomBox，如何等概率返回0和1
   //Using conditional RandomBox,how to return 0 and 1 with equal probability
   public static int rand01(RandomBox randomBox){
      int min=randomBox.min;
      int max=randomBox.max;
      int size=max-min+1;
      //size 是不是奇数，odd 奇数 Is size odd
      boolean odd=(size&1)!=0;
      int mid=size/2;
      int ans=0;
      do {
         ans=randomBox.random()-min;
      }while (odd&&ans==mid);
      return ans<mid?0:1;
      
   }
   //给你一个RandomBox，这是唯一能借助的随机机制   //Gives you a RandomBox,which is the only randon mechanism you can resort to
   //等概率返回from~to范围上任何一个数  //returns any number in the range from-to with equal probality
   //要求from<=to require from<=to
   public static int random(RandomBox randomBox,int from ,int to){
      if (from==to){
         return from;
      }   
      //3~6  
      int range=to-from;
      int num=1;
      //求0~range需要几个二进制位
      while ((1<<num)-1<range){
         num++;
         
   
      }   
   return num;}   
   
   
   
   
   
   public static void main(String[] args) {
      System.out.println("测试开始");
      int testTimes=10000000;
      int count=0;
      for (int i = 0; i < testTimes; i++) {
         if (Math.random()<0.75) {
            count++;
         }
      }
      System.out.println((double) count/(double) testTimes);
      System.out.println("==============");
      //System.out.println(rand01(new RandomBox(1,7)));
      System.out.println();
   }
}
