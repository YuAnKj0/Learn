package com.yuan.algorithm.queue;


import java.util.Scanner;

/**
 * @author Ykj
 * @date 2023/2/22/16:50
 * @apiNote
 */
public class ArrayQueueDemo {
   public static void main(String[] args) {
      //创建一个队列
      ArrayQueue queue=new ArrayQueue(3);
      char key;//接受用户输入
      Scanner scanner=new Scanner(System.in);
      boolean loop=true;
      //输出一个菜单
      while (loop){
         System.out.println("s(show): 显示队列");
         System.out.println("e(exit): 退出程序");
         System.out.println("a(add)): 添加数据到队列");
         System.out.println("g(get): 从队列中取出数据");
         System.out.println("h(head): 查看队列头的数据");
         key=scanner.next().charAt(0);//接收一个字符
         switch (key){
            case 's':
               queue.showQueue();
               break;
               
            case 'a':
               System.out.println("输出一个数字");
               int value = scanner.nextInt();
               queue.addQueue(value);
               break;
            case 'g':
               try {
                  int res=queue.getQueue();
                  System.out.printf("取出的数据是%d\n",res);
               }catch (Exception e){
                  System.out.println(e.getMessage());
               }
               break;
            case 'h'://查看对列头的数据
               try {
                  int res=queue.headQueue();
                  System.out.printf("队列头的数据是%d\n",res);
               }catch (Exception e){
                  System.out.println(e.getMessage());
               }
            case 'e':
               scanner.close();
               loop=false;
               break;
            default:
               break;
         }
      }
      System.out.println("程序退出~~~");      
   }
}

//使用数组模拟队列
class ArrayQueue{
   private int maxSize;
   private int front;
   private int rear;
   private int[] arr; //该数组用于存放数据，模拟队列
   //创建队列的构造器
   public ArrayQueue(int maxSize){
      maxSize=maxSize;
      arr=new int[maxSize];
      front=-1;//指向队列头部，分析出front是指向队列头部的前一个位置
      rear=-1;//指向队列尾的数据
   }
   //判断队列是否满
   public boolean isFull(){
      return rear==maxSize-1;
   }
   //判断队列是否为空
   public boolean isEmpty(){
      return rear==front;
   }
   
   
   public void addQueue(int value) {
      //判断是否满
      if (isFull()) {
         System.out.println("队列满，不能添加数据");
         return;
      }
      rear++;//让rear后移
      arr[rear]=value;
   }
   
   /**
    * 获取队列的数据，出队列
    * @return
    */
   public int getQueue() {
      //判断是否为空
      if (isEmpty()) {
         System.out.println("队列为空，不能取数据");
      }
      front++;//front后移
      return arr[front];
   }
   
   /**
    * 显示队列所有数据
    */
   public void showQueue() {
      //遍历
      if (isEmpty()) {
         System.out.println("队列空，无数据");
         return;
      }
      for (int i=0; i<arr.length;i++){
         System.out.printf("arr[%d]=%d\n",i,arr[i]);
      }
   }
   
   /**
    * /显示队列头数据
    * @return
    */
   public int headQueue() {
      if (isEmpty()) {
         throw new RuntimeException("队列空");
      }
      return arr[front+1];
   }
   
   
}
