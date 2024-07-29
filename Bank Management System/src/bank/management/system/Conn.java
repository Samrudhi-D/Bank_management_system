/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.sql.*;

/**
 *
 * @author Samrudhi
 */
public class Conn {
      Connection con;
      Statement st;
    
      public Conn() {
      try{

             Class.forName("com.mysql.cj.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Sam@123");
              st=con.createStatement();

      }catch(Exception e)
      {

            System.out.println(e);
      }
   
    
}
}
