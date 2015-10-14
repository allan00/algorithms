package test;

import java.sql.Connection;

public class TestConnectionPool {
    public static void main(String[] args) {
        SimpleConnetionPool.setUrl("jdbc:mysql://localhost:3306/gszxglzx");
        SimpleConnetionPool.setUser("root");
        SimpleConnetionPool.setPassword("root");

        Connection con = SimpleConnetionPool.getConnection();
        Connection con1 = SimpleConnetionPool.getConnection();
        Connection con2 = SimpleConnetionPool.getConnection();

//do something with con ...  

        try {
            con.close();
        } catch (Exception e) {
        }

        try {
            con1.close();
        } catch (Exception e) {
        }

        try {
            con2.close();
        } catch (Exception e) {
        }

        con = SimpleConnetionPool.getConnection();
        con1 = SimpleConnetionPool.getConnection();
        try {
            con1.close();
        } catch (Exception e) {
        }

        con2 = SimpleConnetionPool.getConnection();
        SimpleConnetionPool.printDebugMsg();

    }
} 