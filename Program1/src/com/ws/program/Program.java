package com.ws.program;

/**
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能，比如，字符串
 * aabcccccaaa会变成能够a2b1c5a3，若压缩后字符串长度没有变短，则返回原先的字符串
 */

/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){
        System.out.println(compressAlternate("aaabbbcccddd"));
    }

    private static String compressAlternate(String str){
        int size = countCompression(str);
        if(size >= str.length()){
            return str;
        }
        char []array = new char[size];
        int index = 0;
        char last = str.charAt(0);//记录首字符
        int count = 1;//记录重复数量
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==last){
                count++;
            }else{
                index = setChar(array,last,index,count);
                last = str.charAt(i);
                count = 1;
            }
        }
        setChar(array,last,index,count);
        return String.valueOf(array);
    }

    //多个相同字符简写
    private static int setChar(char[] array, char last, int index, int count) {
        array[index] = last;
        index += 1;
        /*
        将数目转换成字符串，然后转换成字符数组
         */
        char []cnt = String.valueOf(count).toCharArray();
        for(char x: cnt){
            array[index] = x;
            index++;
        }
        return index;

    }

    //判断合并后的长度为多少
    private static int countCompression(String str) {
        if(str == null || str.length()==0)
            return 0;
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==last){
                count++;
            }else{
                last = str.charAt(i);
                size += 1+String.valueOf(count).length();
                count=1;
            }
        }
        size += 1+String.valueOf(count).length();
        return size;

    }
}
