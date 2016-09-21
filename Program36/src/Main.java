import java.util.ArrayList;
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
