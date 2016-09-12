package com.ws.program;

/**
 * Created by laowang on 16-9-12.
 */

/*
给定一个介于0和1之间的实数，类型为double,打印二进制
表示，如果该数字无法精确用32位以内的二进制表示，则打印“ERROR"
 */
public class Program {
    public static void main(String []args){

    }
    private static String printBinary(double num){
        if(num >= 1 || num<=0)
            return "ERROR";

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num>=0){
            /*
            设定长度上限：32个字符
             */
            if(binary.length() >= 32){
                return "ERROR";
            }
            double r = num*2;
            if(r >=1 ){
                binary.append(1);
                num = r-1;
            }else{
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();

    }
}
