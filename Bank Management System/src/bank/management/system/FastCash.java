/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/**
 *
 * @author Samrudhi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {
   JButton hundred,fivehundred,thousand,twothousand,fivethousand,back,tenthousand;
    String pinnumber;
    
    FastCash(String pinnumber){
       this.pinnumber=pinnumber;
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       add(image);
       image.setBounds(0,0,900,900);
       
       JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
       text.setBounds(210,300,700,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);
       
        hundred=new JButton("Rs 100");
      hundred.setBounds(170,415,150,30);
       image.add(hundred);
       hundred.addActionListener(this);
       
        fivehundred=new JButton("Rs 500");
      fivehundred.setBounds(355,415,150,30);
       image.add(fivehundred);
       fivehundred.addActionListener(this);
       
        thousand=new JButton("Rs 1000");
      thousand.setBounds(170,450,150,30);
       image.add(thousand);
       thousand.addActionListener(this);
       
        twothousand=new JButton("Rs 2000");
      twothousand.setBounds(355,450,150,30);
       image.add(twothousand);
       twothousand.addActionListener(this);
       
       fivethousand=new JButton("Rs 5000");
      fivethousand.setBounds(170,485,150,30);
       image.add(fivethousand);
       fivethousand.addActionListener(this);
       
        tenthousand=new JButton("Rs 10000");
      tenthousand.setBounds(355,485,150,30);
       image.add(tenthousand);
       tenthousand.addActionListener(this);
       
        back=new JButton("Back");
     back.setBounds(355,520,150,30);
       image.add(back);
       back.addActionListener(this);


       
       
       setLayout(null);
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
       
       
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
           if(ae.getSource()==back){
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
           }else{
               String amount=((JButton)ae.getSource()).getText().substring(3);
               Conn con=new Conn();
               try{
                   
                   ResultSet rs=con.st.executeQuery("Select * from bank where pin= '"+pinnumber+"'");
                   int balance=0;
                   while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                             balance+=Integer.parseInt(rs.getString("amount"));
                       
                       
                       }else{
                          balance-=Integer.parseInt(rs.getString("amount"));
                       }
               }
                   
                   if(ae.getSource()!=back && balance< Integer.parseInt(amount)){
                   
                      JOptionPane.showMessageDialog(null, "Insufficient balance");
                      return;
                   
                   }
                   
                   Date date=new Date();
                   String query="Insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                   con.st.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"Rs "+ amount+" Debited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                   
               
               
               }catch(Exception e){
                    System.out.println(e);
               
               
               }
           
           }
    
    }
    
    
    public static void main(String args[]){
    
    new FastCash(" ");
    
    
    }
    
}
