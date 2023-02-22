package com.yuan.algorithm.sparsearray;

/**
 * @author Ykj
 * @date 2023/2/22/16:10
 * @apiNote
 */
public class AparseArray {
   public static void main(String[] args) {
      //创建一个二维数组
      int[][] chessArr = new int[11][11];
      chessArr[1][2]=1;
      chessArr[2][3]=2;
      chessArr[4][5]=2;
      
      
      //输出原始的数组
      System.out.println("原始的数组。。。");
      for (int[] row:chessArr){
         for (int data:row){
            System.out.printf("%d\t", data);
         }
         System.out.println();
      }
      //将二维数组转为稀疏数组
      int sum = 0;
      for (int i=0; i<11; i++){
         for (int j=0;j<11;j++){
            if (chessArr[i][j]!=0){
               sum++;
            }
         }
      }
      //创建对应的稀疏数组
      int sparseArr[][]=new int[sum+1][3];
      //给稀疏数组赋值
      sparseArr[0][0]=11;
      sparseArr[0][1]=11;
      sparseArr[0][2]=sum;
      //遍历二维数组，将非0的值存放到sparseArr中
      int count=0;
      for (int i=0;i<11;i++){
         for (int j=0;j<11;j++){
            if (chessArr[i][j]!=0){
               count++;
               sparseArr[count][0]=i;
               sparseArr[count][1]=j;
               sparseArr[count][2]=chessArr[i][j];
            }
         }
      }
      //输出稀疏数组的形式
      System.out.println(  );
      System.out.println("得到的稀疏数组为：");
      for (int i=0;i< sparseArr.length;i++){
         System.out.printf("%d\t%d\t%d\t\n",
                 sparseArr[i][0],
                 sparseArr[i][1],
                 sparseArr[i][2]);
      }
      System.out.println();
      
      
      //将稀疏数组恢复成原来的二维数组
      /*
         1）先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，
         2）在读取稀疏数组后几行的数据，并赋给原始的二维数组
      */
      int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
      for (int i=1;i<sparseArr.length;i++){
         chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
      }
      //输出恢复后的二维数组
      System.out.println();
      System.out.println("回复后的二维数组");
      for (int[] row:chessArr2){
         for (int data:row){
            System.out.printf("%d\t",data);
         }
         System.out.println();
      }
   }
}
