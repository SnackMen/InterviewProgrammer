import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by laowang on 16-9-21.
 */

/*
设想有个机器人坐在X*Y网格的左上角，只能向右，向下移动。机器人从(0,0)到(X,Y）有多少种走法
进阶
假设有些点为“禁区"，机器人不能踏足。设计一种算法，找出一条路径，让机器人从左上角移动到右下角
 */

/*
对于第一个问题
我们需要考虑的是向右移动X步，向下移动Y步即可，所以就是X个R加上Y个D的排列问题，很简单
 */
/*
对于第二个问题，就需要使用程序来解决问题
 */
public class Main {
    public static void main(String []args){
        ArrayList<Point> list = new ArrayList<Point>();
        if(getPath(4,4,list))
            System.out.println(list.size());
        else
            System.out.println("NO");
    }

    private static boolean getPath(int x, int y, ArrayList<Point> path){
        Point p = new Point(x,y);
        path.add(p);
        if(x==0 && y==0){
            return true;
        }
        boolean success = false;
        if(x>=1 && isFree(x-1,y)){//试着向左
            success = getPath(x-1,y,path);
        }

        if(!success && y>=1 && isFree(x,y-1)){//试着向上
            success = getPath(x,y-1,path);
        }
        if(!success){
            path.add(p);
        }

        return success;

    }


    private boolean getPath1(int x, int y, ArrayList<Point> path, Hashtable<Point,Boolean> cache){
        Point p = new Point(x,y);
        if(cache.containsKey(p)){
            return cache.get(p);
        }
        path.add(p);

        if(x==0 && y==0){
            return true;
        }
        boolean success = false;
        if(x >=1 && isFree(x-1,y)){
            success = getPath1(x-1,y,path,cache);
        }
        if(!success && y>=1 && isFree(x,y-1)){
            success = getPath1(x,y-1,path,cache);
        }
        if(!success)
            path.add(p);
        cache.put(p,success);
        return success;
    }

    /*
    由于之前提到了重复路径问题。要找到一条前往(x,y)的路径，就要找出到他的相邻顶点的、
    (x-1,y)和(x,y-1)的路径。当然，若其中一个方格禁止同行，我们就要绕着走，接着再看这两个相邻点
    (x-1,y),(x-1,y-1),(x-1,y-1),和(x,y-2)其中，(x-1,y-1)出现了两次，也意味着我们做了一次无用功。理想情况下，我们应该几下先前访问的
    (x-1,y-1)以免浪费宝贵时间
     */
    private static boolean isFree(int x,int y){
        return !(x == 2 && y == 2);
    }
}

class Point{
    private int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
