package linklist;

/**
 * Created by laowang on 16-9-6.
 */
public class LinkedListNode {
    public LinkedListNode next=null;
    public int val;

    public LinkedListNode(int data){
        val = data;
    }

    public void appendToTail(int d){
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this;
        while(n.next!=null){
            n=n.next;
        }
        n.next=end;
    }
}
