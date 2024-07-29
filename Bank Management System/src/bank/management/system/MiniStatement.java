/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/**
 *
 * @author Samrudhi
 */
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame {
    
    
    MiniStatement(String pinnumber){
       
       setLayout(null);
       setTitle("Mini Statement");
       
       JLabel mini=new JLabel();
       add(mini);
       
       JLabel bank=new JLabel("Indian Bank");
       bank.setBounds(150,20,100,20);
       add(bank);
       
       JLabel card=new JLabel();
       card.setBounds(20,80,300,20);
       add(card);
       
       JLabel balance=new JLabel();
       balance.setBounds(20,400,300,20);
       add(balance);
       
       
       
       try{
           Conn con=new Conn();
           ResultSet rs=con.st.executeQuery("Select * from login where pin='"+pinnumber+"'");
           while(rs.next()){
               card.setText("Card Number :"+rs.getString("cardnumber").substring(0,5)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
           
           
           }
       
       }catch(Exception e){
       
          System.out.println(e);
       
       }
       
       try{
           
           Conn con=new Conn();
           int bal=0;
           ResultSet rs=con.st.executeQuery("Select * from bank where pin='"+pinnumber+"'");
           while(rs.next()){
              mini.setText(mini.getText()+ "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
              if(rs.getString("type").equals("Deposit"))
               {
                     bal+=Integer.parseInt(rs.getString("amount"));
                       
                       
                }else
                {
                     bal-=Integer.parseInt(rs.getString("amount"));
                 }
           }
           balance.setText("Your Current Account Balance is Rs "+bal);
       
       }catch(Exception e){
         System.out.print(e);
       
       }
       
       mini.setBounds(20,140,400,200);
       
       setSize(400,600);
       setLocation(20,20);
       getContentPane().setBackground(Color.WHITE);
       setVisible(true);
       
       
       
       
       
       
      
    
    }
    
    public static void main(String args[]){
       new MiniStatement("");
    }
    
}
