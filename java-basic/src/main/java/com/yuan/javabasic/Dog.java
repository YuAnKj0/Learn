package com.yuan.javabasic;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

/**
 * @author Ykj
 * @date 2022/10/11/9:35
 * @apiNote
 */
public class Dog extends JFrame {
    public Dog (int x,int y,int num){
       setTitle("行不行啊细狗"); 
       setBounds(x,y,350,150);
       getContentPane().setLayout(null);
       JPanel panel=new JPanel();
       panel.setBounds(0,0,350,200);
       Color color[]={Color.GREEN,Color.BLUE,Color.CYAN,Color.MAGENTA,Color.YELLOW,Color.PINK,Color.WHITE};
       panel.setBackground(color[num]);
       getContentPane().add(panel);
       JLabel label=new JLabel("你行不行啊，细狗~");
       label.setFont(new Font("宋体",Font.BOLD,26));
       panel.add(label);
       setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            CompletableFuture<Void> future= CompletableFuture.runAsync(()->{
                Random random=new Random();
                int x = random.nextInt(1300)+100;
                int y = random.nextInt(600)+100;
                int num = random.nextInt(6);
                
                new Dog(x,y,num);
            });
            /*Random random=new Random();
            int x = random.nextInt(1300)+100;
            int y = random.nextInt(600)+100;
            int num = random.nextInt(6);
            new Dog(x,y,num);*/
            Thread.sleep(100);
            
    
    
        }
        
    
    }    
    
}
