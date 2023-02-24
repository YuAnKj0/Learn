package com.yuan.algorithm.linkedlist;

import javafx.util.Builder;

/**
 * @author Ykj
 * @date 2023/2/23/10:01
 * @apiNote
 */
public class DoubleLinkedListDemo {
   public static void main(String[] args) {
      //TODO 双向链表的测试
      
   }
   
}
class DoubleLinkedList{
   //初始化头结点
   private Node2 head=new Node2(0,"","");
   //返回头结点
   public Node2 getHead(){
    return head;  
   }
   //遍历双向链表的方法
   public void list(){
      if (head.next==null){
         return;
      }
      Node2 temp=head.next;
      while (true){
         if (temp.next==null){
            break;
         }
         System.out.println(temp);
         temp=temp.next;
      }
   }
   
   public void add(Node2 node){
      Node2 temp=head;
      while (true) {
          if (temp.next==null){
             break;
          }
          temp=temp.next;
      }
      //形成双向链表
      temp.next=node;
      node.pre=temp;
   }
   //修改节点
   public void update(Node2 node) {
      if (head.next == null) {
         System.out.println("链表为空");
         return;
      }
      //找到需要修改的节点
      Node2 temp = head.next;
      boolean flag = false;
      while (true) {
         if (temp == null) {
            break;
         }
         if (temp.no == node.no) {
            flag = true;
            break;
         }
         temp = temp.next;
      }
      //根据flag判断是否找到
      if (flag) {
         temp.name = node.name;
         temp.nickName = node.nickName;
      } else {
         System.out.printf("没有找到%d的节点\n", node.no);
      }
   }
   //删除节点
   public void del(int no){
      //判空
      if (head.next== null){
         return;
      }
      Node2 temp=head.next;
      boolean flag=false;
      while (true){
         if (temp==null){
            break;
         }
         if (temp.no==no){
            flag=true;
            break;
         }
         temp=temp.next;
      }
      //判断flag
      if (flag){
         temp.pre.next=temp.next;
         if (temp.next!=null){
            temp.next.pre=temp.pre;
   
         }else {
            System.out.printf("要删除的节点%d不存在",no);
         }
      }
      
   }
   
}
class Node2 {
   public int no;
   public String name;
   public String nickName;
   public Node2 pre;
   public Node2 next;//指向下一个节点
   
   //构造器
   public Node2(int no, String name, String nickName) {
      this.no = no;
      this.name = name;
      this.nickName = nickName;
   }
   
   @Override
   public String toString() {
      return "Node2{" +
              "no=" + no +
              ", name='" + name + '\'' +
              ", nickName='" + nickName + '\'' +
              '}';
   }
}
   
