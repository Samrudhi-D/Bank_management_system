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
public class PinChange extends JFrame implements ActionListener {
    JButton back,change;
        JPasswordField pin,repin;
        String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        
        
        
      setLayout(null);
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(0,0,900,900);
      add(image);
      
      JLabel text=new JLabel("CHANGE YOUR PIN");
      text.setForeground(Color.WHITE);
      text.setFont(new Font("Raleway",Font.BOLD,16));
      text.setBounds(250,280,500,35);
      image.add(text);
      
       JLabel pintext=new JLabel("New PIN:");
      pintext.setForeground(Color.WHITE);
      pintext.setFont(new Font("Raleway",Font.BOLD,16));
      pintext.setBounds(165,320,180,25);
      image.add(pintext);
      
       pin =new JPasswordField();
      pin.setFont(new Font("Raleway",Font.BOLD,16));
      pin.setBounds(330,320,180,25);
      image.add(pin);
      
      JLabel repintext=new JLabel("Re-Enter New PIN:");
      repintext.setForeground(Color.WHITE);
      repintext.setFont(new Font("Raleway",Font.BOLD,16));
      repintext.setBounds(165,360,180,25);
      image.add(repintext);
      
       repin =new JPasswordField();
      repin.setFont(new Font("Raleway",Font.BOLD,16));
      repin.setBounds(330,360,180,25);
      image.add(repin);
      
      change=new JButton("CHANGE");
      change.setBounds(355,485,150,30);
      image.add(change);
      change.addActionListener(this);
      
      
        back=new JButton("BACK");
      back.setBounds(355,520,150,30);
      image.add(back);
      back.addActionListener(this);
      
    
      
      
      
      setSize(900,900);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);
      
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
               try{
                   
                   String npin=pin.getText();
                   String rpin=repin.getText();
                   
                   if(!npin.equals(rpin)){
                       
                       JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                       return;
                   
                   
                   }
                   
                   if(npin.equals("")){
                   
                   JOptionPane.showMessageDialog(null,"Plese enter PIN");
                   return;
                   
                   }
                   if(rpin.equals("")){
                   
                   JOptionPane.showMessageDialog(null,"Plese Re-enter new PIN");
                   return;
                   
                   }
                   
                   Conn con=new Conn();
                   String query1="Update bank set pin= '"+rpin+"' where pin='"+pinnumber+"'";
                   String query2="Update login set pin= '"+rpin+"' where pin='"+pinnumber+"'";
                   String query3="Update signupthree set pinnumber= '"+rpin+"' where pinnumber='"+pinnumber+"'";
                   con.st.executeUpdate(query1);
                    con.st.executeUpdate(query2);
                    con.st.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null,"PIN changes Successfully");
                    setVisible(false);
                    new Transaction(rpin).setVisible(true);
               }catch(Exception e){
               
                    System.out.print(e);
               
               
               }
        }else{
         setVisible(false);
         new Transaction(pinnumber).setVisible(true);
        
        
        
        }
    
    
    }
    
    public static void main(String args[]){
             new PinChange("").setVisible(true);
    
    
    }
    
}
