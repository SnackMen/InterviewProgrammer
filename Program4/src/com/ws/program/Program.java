package com.ws.program;

/**
 * 假定有一个方法isSubstring,可检查一个单词是否为其他字符串的字串
 * 给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次isSubstring方法
 */

/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){

    }

    public static boolean isRotation(String s1,String s2){
        int len = s1.length();
        //检查s1和s2是否等长且不为空
        if(len==s2.length() && len>0){
            String s1s2 = s1+s2;
            return isSubstring(s1s2,s2);
        }

        return false;
    }

    private static boolean isSubstring(String s1s2, String s2) {
        return s1s2.contains(s2);
    }

}
