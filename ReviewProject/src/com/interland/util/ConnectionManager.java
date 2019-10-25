package com.interland.util;

import java.sql.*;
import com.mysql.jdbc.Connection;

public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection(){
     
      try{
         String url = "jdbc:mysql://localhost:3306/new"; 
        
         Class.forName("com.mysql.jdbc.Driver");
         
         try{            	
            con = (Connection) DriverManager.getConnection(url,"root","admin");   
         }catch (SQLException ex){
            ex.printStackTrace();
         }
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
      
      return con;
   }
}
