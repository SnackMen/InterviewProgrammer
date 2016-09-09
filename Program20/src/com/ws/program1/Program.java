package com.ws.program1;

/*
解法二
    对广度优先搜索稍加修改，即从根结点开始迭代，然后第二层，
    第三层，等等，处于第i层的时候，则表明我们已经访问过第i-1层
    的所有结点，也就是说，要得到第i层的结点，只需直接查看第i-1层的结点即可
 */

import com.ws.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by laowang on 16-9-9.
 */
public class Program {
    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        /*
        访问根结点
         */
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if(root!=null){
            current.add(root);
        }
        while (current.size() > 0){
            result.add(current);//加入上一层
            LinkedList<TreeNode> parents = current;//转入下一层
            current = new LinkedList<TreeNode>();
            for(TreeNode parent : parents){//遍历每个结点
                /*
                访问子结点
                 */
                if(parent.left != null)
                    current.add(parent.left);
                if(parent.right!=null)
                    current.add(parent.right);
            }
        }
        return result;
    }
}
