package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDBConnection {
        
    String Host = ""; //Thông tin host của Database server mình connect tới
    String UserName = "";   
    String Database = "";
    String Password = "";
    //String url = "jdbc:mysql://localhost:3306/test";
    
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public MyDBConnection() {}
    
    public MyDBConnection(String Host, String UserName, String Password, String Database) 
    {
        this.Host = Host;
        this.UserName = UserName;
        this.Password = Password;
        this.Database = Database;
    }     
     
    public void driverTest() throws Exception 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("MySQL Driver JDBC not found");
        }
    }

    public Connection getConnection() throws Exception 
    {
        if (this.conn == null) 
        {
            driverTest();
            String url = "jdbc:mysql://" + this.Host + ":3306/" + this.Database
                            + "?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
            try{                
                this.conn = DriverManager.getConnection(url, this.UserName, this.Password);                
            }catch (SQLException e){                
                throw new Exception("Không thể kết nối với MySQL server " + e);              
            }
        }
        return this.conn;
    }

    protected Statement getStatement() throws Exception 
    {        
        if (this.st == null ? true : this.st.isClosed()) 
        {           
            this.st = this.getConnection().createStatement();
        }
        
        return this.st;
    }

    public ResultSet excuteQuery(String query) throws Exception 
    {      
        try {           
            this.rs = getStatement().executeQuery(query);
        }catch(Exception e) {
            
            throw new Exception("Error : " + e.getMessage());
        }
           
        return this.rs;
    }

    public int executeUpdate(String query) throws Exception 
    {
        int res = Integer.MIN_VALUE;
        
        try{
            res = getStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new Exception("Error" + e);
        } finally {			
            this.Close();
        }
        
        return res;
    }
	
    public void Close() throws Exception 
    {
        if (this.rs != null && !this.rs.isClosed()){
            this.rs.isClosed();
            this.rs = null;
        }
        
        if (this.st != null && !this.st.isClosed()){
            this.st.isClosed();
            this.st = null;
        }
        
        if (this.conn != null && !this.conn.isClosed()){
            this.conn.isClosed();
            this.conn = null;
        }       
    }    
}