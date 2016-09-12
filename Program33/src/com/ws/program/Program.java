package com.ws.program;

/**
 * Created by laowang on 16-9-12.
 */
public class Program {
    public static void main(String []args){
        int n=1;
        System.out.println(((n & 0xaaaaaaaa)>>1)|((n&0x55555555) <<1));
    }
}
