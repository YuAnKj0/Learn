package com.yuan.javabasic.LeetCode;

/**
 * @author Ykj
 * @date 2022/10/12/17:04
 * @apiNote 插入排序
 */
public class Code04_InsertSort {
   /**
    * 交换i 和j的值位置
    * @param arr
    * @param i
    * @param j
    */
   private static void swap(int[] arr,int i,int j) {
      int temp=arr[j];
      arr[j]=arr[i];
      arr[i]=temp;
   }
   
   public static void insertSort01(int[] arr){
      if (arr==null||arr.length<2){
         return;
      }
      //0~1 0~2 0~3 0~n-1
      int N=arr.length;
      for (int end = 1; end < N; end++) {
         int newNumIndex = end;
         while (end - 1 >= 0 && arr[end - 1] > arr[end]){
            swap(arr, end - 1, end);
         }
         newNumIndex--;
      
      }
      printArray(arr);
   }
   public static void insertSort02(int[] arr){
      if (arr==null||arr.length<2){
         return;
      }
      //0~1 0~2 0~3 0~n-1
      int N=arr.length;
      for (int end = 1; end < N; end++) {
         //新书的前一个位置
         for (int pre=end-1;pre>=0&&arr[pre]>arr[pre+1];pre--){
            swap(arr,pre,pre+1);
         }
      }
      printArray(arr);
   }
   
   public static void main(String[] args) {
      int[] arr={2,4,335,6,78,9,45,987,65};
      printArray(arr);
      //selectSort(arr);
      insertSort01(arr);
   }
   
   /**
    * 打印数组
    * @param arr
    */
   public static void printArray(int[] arr){
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i]+"  ");
      }
      System.out.println();
   }
   
}
