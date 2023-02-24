package com.yuan.algorithm.linkedlist;

/**
 * @author Ykj
 * @date 2023/2/23/14:51
 * @apiNote
 */
public class Josepfu {
   public static void main(String[] args) {
      CircleSingleLinkedList list=new CircleSingleLinkedList();
      list.addBoy(125);
      list.show();
      
      //测试
      list.currentBoy(10,20,125);
      
   }
}
//创建环形链表
class CircleSingleLinkedList{
   
   private  BoyNode first=null;
   public void addBoy(int nums){
      if (nums<1){
         System.out.println("数值不正确");
         return;
      }
      BoyNode cur=null;
      //使用for创建环形链表
      for(int i=1;i<=nums;i++){
         //根据编号，创建小孩节点
         BoyNode boy=new BoyNode(i);
         //第一个小孩
         if (i==1){
            first.setNext(first);//构成闭环
            cur=first;
         }else {
            cur.setNext(boy);
            boy.setNext(first);
            cur=boy;
            
         }
      }
      
   }
   //遍历当前链表
   public void show(){
      if (first.next == null){
         System.out.println("当前没有小孩");
         return;
      }
      //辅助变量
      BoyNode temp=first;
      while (true){
         System.out.printf("小孩的编号：%d",temp.getNo());
         if (temp.getNext()==first){
            break;
         }
         temp=temp.getNext();//后移
      }
      
   }
   
   /**
    * //小孩出圈的顺序
    * @param startNo 第startNo个小孩开始数
    * @param countNum 数countNum下
    * @param nums 最初有nums个小孩在圈中
    */
   public void currentBoy(int startNo,int countNum,int nums){
      //参数校验
      if (first==null||startNo<1||startNo>nums){
         System.out.println("参数校验未通过");
         return;
      }
      //辅助指针
      BoyNode helper=first;
      while (true){
         if (helper.getNext()==first){
            break;
         }
         helper=helper.getNext();
      }
      //小孩报数前，西安让first和helper移动k-1次
      while (true){
         if (helper==first){
            break;
         }
         //移动k-1
         for (int j=0;j<countNum-1;j++){
            first=first.getNext();
            helper=helper.getNext();
         }
         //这里first的点就是要出圈小孩的点
         System.out.printf("小孩%d要出圈",first.getNo());
         first=first.next;
         helper.next =first;
      }
      System.out.printf("最后留在圈中的小孩编号%d",first.getNo());
   }
   
}
class BoyNode{
   public int no;
   public String name;
   public BoyNode next;//指向下一个节点
   //构造器
   public BoyNode(int no){
      this.no=no;
   }
   
   @Override
   public String toString() {
      return "HeroNode{" +
              "no=" + no +
              ", name='" + name + '\'' +
              '}';
   }
   
   public int getNo() {
      return no;
   }
   
   public void setNo(int no) {
      this.no = no;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public BoyNode getNext() {
      return next;
   }
   
   public void setNext(BoyNode next) {
      this.next = next;
   }
}

