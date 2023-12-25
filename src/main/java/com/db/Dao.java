package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    static String url="jdbc:mysql://127.0.0.1:3306/online_examination";
    static String uname="root";
    static String pass="Hydrogen";
    static Connection con = null;
    public static Connection getCon() {
       if(con==null){
           try {
               Class.forName("com.mysql.jdbc.Driver") ;
           } catch (ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
           try {
               con= DriverManager.getConnection(url, uname, pass);
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
       return con ;
    }
}
