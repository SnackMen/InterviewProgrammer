import java.util.ArrayList;

/**
 * Created by laowang on 16-9-22.
 */

/*
编写一个方法，确定某字符串的所有排列组合
 */

/*
分析：
    这是一道十分简单而且正常的递归题目，主要考虑的地方在于
    如何根据上一个来推导下一个问题，比如已知2个数的排列，如何知道三个数的排列呢，
    就需要在两个数的基础上在其任意位置插入一个数
 */
public class Main {
    public static void main(String []args){
        ArrayList<String> arrayList = getPerms("123");
        for (String string : arrayList){
            System.out.println(string);
        }
    }

    private static ArrayList<String> getPerms(String str){
        if(str==null)
            return null;
        ArrayList<String> permutations = new ArrayList<String>();
        if(str.length() == 0){//终止条件
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0);//取得第一个字符
        String remainder = str.substring(1);//移除第一个字符
        ArrayList<String> words = getPerms(remainder);
        for(String word : words){
            for(int j=0;j<=word.length();j++){
                String s = insertCharAt(word,first,j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    private static String insertCharAt(String word,char c,int i){
        String start = word.substring(0,i);//指定位置开始，到索引减一处结束
        String end = word.substring(i);//从指定位置开始，到结尾
        return start+c+end;
    }
}
