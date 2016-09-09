package com.ws.program;

/*
设计一个算法，找出二叉查找树中指定结点的“下一个”结点（即中序后继）
可以假定每个结点都含有指向父结点的连接
 */

/*
思路：
    （1）如果这个结点有右结点，那么它的下一个结点就在右子树的最左边的孩子结点
    （2）如果没有右结点，那么判断当前结点是其父节点的左孩子还是右孩子，
        如果是左孩子，那么父节点就是下一个结点，如果是右孩子，那么父节点的父节点的
        左孩子是其下一个结点，直到找打合适的值
 */

import com.ws.node.TreeNode;

/**
 * Created by laowang on 16-9-9.
 */
public class Program {
    public TreeNode inorderSucc(TreeNode n){
        if(n==null)
            return null;
        /*
        找到右子结点，则返回右子树里最左边的结点
         */
        if(n.right != null){
            return ledtMostChild(n.right);
        }else{
            TreeNode q = n;
            TreeNode x = q.parent;
            //向上直至位于左边而不是右边
            while (x!=null && x.left!=q){
                q=x;
                x=x.parent;
            }
            return x;
        }
    }

    private TreeNode ledtMostChild(TreeNode n){
        if(n==null)
            return null;
        while (n.left != null)
            n = n.left;
        return n;
    }
}
