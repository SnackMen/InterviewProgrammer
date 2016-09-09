package com.ws.program;

/**
 * 设计并实现一个算法，找出二叉树中两个结点的第一个共同祖先，不得
 * 将二外的结点存储在另外一个数据结构中，注意，这不是二叉查找树
 */

import com.ws.node.TreeNode;

/**
 * Created by laowang on 16-9-9.
 */
public class Program {

    /*
    方法一：不包含指向父结点的连接
     */
    /*若p为root子孙，则返回true*/
    private boolean covers(TreeNode root, TreeNode p) {
        return root != null && (root == p || covers(root.left, p) || covers(root.right, p));
    }

    private TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root == p || root==q)
            return root;
        //下面两条同时为真，说明两个结点都在根结点左边，都不满足说明在右边，一个满足一个不满足，说明根结点就是要求的答案
        boolean is_p_on_left = covers(root.left,p);
        boolean is_q_on_left = covers(root.left,q);

        /*
        若p和q不在同一边，则返回root
         */
        if(is_p_on_left !=is_q_on_left)
            return root;
        /*否则就在同一边，遍访那一边*/
        TreeNode child_side = is_p_on_left ? root.left:root.right;
        return commonAncestorHelper(child_side,p,q);//递归遍历左结点或者右结点
    }

    TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(!covers(root,p) || !covers(root,q)){//错误检查
            return null;
        }

        return commonAncestorHelper(root,p,q);
    }
}
