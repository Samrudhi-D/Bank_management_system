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
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdrawl,back;
    String pinnumber;
    
   Withdrawl (String pinnumber){
       this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text=new JLabel("Enter the amount you want to withdraw");
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       text.setBounds(170,300,400,20);
       image.add(text);
       
       amount=new JTextField();
       amount.setFont(new Font("Raleway",Font.BOLD,22));
       amount.setBounds(170,350,320,20);
       image.add(amount);
       
       withdrawl =new JButton("Withdraw");
       withdrawl.setBounds(355,485,150,30);
       image.add(withdrawl);
       withdrawl.addActionListener(this);
       
       back =new JButton("Back");
       back.setBounds(355,520,150,30);
       image.add(back);
       back.addActionListener(this);
       
       setSize(900,900);
       setLocation(300,0);
       setVisible(true);
   
   }
   public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==withdrawl){
                    String number=amount.getText();
                    Date dt=new Date();
                    if(number.equals("")){
                        JOptionPane.showMessageDialog(null,"Enter the amount you want to withdraw");
                    }else{
                        try{
                         Conn conn=new Conn();
                         String query="Insert into bank values ('"+pinnumber+"','"+dt+"','Withdrawl','"+number+"')";
                         conn.st.executeUpdate(query);
                         JOptionPane.showMessageDialog(null,"Rs "+number+"  Withdrawl Successfully");
                         setVisible(false);
                         new Transaction(pinnumber).setVisible(true);
                        }catch(Exception e){
                            System.out.println(e);
                        
                        
                        }
                    
                    }
          }else if(ae.getSource()==back){
              setVisible(false);
             new Transaction(pinnumber).setVisible(true);
          
          
          }
              
   
   }
    public static void main(String args[]){
           new Withdrawl (" ");
    }
    
    
}

