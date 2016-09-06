package com.ws.program;

/**
 * 编写一个算法，若M*N矩阵中某个元素为零，则将其所在的行与列清零
 */

/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){
        int [][]matrix = new int[][]{
                {1,2,3},
                {4,0,6},
                {7,8,9}
        };
        setZeros(matrix);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
                if(j==2)
                    System.out.println();
            }
        }
    }

    private static void setZeros(int[][] matrix){
        boolean []row = new boolean[matrix.length];
        boolean []column = new boolean[matrix[0].length];

        //记录值为0的元素坐在行和列的索引
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    column[j]=true;
                }
            }
        }
        //若行i或列j有个元素为0，则将arr[i][j]置为0
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row[i] || column[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
