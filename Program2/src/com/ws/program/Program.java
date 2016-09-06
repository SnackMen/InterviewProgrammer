package com.ws.program;

/**
 * 给定一幅由N*N矩阵表示的图像，其中每个像素的大小为5字节，编写一个
 * 方法，将图像旋转90度，不占用额外内存空间能否做到
 */
/**
 * 思路：
 * 从最外层开始逐渐向里，在没一层上执行交换，
 *  for i=0 to n
 *      temp = top[i]
 *      top[i] = left]i]
 *      left[i] = bottom[i]
 *      bottom[i] = right[i]
 *      right[i] = temp
 */


/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){
        int [][]matrix={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
                if(j==2)
                    System.out.println();
            }
        }

        System.out.println();

        rotate(matrix,3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
                if(j==2)
                    System.out.println();
            }
        }
    }

    private static void rotate(int[][] matrix, int n){
        for(int layer = 0;layer<n/2;layer++){
            int last = n-1-layer;
            for(int i = layer; i<last; i++){
                int offset = i- layer;
                //存储上边
                int top = matrix[layer][i];
                //左到上
                matrix[layer][i] = matrix[last-offset][layer];

                //下到左
                matrix[last-offset][layer] = matrix[last][last-offset];

                //右到下
                matrix[last][last-offset] = matrix[i][last];

                //上到右
                matrix[i][last] = top;

            }
        }
    }
}
