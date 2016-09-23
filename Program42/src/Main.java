import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by laowang on 16-9-23.
 */

/*
编写一个方法，对字符串数组，进行排序，将所有变位词排在相邻的位置
 */

public class Main {
    public static void main(String []args){
        String []strings = new String[]{"b","d","f","a","a","s","b"};
        sort(strings);
        for(String string : strings){
            System.out.println(string);
        }
        System.out.println("******************************");

    }

    private static String sortChars(String s){
        char []content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    private static int compare(String s1,String s2){
        /*
        按字典序比较两个字符串，该比较基于个字符串个字符unicode值
        按字典顺序将此字符串对象表示的字符序列与参数字符串所表示的字符序列进行比较，
        如果按字典顺序此String对象位于参数字符串之前，则比较结果为一个负整数
        如果按字典顺序此string对象位于参数字符串之后，则比较结果为一个正整数，如果两个
        字符串相等，结果为0，compareTo只在防范equals返回true时才返回0
         */
        return sortChars(s1).compareTo(sortChars(s2));
    }

    //方法二：利用散列表求解
    private static void sort(String []array){
        Hashtable<String,LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();

        /*
        将同为变位词的单词分在同一组,key是统一字典序，value是各种变位词
         */
        for(String s : array){
            String key = sortChars(s);
            if(!hash.containsKey(key)){
                hash.put(key,new LinkedList<String>());
            }
            LinkedList<String> anagrams = hash.get(key);
            anagrams.add(s);
        }
        /*
        将散列表转换成数组
         */
        int index = 0;
        for(String key : hash.keySet()){
            LinkedList<String> list = hash.get(key);
            for(String t : list){
                array[index] = t;
                index ++;
            }
        }
    }

}
