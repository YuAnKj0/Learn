package com.yuan.javabasic.LeetCode;

/**
 * @author Ykj
 * @date 2022/10/12/15:58
 * @apiNote 冒泡排序
 */
public class Code03_BubbleSort {
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
    
    public static void bubbleSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        //0~n-1 0~n-2
        int N=arr.length;
        for (int end = N-1; end >=0; end--) {
            for (int second=1;second<=end;second++){
                if (arr[second-1]>arr[second]) {
                    swap(arr,second-1,second);
                }
                
            }
            
        }
        printArray(arr);
        
        
    }
    
    public static void main(String[] args) {
        int[] arr={2,4,335,6,78,9,45,987,65};    
        printArray(arr);
        //selectSort(arr);
        bubbleSort(arr);
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
