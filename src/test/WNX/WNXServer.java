package test.WNX;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by qiuping01.wu on 2015/8/24.
 */
public class WNXServer {
    private AtomicLong remain;
    private ConcurrentHashMap history;
    private AtomicLong online;
    private ExecutorService es;
    private volatile boolean flag;

    public WNXServer() {
        this(2000000);
//        this.remain = new AtomicLong(2000000);
//        history = new ConcurrentHashMap();
//        es = Executors.newFixedThreadPool(1000);
//        flag = true;
    }

    public WNXServer(int remain) {
        this.remain = new AtomicLong(remain);
        history = new ConcurrentHashMap();
        online = new AtomicLong(0);
        es = Executors.newCachedThreadPool();
        flag = true;
    }

    public void startServer() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入启动端口:");
        int port = Integer.valueOf(input.readLine());
        ServerSocket server = new ServerSocket(port);
        //ServerSocket server = new ServerSocket(Constants.PORT);
        System.out.println("服务器启动成功............");
        Socket client = null;
        while(flag)
        {
            client =server.accept();
            es.submit(new ServerHandler(client,remain,history,online));
        }
        server.close();
        System.out.println("服务器停止............");
    }
    public void stopServer() throws IOException {
        flag = false;
    }

    public static void main(String args[]) throws IOException {
        new WNXServer().startServer();
    }
}
