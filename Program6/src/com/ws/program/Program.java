package com.ws.program;

import linklist.LinkedListNode;
import sun.awt.image.ImageWatched;

/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){
        LinkedListNode linkedListNode = new LinkedListNode(0);
        linkedListNode.appendToTail(1);
        linkedListNode.appendToTail(2);
        linkedListNode.appendToTail(3);

//        nthToLast(linkedListNode,3);
        System.out.println(nthToLast1(linkedListNode,3).val);

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

    private  static LinkedListNode nthToLast1(LinkedListNode head,int k){
        if(k<=0)
            return null;
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        //p2向前移动k个结点
        for(int i=0;i<k-1;i++){
            if(p2==null)
                return null;
            p2=p2.next;
        }
        if(p1==null)
            return null;
        /**
         * 现在以同样的速度移动p1和p2,当p2抵达链表末尾时，p1刚好指向倒数的第k个结点
         */

        while (p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
