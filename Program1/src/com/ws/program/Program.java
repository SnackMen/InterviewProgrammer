package com.ws.program;

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
        char last = str.charAt(0);
        int count = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==last){
                count++;
            }else{
                index = setChar(array,last,index,count);
                last = str.charAt(i);
                count = 1;
            }
        }
        index = setChar(array,last,index,count);
        return String.valueOf(array);
    }

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
