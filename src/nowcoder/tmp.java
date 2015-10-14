package nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ping on 2015/8/16.
 */
public class tmp {
    public static void main(String args[])
    {
        Queue<String> q = new LinkedList();
        q.offer("1");
        q.offer("2");
        q.offer("3");
        q.offer("4");
        q.offer("1");
        while(!q.isEmpty()) {
            System.out.print(q.poll()+" ");
        }


    }

}


