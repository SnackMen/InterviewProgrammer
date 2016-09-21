/**
 * Created by laowang on 16-9-21.
 */

/*
递归问题
自下而上的递归

自下而上的递归往往最为直观，首先要知道如何解决简单情况下的问题，比如，有一个元素的列表，找出只有两个/三个的列表，以此类推
这种解法的关键在于，如何从先前解除来的答案构建除后续的情况的答案

自上而下的递归
自上而下的递归比较复杂，不过对于某些问题很有必要，遇到这类问题是，我们要思考如何才能将情况N
下的问题分解成多个子问题，同时要注意子问题是否重复
 */

/*
动态规划问题

动态规划问题和递归问题相比较，主要变化是将中间过程存储起来
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 问题：
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶，2阶，或3阶
 * 实现一个方法，计算小孩有多少种上楼梯的方式
 */
public class Main {
    public static void main(String []args){
        System.out.println(countWays(50));

        int []nums = new int[50];
        System.out.println(countsWayDP(20,nums));
    }

    //递归，没有存储中间状态
    private static int countWays(int n){
        if(n<0)
            return 0;
        else if(n==0)
            return 1;
        else{
            return countWays(n-1)+countWays(n-2)+countWays(n-3);
        }
    }

    //动态规划，包含中间状态,这样做的优势在于，节省了很多时间
    private static int countsWayDP(int n,int []map){
        if(n<0)
            return 0;
        else if(n==0)
            return 1;
        else if(map[n] >0){
            return map[n];
        }else{
            map[n] = countsWayDP(n-1,map)+countsWayDP(n-2,map)+countsWayDP(n-3,map);
            return map[n];
        }
    }
}
