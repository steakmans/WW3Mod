package fr.steakmans.ww3mod.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
	
	private Connection conn;
    
    public void connect(String host, int port, String database, String user, String password){
        if(!isConnected()){
            try {
                conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false", user, password);
                System.out.println("Connected my friend");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   
    public void disconnect(){
        if(isConnected()){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   
    public boolean isConnected(){
        try {
            if((conn == null) || (conn.isClosed()) || conn.isValid(5)){
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
   

    public Connection getConnection() {
        return conn;
    }

}
