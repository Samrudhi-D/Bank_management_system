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
public class SignUpTwo extends JFrame implements ActionListener {//Inheritance
    
    JTextField adharTextField,panTextField;
    JButton next;
    JRadioButton syes,sno,eno,eyes;
    JComboBox religion,income,category,education,occupation;
    String formno;
    
    //parametrized Constructor
    SignUpTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");
        
        
        
        
        
        JLabel additionaldetails=new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        JLabel name=new JLabel("Religion: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","other"};
         religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        add(religion);
        religion.setBackground(Color.WHITE);
        
        
        
        String valcategory[]={"General","OBC","ST","Other"};
         category=new JComboBox(valcategory);
        JLabel fname=new JLabel("Category: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        category.setBounds(300,190,400,30);
        add(category);
        category.setBackground(Color.WHITE);
               
        
        String incomeval[]={"Null","<1,50,000","<2,50,000","<5,00,000","up to 10,00,000"};
         income=new JComboBox(incomeval);
        JLabel dob=new JLabel("Income: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
         income.setBounds(300,240,400,30);
        add(income);
        income.setBackground(Color.WHITE);
        
        
        
        JLabel gender=new JLabel("Eductaional ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
        JLabel email=new JLabel("Qualification: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationval[]={"Non Graduation","Graduate","Post Graduation","Doctrate","Others"};
         education=new JComboBox(educationval);
        add(education);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        
        JLabel marital=new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        String occupationval[]={"Salaried","Self Employed","Bussiness","Student","Retired","Others"};
         occupation=new JComboBox(occupationval);
        add(occupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        
        JLabel pan =new JLabel("PAN NO: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel adhar =new JLabel("Adhar NO: ");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(100,490,200,30);
        add(adhar);
        
         adharTextField=new JTextField();
        adharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adharTextField.setBounds(300,490,400,30);
        add(adharTextField);
        
        JLabel senior=new JLabel("Senior Citizen: ");
         senior.setFont(new Font("Raleway",Font.BOLD,20));
          senior.setBounds(100,540,200,30);
        add(  senior);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup CitizenGroup=new ButtonGroup();
        CitizenGroup.add(syes);
        CitizenGroup.add(sno);
        
        
        
        
        
        JLabel account=new JLabel("Existting Account: ");
        account.setFont(new Font("Raleway",Font.BOLD,20));
        account.setBounds(100,590,200,30);
        add(  account);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup AccountGroup=new ButtonGroup();
        AccountGroup.add(eyes);
        AccountGroup.add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
       
        
        
        
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    
        
     
    
   
    }
    public void actionPerformed(ActionEvent et){
                 
                 String sreligion= (String)religion.getSelectedItem();
                 String scategory=(String) category.getSelectedItem();
                  String sincome=(String) income.getSelectedItem();
                  String seducation=(String)education.getSelectedItem();
                  String soccupation=(String)occupation.getSelectedItem();
                  String seniorcitizen="null";
                 if(syes.isSelected()){
                     seniorcitizen="Yes";
                 }
                 else if(sno.isSelected()){
                     seniorcitizen="No";
                 
                 }
                 
                 String saccount=null;
                 if(eyes.isSelected()){
                    saccount="Yes";
                 
                 }
                 else if(eno.isSelected()){
                    saccount="No";
                  
                 }
                 String sadhar=adharTextField.getText();
                 String span=adharTextField.getText();
                 
                 
                 try{
                    if(sreligion.equals("")&&scategory.equals("")&&sincome.equals("")&&seducation.equals("")&&sadhar.equals("")&&span.equals("")&&soccupation.equals("")&&seniorcitizen.equals("")&&saccount.equals(" ")){
                         JOptionPane.showMessageDialog(null,"Please fill all the fields!!");
                    }
                    else{
                        Conn c=new Conn();
                        String query="Insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+seducation+"','"+sincome+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+saccount+"')";
                        c.st.executeUpdate(query);
                        
                        
                        JOptionPane.showMessageDialog(null,"Data Inserted Successfully!!");
                        setVisible(false);
                        new SignUpThree(formno).setVisible(true);
                    }
                 
                 
                 }catch(Exception e){
                    System.out.print(e);
                 
                 
                 }
    
    }
    public static void main(String[] args){
        new SignUpTwo(" ");
    
    }
    
}