package com.ws.program;

/**
 * Created by laowang on 16-9-12.
 */

/*
给定两个32位的整数N与M，以及表示比特位置的i与j.编写一个方法，将M插入N，使得M从N的
第j位开始，到第j位结束，假定从j位到i位足以容纳M，也即若M=10011,那么j和i1之间至少颗容纳5个位。例如，不可出现j=3和i=2的情况，因为第3位
和第2位之间放不下M
 */

/*
解法：
    1.将N中从j到i之间的位清零
    2.对M执行移位操作，与j和i之间的位对齐
    3.合并M与N
 */
public class Program {

    public static void main(String []args){
        System.out.println(updateBits(1024,19,2,6));
    }

    private static int updateBits(int n,int m,int i,int j){
        /*
        创建掩码，用来清除n中i到j的位
        为简单起见，本例掩码只有8位
         */

        int allOnes = ~0;
        //在位置j之前的位均为1，其余为0，left = 11100000
        int left = allOnes << (j+1);//左移5位

        int right = ((1 << i) -1); //左移i位之后，再减去1

        //除i到j的位为零，其余位均为1
        int mask = left | right;

        int n_cleared = n & mask;//清除j到i的位
        int m_shifted = m << i;
        return n_cleared | m_shifted;

    }

}
