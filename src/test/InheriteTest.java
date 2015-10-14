package test;

/**
 * Created by ping on 2015/9/16.
 */
class Base  {
    public int f(){return 0;}
}

class Derived extends Base{
    public int f1(){return 0;}

}
public class InheriteTest {
    public static void main()   {
        Base a= new Derived();
    }


}
