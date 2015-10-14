package test;

/**
 * Created by qiuping01.wu on 2015/8/14.
 */
public class HelloSougou {
    public static synchronized void main(String[] a)
    {
        Thread t = new Thread()
        {
            public void run()
            {Sougou();}
        };
        t.run();
        System.out.print("Hello");
    }
    static synchronized void Sougou()
    {
        System.out.print("Sougou");
    }
}
