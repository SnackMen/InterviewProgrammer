import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by laowang on 16-9-23.
 */

/*
实现一种算法，打印n对括号的全部有效组合
 */
/*
思想：
将将一对括号添加进n-1对括号中，但是添加之后需要做的是检查这种排列方式是否重复
 */
public class Main {
    public static void main(String []args){
        Set<String> set = generateParens(3);
        for(String string : set){
            System.out.println(string);
        }

        System.out.println("*************************************************");

        ArrayList<String> list = generateParen(3);
        for(String str: list){
            System.out.println(str);
        }
    }

    private static Set<String> generateParens(int remaining){
        Set<String> set = new HashSet<String>();
        if(remaining == 0)
            set.add("");
        else {
            Set<String> prev = generateParens(remaining-1);
            for(String string : prev){
                for(int i=0;i<string.length();i++){
                    if(string.charAt(i) == '('){//遍历到左括号，就会插入一个双括号
                        //插入元素前，hashset会自动检测元素是否存在重复
                        String s = insertInside(string,i);
                        set.add(s);
                    }
                }
                if(!set.contains("()"+string)){//考虑特殊情况，即类似于()()这种括号不包含在内部情况，而且需要先判断是都已经存在这种情况
                    set.add("()"+string);
                }
            }
        }
        return set;
    }

    private static String insertInside(String string,int leftIndex){
        String left = string.substring(0,leftIndex+1);
        String right = string.substring(leftIndex+1,string.length());
        return left+"()"+right;
    }

    //解法二，直接从头构造，避免出现重复字符串
    private static void addParen(ArrayList<String> list,int leftRem,int rightRem,char []str,int count){
        if(leftRem <0 || rightRem<leftRem)
            return;//无效状态
        if(leftRem ==0 && rightRem ==0) {//没有括号可用
            String s = String.copyValueOf(str);
            list.add(s);
        }else{
            /*
            若还有左括号可用，则加入一个左括号
             */
            if(leftRem > 0){
                str[count] = '(';
                addParen(list,leftRem-1,rightRem,str,count+1);
            }

            /*
            这两者之间有个共同的变量已知在改变，那就是str，所以会出现很多中不同的组合
             */

            /*
            若字符串是有效的，则加入右括号
             */
            if(rightRem > leftRem){
                str[count] = ')';
                addParen(list,leftRem,rightRem-1,str,count+1);
            }
        }
    }

    private static ArrayList<String> generateParen(int count){
        char []str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list,count,count,str,0);
        return list;
    }
}
