package com.ws.program;

import com.ws.linklist.LinkedListNode;

/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){

    }

    /*
    传入链表的首结点，以及作为链表分割基准的值
     */
    public static LinkedListNode partition(LinkedListNode node,int x){
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while(node!=null){
            LinkedListNode next = node.next;
            node.next = null;
            if(node.val < x){
                /*
                将结果插入before链表
                 */
                if(beforeStart == null){
                    beforeStart = node;
                    beforeEnd = beforeStart;
                }else{
                    beforeEnd.next = node;
                    beforeEnd=node;
                }
            }else{
                /*
                 * 将结点插入after链表
                 */
                if(afterStart == null){
                    afterStart = node;
                    afterEnd = afterStart;
                }else{
                    afterEnd.next = node;
                    afterEnd=node;
                }
            }
            node = next;
        }

        if(beforeStart == null)
            return afterStart;
        /*
        合并before和after链表
         */
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
