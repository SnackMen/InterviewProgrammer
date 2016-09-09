package com.ws.program;

import com.ws.node.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

/*
给定一棵二叉树，设计一个算法，创建含有某一深度上所有结点的链表（比如，若一棵树的深度为D
,则会创建出D个链表
 */

/**
 * Created by laowang on 16-9-8.
 */
public class Program {

    private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
        if(root == null){
            return;
        }
        LinkedList<TreeNode> list = null;
        if(lists.size() == level){//该层不在链表中
            list = new LinkedList<TreeNode>();
            /*
            以中序遍历所有层组，因此，若这是第一次访问i层，则表示我们已经访问过第0到
            第i-1层
            因此，我们可以安全的将这一层加到链表末端
             */
            lists.add(list);

        }else
            list = lists.get(level);
        list.add(root);
        createLevelLinkedList(root.left,lists,level+1);
        createLevelLinkedList(root.right,lists,level+1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root,lists,0);
        return lists;
    }

    public static void main(String []args){

    }
}
