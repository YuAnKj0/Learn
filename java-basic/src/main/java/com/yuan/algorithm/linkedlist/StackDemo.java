package com.yuan.algorithm.linkedlist;

import java.util.Stack;

/**
 * @author Ykj
 * @date 2023/2/23/9:41
 * @apiNote
 */
public class StackDemo {
   public static void main(String[] args) {
      Stack stack = new Stack();
      //reversePrint(new Node(0,"",""));
   }
   
   public static void reversePrint(Node node) {
      if(node.next==null){
         return;
      }
      Stack<Node> stack=new Stack<>();
      Node cur=node.next;
      //将链表节点压入栈
      while (cur != null){
         stack.push(cur);
         cur=cur.next;  //cur后移,这样就可以压入下一个节点
      }
      while (stack.size()>0){
         System.out.println(stack.pop());//stack的特点是先进后出
      }
   }
}
class Node{
   public int no;
   public String name;
   public String nickName;
   public Node next;//指向下一个节点
   //构造器
   public Node(int no,String name,String nickName){
      this.no=no;
      this.name=name;
      this.nickName = nickName;
   }
   
   @Override
   public String toString() {
      return "Node{" +
              "no=" + no +
              ", name='" + name + '\'' +
              ", nickName='" + nickName + '\'' +
              '}';
   }
}

