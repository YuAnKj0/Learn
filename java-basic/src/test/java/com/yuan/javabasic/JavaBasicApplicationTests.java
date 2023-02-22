package com.yuan.javabasic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaBasicApplicationTests {
    
    @Test
    void contextLoads() {
        int[] arr=new int[]{23,24,54,-324,2,3,3,98,1};
        //testBubbleSort(arr);
        //testSelectSort(arr);
        testInsertSort(arr);
        for (int i : arr) {
            System.out.print(i+"   ");
        }
    }
    
    /**
     * 冒泡排序
     * @param arr
     */
    void testBubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {//冒泡次数
            boolean flag=true;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[i]){
                    flag=false;
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if (flag){
                break;
            }
            
        }
    }
    
    /**
     * 选择排序
     * @param arr
     */
    void testSelectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {  //i=选择排序次数
            int min=arr[i];
            int minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                if (min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if (i!=minIndex){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
    
    /**
     * 插入排序
     * @param arr
     */
    void testInsertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) { //i=插入排序次数,但是是从第二个元素前开始插入
            int insertIndex=i-1;
            int insertValue=arr[i];
            while (insertIndex>=0 && insertValue<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
        arr[insertIndex+1]=insertValue;
        }
    } 
    
    
}
