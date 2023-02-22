package com.yuan.javabasic.LeetCode;

/**
 * @author Ykj
 * @date 2022/10/12/15:58
 * @apiNote 选择排序，可以排出最小值
 */
public class Code02_SelectSort {
    
    public static void selectSort(int[] arr){
        if (arr!=null&&arr.length>2){
            //0~n-1,1~n-1,2~n-1;
            int N=arr.length;
            for (int i = 0; i <N; i++) {
                int minValueIndex=i;
                for (int j = i+1; j < N; j++) {
                    //如果j位置的值比minValueIndex位置的值还要小，那么就把j赋给minValueIndex,否则不变，这样就能得到最小值的位置
                    minValueIndex=arr[j]<arr[minValueIndex]?j:minValueIndex;
                }
                swap(arr,i,minValueIndex);
            }
            
        }
        printArray(arr);
        
    }
    
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
    
    
    public static void main(String[] args) {
        int[] arr={2,4,335,6,78,9,45,987,65};    
        printArray(arr);
        selectSort(arr);
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+"  ");
        }
        System.out.println();
    }
    
    
}
