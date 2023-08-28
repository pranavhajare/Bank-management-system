
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class pinchange extends JFrame implements ActionListener {
    
        JPasswordField  pin, repin;
        JButton change,back;
        String pinnumber;
        
         pinchange(String pinnumber){
            this.pinnumber= pinnumber;
             
             setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250,235,500,35);
        image.add(text);
        
        JLabel pintext = new JLabel("New Pin");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165,280,180,25);
        image.add(pintext);
        
         repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330,280,180,15);
        image.add(repin);
       
        
        JLabel repintext = new JLabel("Re-enter New Pin");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165,320,180,25);
        image.add(repintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330,320,180,15);
        image.add(pin);
        
        
        change = new JButton("CHANGE");
        change.setBounds(355,480,150,35);
        change.addActionListener(this);
        image.add(change);
         
         
        back = new JButton("BACK");
        back.setBounds(355,530,150,35);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
         }
         
         
         public void actionPerformed(ActionEvent ae){
             try{        
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==change){
                if (pin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (pin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==back){
                new Transactions(pinnumber).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
         
    
    public static void main(String args[]) {
       new pinchange("").setVisible(true);
}
}
