package com.ws.program;

import linklist.LinkedListNode;

/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){
        LinkedListNode linkedListNode = new LinkedListNode(0);
        linkedListNode.appendToTail(1);
        linkedListNode.appendToTail(2);
        linkedListNode.appendToTail(3);

        nthToLast(linkedListNode,3);

    }

    private static int nthToLast(LinkedListNode head, int k){
        if(head==null){
            return 0;
        }

        int i=nthToLast(head.next,k)+1;
        if(i==k){
            System.out.println(head.val);
        }
        return i;
    }
}
