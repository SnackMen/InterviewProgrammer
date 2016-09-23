/**
 * Created by laowang on 16-9-23.
 */

/*
给定两个排序后的数组A和B，其中A的末端有足够的缓冲容纳B,编写一个方法，将
B并入A并排序
 */

/*
已知数组A末端有足够的缓冲，不需要再分配额外的空间，程序的处理逻辑很简单，就是逐一比较A和B的元素，并按书序插入数组，直至耗尽A和B的所有元素
其中需要注意的问题是插入问题，将元素插入数组A的末端，那里都是空闲的可用空间
 */

public class Main {
    public static void main(String []args){

    }

    public static void merge(int []a,int []b,int lastA,int lastB){
        int indexA = lastA -1;//数组a最后元素的索引
        int indexB = lastB -1;//数组b最后元素的索引
        int indexMerged = lastB+lastA-1;//合并后数组的最后元素索引

        /*
        合并a和b，从这两个数组的最后元素开始
         */
        while (indexA >= 0&& indexB >= 0){
            //数组A最后元素大于B
            if(a[indexA] > b[indexB]){
                a[indexMerged] = a[indexA];
                indexMerged --;//更新索引
                indexA --;
            }else{
                a[indexMerged] = b[indexB];
                indexMerged --;
                indexB--;
            }
        }
        /*
        将数组b剩余元素复制到适当位置
         */
        while (indexB >=0){
            a[indexMerged] = b[indexB];
            indexMerged --;
            indexB--;
        }
    }
}
