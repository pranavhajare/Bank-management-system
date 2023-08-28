
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class withdrawl extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdrawl,back;
    String pinnumber;
    
    withdrawl(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
         JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,30);
        image.add(text);
        
         amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,20);
        image.add(amount);
        
         withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(350,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         back = new JButton("BACK");
        back.setBounds(350,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawl){
             String number = amount.getText();
             Date date = new Date();
             if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to withdrawl");
                }else{
                 
                 try{
                 Conn conn = new Conn();
                    String query=("insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" withdraw Successfully");
                    conn.s.executeUpdate(query);
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                    }catch(Exception e){
                        System.out.println(e);
                    }

             }
             
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    
    
    public static void main(String args[]) {
        new withdrawl("");
    }
}


