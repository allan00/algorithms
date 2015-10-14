package test.WNX;

import java.io.IOException;

/**
 * Created by qiuping01.wu on 2015/8/31.
 */
public class TestRunnable implements Runnable{
    private String ip;
    private int port;

    public TestRunnable(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
        public void run() {
            try {
                new WNXClient(ip,port).startClient();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

}
