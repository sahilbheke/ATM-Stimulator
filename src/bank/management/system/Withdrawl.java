/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author bheke
 */
public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amountTextFeild;
    JButton withdraw, back;
    String pinNumber;
            
    Withdrawl(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0 , 900, 900);
        add(image);
        
        // Deposit
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
        amountTextFeild = new JTextField();
        amountTextFeild.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTextFeild.setBounds(175, 350, 320, 25);
        image.add(amountTextFeild);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(260, 390, 140, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 140, 25);
        back.addActionListener(this);
        image.add(back);
        
        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        
        String amount = amountTextFeild.getText();
   
        
        if(ae.getSource() == withdraw){
            long numericAmount = 1;
            Date date = new Date();
            
            try{
                numericAmount = Long.parseLong(amount); 
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Enter valid amount between Rs1 to Rs100000");
            }
            
            if(numericAmount < 1 || numericAmount > 100000){
                JOptionPane.showMessageDialog(null, "Enter valid amount between Rs1 to Rs100000");
            }else{
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', '"+"Withdraw"+"', '"+amount+"')";
                    c.s.executeUpdate(query); 
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdraw Successfully");
                    
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.print(e);
                }  
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }    
}
