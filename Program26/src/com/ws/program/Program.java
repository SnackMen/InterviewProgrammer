package com.ws.program;

import com.ws.node.TreeNode;

/*
给定一棵二叉树，其中每个结点都含有一个数值，设计一个算法，打印结点数值总和等于
某个给定值的多有路径。注意，路径不一定非得从二叉树的根结点或叶结点开始或结束
 */

/**
 * Created by laowang on 16-9-9.
 */
public class Program {

    private void findSum(TreeNode node, int sum, int[] path, int level){
        if(node == null)
            return;

        /*将当前结点插入路径*/
        path[level] = node.val;

        /*查找以此为终点且总和为sum的路径*/
        int t = 0;
        for(int i=level;i>=0;i--){//从当前结点开始往上计算，如果遇到相等，那么就结束
            t+=path[i];
            if(t == sum)
                print(path,i,level);
        }
        /*查找此节点之下的结点*/
        findSum(node.left,sum,path,level+1);
        findSum(node.right,sum,path,level+1);

        /*从路径移除当前结点，严格来说并不一定这么做，
        * 直接忽略即可，但是这么做是个好习惯*/
        path[level] = Integer.MIN_VALUE;

    }
    public void findSum(TreeNode node,int sum){
        int depth = depth(node);
        int []path = new int[depth];
        findSum(node,sum,path,0);
    }

    private static void print(int[] path, int start, int end){
        for(int i=start;i<=end;i++){
            System.out.println(path[i]+" ");
        }

        System.out.println();
    }

    private int depth(TreeNode node){
        if(node == null)
            return  0;
        else
            return 1+Math.max(depth(node.left),depth(node.right));
    }

}
