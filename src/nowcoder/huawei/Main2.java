package nowcoder.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by ping on 2015/10/9.
 */
public class Main2 {
    public static void printResult(String str) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0;i<str.length();i++) {
            char temp = str.charAt(i);
            if(!set.contains(temp)) {
                System.out.print(temp);
                set.add(temp);
            }
        }
        System.out.println();
    }

    public static void main(String args[]){
        Scanner s =  new Scanner(System.in);
        String str;
        while(s.hasNext())  {
            str = s.nextLine();
            printResult(str);
        }
    }
}
