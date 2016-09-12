package com.ws.program;

/**
 * Created by laowang on 16-9-12.
 */
public class Program {



    public static void main(String []args){
        System.out.println(setBit(15,2));

        System.out.println(updateBit(15,2,8));
    }

    private static int setBit(int num, int i){
        return num ^ (1<<i);
    }


    private static int updateBit(int num,int i,int v){
        int mask = ~(1 << i);
        return (num & mask) | (v << i);
    }
}

