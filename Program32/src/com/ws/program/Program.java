package com.ws.program;

/**
 * Created by laowang on 16-9-12.
 */

/*
编写一个函数，确定需要改变几个位，才能将整数A转成整数B
 */
public class Program {
    public static void main(String []args){
        int count = 0;
        int a=7;
        int b=8;
        for(int c = a^b;c!=0;c=c&(c-1)){
            count ++;
        }
        System.out.println(count);
    }
}
