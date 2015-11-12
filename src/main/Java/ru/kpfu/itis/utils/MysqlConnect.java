package ru.kpfu.itis.utils;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

class MySQLConnect {
    public Connection connect;
    private Statement statement;
    public static MySQLConnect db;
    private MySQLConnect() {
        String url = "jdbc:mysql:localhost3306/";
        String dbName = "servlet_db";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1234";

        try {
            Class.forName(driver).newInstance();
            this.connect = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized MySQLConnect getDBConnect() {
        if (db == null) {
            db = new MySQLConnect();
        }
        return db;
    }

}
