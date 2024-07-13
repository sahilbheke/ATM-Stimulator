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
public class SignupThree extends JFrame implements ActionListener{
    
    String formno;
    JRadioButton r1, r2, r3, r4;
    JButton submit, cancel;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    
    SignupThree(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("PAGE 3: ACCOUNT DETAILS");
        l1.setBounds(280, 40, 400, 40);
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        add(l1);
        
        JLabel l2 = new JLabel("Account Type");
        l2.setBounds(100, 140, 200, 30);
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(l2);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100, 180, 150, 20);
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350, 180, 250, 20);
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(100, 220, 160, 20);
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350, 220, 250, 20);
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setBounds(100, 300, 200, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4165");
        number.setBounds(330, 300, 300, 30);
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        add(number);
        
        JLabel cardDetail = new JLabel("(Your 16 Digit Card Number)");
        cardDetail.setBounds(100, 330, 300, 20);
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        add(cardDetail);
        
        JLabel pin = new JLabel("Card Number");
        pin.setBounds(100, 370, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pin);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setBounds(330, 370, 300, 30);
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pinNumber);
        
        JLabel pinDetail = new JLabel("(Your 4 Digit Password)");
        pinDetail.setBounds(100, 400, 300, 20);
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        add(pinDetail);
        
        JLabel services = new JLabel("Services Required");
        services.setBounds(100, 450, 400, 30);
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Moble Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS ALerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I Hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100, 680, 600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        add(cancel);
        cancel.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 860);
        setLocation(340, 0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }
            else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                accountType = "Current Account";
            }
            else if(r4.isSelected()){
                accountType = "Reccurring Deposit Account";
            }
            
            Random random = new Random();
            String cardNumber = "" + (Math.abs((random.nextLong() % 1000000000L)) + 5040936000000000L);
            String pinNumber = "" + (Math.abs((random.nextLong() % 1000L)) + 1000L);

            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            }
            if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }
            if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            if(c4.isSelected()){
                facility = facility + " Email & SMS Alerts";
            }
            if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }
            if(c6.isSelected()){
                facility = facility + " E-Statement";
            }
           
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is Required");
                }
                else if(facility.equals("")){
                    JOptionPane.showMessageDialog(null, "At least one Service is Required");
                }
                else{
                    if(c7.isSelected()){
                        Conn c = new Conn();
                        String query = "insert into signUpThree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                        String query2 = "insert into Login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                        c.s.executeUpdate(query);
                        c.s.executeUpdate(query2);
                    
                        JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pinNumber);
                
                        setVisible(false);
                        new Deposit(pinNumber).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please acknowledge");
                    }
                    
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]){
        new SignupThree("");
    }
}
