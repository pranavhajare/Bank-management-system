package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class signuptwo extends JFrame implements ActionListener{
    
    
    JTextField pan,aadhar ;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    String formno;
    JComboBox religion,category,occupation,education,income;
    
    signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionaldetails = new JLabel("Page 2: Additional details ");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,28));
        additionaldetails.setBounds(290,80,400,35);
        add(additionaldetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,28));
        name.setBounds(100,140,120,30);
        add(name);
        
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christion","Other"};
         religion= new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,28));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
         category= new JComboBox(valCategory);
         category.setBounds(300,190,400,30);
         category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,28));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomeCategory[] = {"NULL","< 150000","< 250000","< 500000","upto 1000000"};
         income= new JComboBox(incomeCategory);
         income.setBounds(300,240,400,40);
         income.setBackground(Color.WHITE);
        add(income);
        
       
        
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,28));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,28));
        email.setBounds(100,320,200,30);
        add(email);
        
         String educationValues[] = {"Non-Graduation","Graduation","Post-Graduation","Doctorate","Others"};
         education= new JComboBox(educationValues);
         education.setBounds(300,320,400,40);
         education.setBackground(Color.WHITE);
        add(education);
        
        JLabel maritalstatus = new JLabel("Occupation:");
        maritalstatus.setFont(new Font("Raleway",Font.BOLD,28));
        maritalstatus.setBounds(100,390,200,30);
        add(maritalstatus);
        
        String occupationValues[] = {"Salaried","elf-employed","Bussinessman","Student","Retired","Others"};
         occupation= new JComboBox(occupationValues);
         occupation.setBounds(300,390,400,40);
         occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
        JLabel address = new JLabel("Pan No:");
        address.setFont(new Font("Raleway",Font.BOLD,28));
        address.setBounds(100,440,200,30);
        add(address);
        
          pan = new JTextField();
        pan.setFont(new Font("Ralleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city = new JLabel("Adhar No:");
        city.setFont(new Font("Raleway",Font.BOLD,28));
        city.setBounds(100,490,200,30);
        add(city);
        
         aadhar = new JTextField();
        aadhar.setFont(new Font("Ralleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state = new JLabel("Senior Citizen");
        state.setFont(new Font("Raleway",Font.BOLD,28));
        state.setBounds(100,540,200,30);
        add(state);
        
         syes= new JRadioButton("Yes");
        syes.setBounds(350,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

         sno= new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        
        JLabel pincode = new JLabel("Existing Account");
        pincode.setFont(new Font("Raleway",Font.BOLD,28));
        pincode.setBounds(100,590,250,30);
        add(pincode);
        
        eyes= new JRadioButton("Yes");
        eyes.setBounds(350,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

         eno= new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(syes);
        emaritalgroup.add(sno);
        
         
        
         next = new JButton("NEXT");
        next.setBounds(620,660,80,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Ralleway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
       
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen= null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
     }else if(sno.isSelected()){
         seniorcitizen="No";
     }
        
        String existingaccount= null;
        if(eyes.isSelected()){
            existingaccount="Yes";
     }else if(eno.isSelected()){
         existingaccount="No";
     }
        
        
        
        String span =pan.getText();
        String saadhar= aadhar.getText();
        
         try{
            
                Conn c= new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"','"+seducation+"', '"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
            
//                signup3 object
             setVisible(false);
            new signupthree(formno).setVisible(true);
        } catch (Exception e){
//            System.out.println("e");
               e.printStackTrace();
        }
       
    }
     
    public static void main(String args[]) {
     new signuptwo(""); 
    }
}
