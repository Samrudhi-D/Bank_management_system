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
public class Transaction extends JFrame implements ActionListener {
   JButton deposit,withdraw,ministatement,pinchange,fastcash,exit,balanceenquiry;
    String pinnumber;
    
    Transaction(String pinnumber){
       this.pinnumber=pinnumber;
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       add(image);
       image.setBounds(0,0,900,900);
       
       JLabel text=new JLabel("Please select your Transaction");
       text.setBounds(210,300,700,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);
       
        deposit=new JButton("Deposit");
       deposit.setBounds(170,415,150,30);
       image.add(deposit);
       deposit.addActionListener(this);
       
        withdraw=new JButton("Cash Withdraw");
      withdraw.setBounds(355,415,150,30);
       image.add(withdraw);
       withdraw.addActionListener(this);
       
        fastcash=new JButton("Fast cash");
      fastcash.setBounds(170,450,150,30);
       image.add(fastcash);
       fastcash.addActionListener(this);
       
        ministatement=new JButton("Mini Statement");
      ministatement.setBounds(355,450,150,30);
       image.add(ministatement);
       ministatement.addActionListener(this);
       
       pinchange=new JButton("Pin Change");
      pinchange.setBounds(170,485,150,30);
       image.add(pinchange);
       pinchange.addActionListener(this);
       
        balanceenquiry=new JButton("Balance Enquiry");
      balanceenquiry.setBounds(355,485,150,30);
       image.add(balanceenquiry);
       balanceenquiry.addActionListener(this);
       
        exit=new JButton("Exit");
     exit.setBounds(355,520,150,30);
       image.add(exit);
       exit.addActionListener(this);


       
       
       setLayout(null);
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
       
       
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
           if(ae.getSource()==exit){
               System.exit(0);
            }else if(ae.getSource()==deposit){
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            }else if(ae.getSource()==withdraw){
               setVisible(false);
               new Withdrawl(pinnumber).setVisible(true);
            
            }else if(ae.getSource()==fastcash){
                 setVisible(false);
                 new FastCash(pinnumber).setVisible(true);
            
            
            }else if(ae.getSource()==pinchange){
                 setVisible(false);
                 new PinChange(pinnumber).setVisible(true);
            
             
            
            }else if(ae.getSource()==balanceenquiry){
                       setVisible(false);
                       new BalanceEnquiry(pinnumber).setVisible(true);
            
            
            
            }else if(ae.getSource()==ministatement){
                
                new MiniStatement(pinnumber).setVisible(true);
            
            
            }
    
    }
    
    
    public static void main(String args[]){
    
    new Transaction(" ");
    
    
    }
    
}
