
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class fastcash extends JFrame implements ActionListener {
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    
    
    fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);        
        add(image);
        
        JLabel text = new JLabel ("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
         deposit = new JButton("RS 100");
         deposit.setBounds(170,415,150,25);
         deposit.addActionListener(this);
         image.add(deposit);
         
          withdrawl = new JButton("RS 500");
         withdrawl.setBounds(355,415,150,25);
         withdrawl.addActionListener(this);
         image.add(withdrawl);
         
           fastcash = new JButton("RS 1000");
         fastcash.setBounds(170,450,150,25);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
          ministatement = new JButton("RS 2000");
         ministatement.setBounds(355,450,150,25);
         ministatement.addActionListener(this);
         image.add(ministatement);
         
          pinchange = new JButton("RS 5000");
         pinchange.setBounds(170,485,150,25);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
          balanceenquiry = new JButton("RS 10000");
         balanceenquiry.setBounds(355,485,150,25);
         balanceenquiry.addActionListener(this);
         image.add(balanceenquiry);
         
          exit = new JButton("BACK");
         exit.setBounds(355,520,150,25);
         exit.addActionListener(this);
         image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated (true);
        setVisible(true);
       }
    
    
     public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";
            if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == exit) {
                this.setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

    public static void main(String args[]) {
       new fastcash("").setVisible(true);
    }
}

 