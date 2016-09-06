package com.ws.program;

import com.ws.linklist.LinkedListNode;
/*
实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点

    解法:
           在这个问题种，你访问不到链表的首结点，只能访问那个待删除的结点，解法很简单，
           直接将后继结点的数据复制到当前结点，然后删除这个后继结点
 */
/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){

    }

    public static boolean deleteNode(LinkedListNode n){
        if(n==null || n.next==null)
            return false;
        LinkedListNode next = n.next;
        n.val = next.val;
        n.next = next.next;
        return true;
    }
}
