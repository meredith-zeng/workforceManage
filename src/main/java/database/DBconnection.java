package database;

import java.sql.*;
/**
 * 封装好JDBC的connection以供dao使用
 * **/
public class DBconnection {


    private static final String URL="jdbc:mysql://localhost:3306/emp_sys?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "199811";




    public static Connection getConnection()  {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
