package test;
public class Demo2 {
     public void swap(StringBuffer a,StringBuffer b){
            StringBuffer c = a;
            a=b.append("hahahaha");
            b=c;
         System.out.println("swap: a="+a+",b="+b);
     }
   public static void main(String[] args) {
      StringBuffer a = new StringBuffer("a");
      StringBuffer b = new StringBuffer("b");
      System.out.println("swap: a="+a.hashCode()+",b="+b.hashCode());
      Demo2 demo2 = new Demo2();
      demo2.swap(a, b);
      System.out.println("main: a="+a+",b="+b);
   }
}