package com.thoughtworks.jpetstore;

import com.thoughtworks.jpetstore.domain.Account;

import java.sql.*;

/**
 * Created by coderliu on 3/4/16.
 */
public class JDBCTest {


    public static void main(String[] args) throws Exception {

        // JDBCTest driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/jpetstore";
        //  Database credentials
        final String USER = "petstore";
        final String PASS = "petstore";

        Connection conn = null;
        Statement stmt = null;

        //STEP 1: 注册驱动
        Class.forName(JDBC_DRIVER);
        //STEP 2: 建立连接
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        conn.setAutoCommit(false);

        //STEP 3:创建Statment
        stmt = conn.createStatement();
        //STEP 4:执行操作
        String sql = "SELECT\n" +
                "          ACCOUNT.USERID USERNAME,\n" +
                "          ACCOUNT.EMAIL,\n" +
                "          ACCOUNT.FIRSTNAME,\n" +
                "          ACCOUNT.LASTNAME,\n" +
                "          ACCOUNT.STATUS,\n" +
                "          ACCOUNT.ADDR1 AS address1,\n" +
                "          ACCOUNT.ADDR2 AS address2,\n" +
                "          ACCOUNT.CITY,\n" +
                "          ACCOUNT.STATE,\n" +
                "          ACCOUNT.ZIP,\n" +
                "          ACCOUNT.COUNTRY,\n" +
                "          ACCOUNT.PHONE\n" +
                "    FROM ACCOUNT\n" +
                "    WHERE ACCOUNT.USERID = 'google'";
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()){
            Account account= new Account();
            account.setUserName(resultSet.getString("USERNAME"));
            System.out.println("account userName = [" + account.getUserName() + "]");
        }

        String delete ="delete from student";
        String insertSql1= "insert into student values(1,'liujie')";
        String insertSql2 ="insert into student values(2,'test')";

        //stmt.executeUpdate(delete);
        stmt.executeUpdate(insertSql1);
        stmt.executeUpdate(insertSql2);

        conn.commit();
        //STEP 5: 关闭资源
        try {
            if (stmt != null)
                conn.close();
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
        }

    }

}
