package test.connectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ping on 2015/9/10.
 */
public class test {
    public static void main(String args[]) throws SQLException {
        test1();
        test2();
        
    }
    
    //使用Statement查询
    public static void test1() throws SQLException	{
    	Connection conn = JdbcUtil.getConnection();
        String sql = "select * from table_user";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }

        JdbcUtil.release(conn,st,rs);
    }
    
    //使用PreparedStatement查询
    public static void test2() throws SQLException	{
    	Connection conn = JdbcUtil.getConnection();
        String sql = "select * from table_user";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }

        JdbcUtil.release(conn,st,rs);
    }
}
