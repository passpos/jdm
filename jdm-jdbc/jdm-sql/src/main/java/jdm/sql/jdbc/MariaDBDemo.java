/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.sql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class MariaDBDemo {

    // JDBC 驱动名
    static final String JDBC_DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    static final String JDBC_DRIVER_MARIADB = "org.mariadb.jdbc.Driver";
    static final String JDBC_DRIVER_SQLITE = "org.sqlite.JDBC";

    // 数据库链接（java不识别大写的盘符“E:”）
    static final String MYSQL_URL = "jdbc:mysql://localhost:3308/a01";
    static final String MARIADB_URL = "jdbc:mariadb://localhost:3308/jdm_jdbc";
    static final String SQLITE_URL = "jdbc:sqlite://d:/tim.db";

    //  数据库认证信息
    static final String USER = "a01";
    static final String PASS = "a01";

    // 用到的连接实例
    private Connection conn = null;
    private Statement stmt = null;

    // SQL语句
    private String sql1 = "INSERT INTO employees VALUES (100, 18, 'Zara', 'Ali')";
    private String sql2 = "INSERT INTO employees VALUES (101, 25, 'Mahnaz', 'Fatma')";
    private String sql3 = "INSERT INTO employees VALUES (102, 30, 'Zaid', 'Khan')";
    private String sql4 = "INSERT INTO employees VALUES (103, 28, 'Sumit', 'Mittal')";

    public static void main(String[] args) {
        MariaDBDemo jdbcDemo = new MariaDBDemo();
        jdbcDemo.getConnection();
    }

    public void getConnection() {
        try {
            //STEP 1: 注册 JDBC driver
            Class.forName(JDBC_DRIVER_MARIADB);

            //STEP 2: 打开一个数据库连接
            System.out.println("正在连接到数据库...");
            conn = DriverManager.getConnection(MYSQL_URL, USER, PASS);

            //STEP 3: 执行SQL语句（通过Connection实例）
            ol("创建SQL语句...");
            stmt = conn.createStatement();

            execQuery();
        } catch (SQLException | ClassNotFoundException se) {
            // 处理 JDBC 与 Class.forName 错误
            ol(se.getMessage());
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se2) {
            }
        }
        ol("再见！");
    }

    public void execQuery() throws SQLException {

        stmt.execute(sql1);
        stmt.execute(sql2);
        stmt.execute(sql3);
        stmt.execute(sql4);

        String sql5 = "SELECT id, first_name, last_name, age FROM employees";
        try ( ResultSet rs = stmt.executeQuery(sql5)) {
            //STEP 4: 从结果集展开数据
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");

                // 展示数值
                o("ID: " + id);
                o(", Age: " + age);
                o(", First: " + first);
                o(", Last: " + last);
            }
            //STEP 5: 清理环境
        }
        stmt.close();
        conn.close();
    }

    public static <T> void o(T arg) {
        System.out.println(arg + "\t");
    }

    public static <T> void ol(T arg) {
        System.out.println(arg);
    }
}
