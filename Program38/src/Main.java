import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by laowang on 16-9-22.
 */

/*
编写一个方法，返回某集合的所有子集
 */

public class Main {
    public static void main(String []args){

    }
    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index){//终止
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());//空集合
        }else{
            allsubsets = getSubsets(set,index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: allsubsets){
                ArrayList<Integer>  newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    //组合数学方法解决问题

    private static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();//添加所有子集
        int max = 1 << set.size();//2^n
        for(int k = 0;k<max;k++){
            ArrayList<Integer> subset = covertIntToSet(k,set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }

    private static ArrayList<Integer> covertIntToSet(int x,ArrayList<Integer> set){
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for(int k=x;k>0;k>>=1){
            if((k&1) ==1){
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
}
