package com.ws.program;

/**
 * Created by laowang on 16-9-12.
 */
/*
检验 (n & (n-1))==0  含义  检验一个数是否为2的n次方
 */
public class Program {
    public static void main(String []args){
        int n=15;
        if((n&(n-1))==0)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
