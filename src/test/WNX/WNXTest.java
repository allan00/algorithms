package test.WNX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qiuping01.wu on 2015/8/24.
 */
public class WNXTest {
        public static void main(String args[]) throws IOException, InterruptedException {
            ExecutorService es = Executors.newCachedThreadPool();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入测试并发线程数:");
            int num = Integer.valueOf(input.readLine());
            System.out.println("请输入服务器ip:");
            String ip = input.readLine();
            System.out.println("请输入服务器端口号:");
            int port = Integer.valueOf(input.readLine());

            for(int i=0;i<num;i++) {
                es.submit(new TestRunnable(ip,port));
            }
        }
}
