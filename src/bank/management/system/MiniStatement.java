
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    String pinNumber;
    
    MiniStatement(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Smart Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel("");
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel("");
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from login where Pin_Number = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("Card_Number").substring(0, 4) + "XXXXXXXX" + rs.getString("Card_Number").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bank where Pin_Number = '"+pinNumber+"'");
            int bal = 0;
            
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  rs.getString("Amount") + "<br><br><html>");
                if(rs.getString("Type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("Amount"));
                }
                else if(rs.getString("Type").equals("Withdrawl")){
                    bal -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            balance.setText("Your Current Account Balance is: " + bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20, 140, 400, 200);
        
        setVisible(true);
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
