package test;

/**
 * Created by ping on 2015/10/12.
 */
class A{
    public void FUN(){
        System.out.println("FUN in A is called");
    }
}
class B extends A{
    public void FUN(){
        System.out.println("FUN in B is called");
    }
}
public class VirtualTest {

    public static void main(String args[])  {
        A a = new A();
        B b = new B();
        A p;

        p = a;
        p.FUN();
        p = b;
        p.FUN();
    }
}
