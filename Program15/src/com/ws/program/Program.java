package com.ws.program;

import java.util.Stack;

/**
 * Created by laowang on 16-9-7.
 */
public class Program {
    public static void main(String []args){
        Stack<Integer> s = new Stack<Integer>();
        s.push(7);
        s.push(5);
        s.push(8);
        s.push(6);
        s.push(9);
        Stack<Integer> r = sort(s);
//        System.out.println(r.size());
        while (!r.isEmpty()){
            System.out.println(r.pop());
        }
    }

    private static Stack<Integer> sort(Stack<Integer> s){
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()){
            int tmp = s.pop();//步骤一
            while (!r.isEmpty() && r.peek() > tmp){//步骤二
                System.out.println(0);
                s.push(r.pop());
            }
            System.out.println("=======================");
            r.push(tmp);//步骤三
        }
        return r;
    }
}
