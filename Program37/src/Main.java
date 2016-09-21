/**
 * Created by laowang on 16-9-21.
 */

/*
在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i]=i
给定一个有序整数数组，元素值各不相同，编写一个方法，，在数组A中找出一个魔术索引，若存在的话
 */

public class Main {
    public static void main(String []args){
        /*
        这是一个有序数组，而且魔术索引唯一，因此可以考虑利用类似二分查找的方法来求解
         */

    }

    private static int magicFast(int []array,int start,int end){
        if(end < start || start<0 || end>=array.length){
            return -1;
        }
        int mid = (start+end)/2;
        if(array[mid] == mid)
            return mid;
        else if(array[mid] > mid)
            return magicFast(array,start,mid-1);
        else
            return magicFast(array,mid+1,end);
    }

    /*
    进阶
    如果数组中又重复值，那么该怎么解决
     */

    /*
    依然采用二分法，但是过冲稍微有点区别，需要比较大小
     */

    private static int magicLast(int []array,int start,int end){
        if(end < start || start<0 || end>=array.length){
            return -1;
        }
        int mid = (start+end);
        int midValue = array[mid];
        if(midValue == array[mid])
            return midValue;

        //索引左半部分
        int leftIndex = Math.max(midValue,mid-1);
        int left = magicFast(array,start,leftIndex);
        if(left>=0)
            return left;

        //索引右半部分
        int rightIndex = Math.max(midValue,mid+1);
        int right = magicFast(array,rightIndex,end);
        return right;
    }
}
