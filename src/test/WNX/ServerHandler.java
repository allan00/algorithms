package test.WNX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by qiuping01.wu on 2015/8/24.
 */
public class ServerHandler implements Runnable{
    private Socket client;
    private AtomicLong remain;
    private ConcurrentHashMap history;
    AtomicLong online;

    public ServerHandler(Socket client,AtomicLong remain,ConcurrentHashMap history,AtomicLong online) {
        this.client = client;
        this.remain = remain;
        this.history = history;
        this.online = online;
    }

    private boolean IsNum(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

    public void run()
    {
        online.incrementAndGet();
        System.out.print("客户端"+client.getInetAddress()+"连接成功");
        System.out.println("                  当前在线人数：" + online.longValue());
        try{
            //获取Socket的输出流，用来向客户端发送数据
            PrintStream out = new PrintStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从客户端发送过来的数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag =true;
            while(flag){
                //接收从客户端发送过来的数据
                String str =  buf.readLine();
                if("bye".equals(str)){
                    flag = false;
                }
                else if(IsNum(str)){
                    Long amount = Long.valueOf(str);
                    remain.addAndGet(-amount);
                    Date date=new Date();
                    DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String time=format.format(date);
                    history.put(str,time);
                    out.println("购买成功:" + amount + "  ,可购金额" + remain.longValue());
                }
                else{
                    out.print("输入非法，连接断开");
                    flag = false;
                }
            }
            out.close();
            client.close();
            System.out.println("客户端" + client.getInetAddress() + "停止");

        }catch(Exception e){
            e.printStackTrace();
        }
        online.decrementAndGet();
    }
}
