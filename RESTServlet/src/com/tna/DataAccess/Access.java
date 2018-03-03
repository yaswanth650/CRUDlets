/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tna.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tareq
 */
public class Access {

    public static Access access = Access.getInstance();
    public static Connection connection = Access.connect();
    public static String host = "localhost:3306";
    public static String database = "test";
    public static String username = "root";
    public static String password = "pass1234";

    public static Access getInstance() {
        if (access == null) {
            return new Access();
        } else {
            return access;
        }
    }
    
    
    public static Connection connect() {
        if(Access.connection == null){
            
              System.out.println("no connection");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String uri = "jdbc:mysql://" + Access.host + "/" + Access.database + "?" + "user=" + Access.username + "&password=" + Access.password + "";
                System.out.println(uri);
                Access.connection = DriverManager.getConnection(uri);

            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("fail");
                Access.connection = null;
            }
            
        }
        System.out.println("connected");
        return Access.connection;
    }

    protected Access(){
    
    }
      


}
