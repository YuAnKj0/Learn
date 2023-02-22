package com.yuan.algorithm.linkedlist;

/**
 * @author Ykj
 * @date 2023/2/22/21:53
 * @apiNote
 */
public class SingleLinkedListDemo {
   public static void main(String[] args) {
      HeroNode node1=new HeroNode(1,"宋江","及时雨");
      HeroNode node2=new HeroNode(2,"卢俊义","玉麒麟");
      HeroNode node3=new HeroNode(3,"吴用","智多星");
      HeroNode node4=new HeroNode(4,"林冲","豹子头");
      
      SingleLinkedList list=new SingleLinkedList();
      //list.add(node1);
      //list.add(node2);
      //list.add(node3);
      //list.add(node4);
      list.addByOrder(node1);
      list.addByOrder(node4);
      list.addByOrder(node2);
      list.addByOrder(node3);
      list.list();
      HeroNode newNode=new HeroNode(2,"小路","玉麒麟~~~");
      list.update(newNode);
      System.out.println("修改后的链表：");
      list.list();
      //删除一个节点
      list.del(1);
      System.out.println("删除后的链表：");
      list.list();
   }
}
//创建一个单链表
class SingleLinkedList {
   //先初始化一个头节点，不存放任何东西
   private  HeroNode head=new HeroNode(0,"","");
   //添加节点到单向链表
   //当不考虑顺序时，找到当前链表的最后一个节点，将最后一个节点的next指向新的节点
   public void add(HeroNode node){
      //需要一个辅助遍历temp
      HeroNode temp=head;
      //遍历链表，找到最后
      while (true){
         if (temp.next==null){
            break;
         }
         temp=temp.next;
      }
      //当退出white循环时，temp就指向了链表的最后一个
      temp.next=node;
   }
   //第二种方法；根据排名添加时，如果有英雄，添加失败，乳沟吗，添加
   public void addByOrder(HeroNode node){
      HeroNode temp = head;
      boolean flag=false;//添加的编号是否存在
      while (true){
         if (temp.next == null) {
            break;
         }
         if (temp.next.no>node.no){
            //位置找到，就在temp的位置后面插入
            break;
         }else if (temp.next.no==node.no){
            flag=true;//already exist
         }
         temp=temp.next;
      }
      //判断flag的值
      if (flag){
         System.out.printf("编号%d的英雄已经存在了，不能加入\n",node.no);
      }else {
         //插入到链表中temp的后面
         node.next=temp.next;
         temp.next=node;
      }
      
   }
   //修改节点的信息
   public void update(HeroNode node){
      if (head.next==null){
         System.out.println("链表为空");
         return;
      }
      //找到需要修改的节点
      HeroNode temp=head.next;
      boolean flag = false;
      while (true){
         if (temp==null){
            break;
         }
         if (temp.no==node.no){
            flag=true;
            break;
         }
         temp=temp.next;
      }
      //根据flag判断是否找到
      if (flag){
         temp.name=node.name;
         temp.nickName=node.nickName;
      }else {
         System.out.printf("没有找到%d的节点\n",node.no);
      }
   
   }   
   //删除节点
   //head不能动，需要一个辅助temp找到待删除节点的前一个节点，在比较时，是temp.next.mo?=node.no
   public void del(int no){
      HeroNode temp = head;
      boolean flag = false;
      while (true) {
          if(temp.next==null){
             break;
          }
          if (temp.next.no==no){
             flag=true;
             break;
          }
          temp = temp.next;//后移，遍历
         
      }
      if (flag){
         //找到，可以删除
         temp.next=temp.next.next;
      }else {
         System.out.printf("没有找到%d的节点",no);
   
      }      
   }
   //显示链表：遍历
   public void list(){
      
      //判空
      if (head == null){
         System.out.println("链表为空");
         return;
      }
      HeroNode temp = head.next;
      while (true){
         if (temp==null){
            break;
         }
         System.out.println(temp);
         temp = temp.next;
      }
   }

   
}
//定义一个HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
   public int no;
   public String name;
   public String nickName;
   public HeroNode next;//指向下一个节点
   //构造器
   public HeroNode(int no,String name,String nickName){
      this.no=no;
      this.name=name;
      this.nickName = nickName;
   }
   
   @Override
   public String toString() {
      return "HeroNode{" +
              "no=" + no +
              ", name='" + name + '\'' +
              ", nickName='" + nickName + '\'' +
              '}';
   }
}
