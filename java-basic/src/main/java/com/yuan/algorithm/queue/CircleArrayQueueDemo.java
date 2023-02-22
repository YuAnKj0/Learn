package com.yuan.algorithm.queue;

import java.util.Scanner;

/**
 * @author Ykj
 * @date 2023/2/22/18:57
 * @apiNote
 */
public class CircleArrayQueueDemo {
   public static void main(String[] args) {
      
      //创建一个环形队列
      CircleArrayQueue queue=new CircleArrayQueue(4);//设置4，但是队列有效数据的最大是3
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
class CircleArrayQueue{
   private int maxSize;
   private int front; //front作为队列的第一个元素，也就是说arr[front]为第一个元素，front的值为0
   private int rear;  //rear作为队列的最后一个元素的后一个位置，rear初始值为0
   private int[] arr; //该数组用于存放数据，模拟队列
   //创建队列的构造器
   public CircleArrayQueue(int maxSize){
      maxSize=maxSize;
      arr=new int[maxSize];
   }
   //判断队列是否满
   public boolean isFull(){
      return (rear+1)%maxSize==front;
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
      //将数据加入
      arr[rear]=value;
      rear=(rear+1)%maxSize;//让rear后移
     
   }
   
   /**
    * 获取队列的数据，出队列
    * @return
    */
   public int getQueue() {
      //判断是否为空
      if (isEmpty()) {
         throw new RuntimeException("队列为空，不能取数据");
      }
      /**
       * 这里需要分析出front是否指向第一个元素
       * 1.先把front对应的值保留到一个临时变量，
       * 2.将front后移，需要考虑取模
       * 3.将临时保存的变量返回
       */
      int val=arr[front];
      front=(front+1)%maxSize;
      return val;
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
      for (int i=front; i<front+size();i++){
         System.out.printf("arr[%d]=%d\n",i,i%maxSize,arr[i%maxSize]);
      }
   }
   
   /**
    * 求出当前队列有效数据的个数
    * @return
    */
   private int size() {
      return (rear+maxSize-front)%maxSize;
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
