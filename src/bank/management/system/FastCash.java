 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
/**
 *
 * @author bheke
 */
public class FastCash extends JFrame implements ActionListener{
    
    JButton hundred, fivehundred, thousand, twothousand, fivethousand, tenthousand, back;
    String pinNumber;
    
    FastCash(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(170, 415, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(355, 415, 150, 30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(170, 450, 150, 30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twothousand = new JButton("Rs 2000");
        twothousand.setBounds(355, 450, 150, 30);
        twothousand.addActionListener(this);
        image.add(twothousand);
        
        fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(170, 485, 150, 30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);
        
        tenthousand = new JButton("Rs 10000");
        tenthousand.setBounds(355, 485, 150, 30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        back.addActionListener(this);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true); 
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            int balance = 0;
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from bank where Pin_Number = '"+pinNumber+"'");
                while(rs.next()){
                    if(rs.getString("Type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }
                    else if(rs.getString("Type").equals("Withdrawl")){
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
                System.out.println(balance);
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");                 
                    return;
                }
                
                Date date = new Date(); 
                
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
}
