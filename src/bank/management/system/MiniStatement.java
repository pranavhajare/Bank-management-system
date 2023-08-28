
package bank.management.system;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement  extends JFrame  {
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);
        
        
        JLabel text=new JLabel();
        text.setBounds(20, 160, 400, 200);
        add(text);
        
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 50);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,50, 300, 80);
        add(card);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,80, 300, 80);
        add(mini);
        
         try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }
        }catch(Exception e){
        System.out.println(e);
        }
        
         
         try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>" +rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            mini.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        setSize(400,600);
        setLocation(20,20);
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        
        
        
    }
    
    
    
   
    public static void main(String args[]) {
       new MiniStatement("");
    }
}
