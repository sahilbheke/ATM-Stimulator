/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;
/**
 *
 * @author bheke
 */
public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, signup;
    
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){

        setTitle("Automated Teller Machine");

        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(100, 10, 100, 100);
        add(label);
        
        // Text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(230, 40, 400, 40);
        add(text);
        
        // Card No
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        // PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        // Frame
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 600);
        setVisible(true);
        setLocation(450, 350);
        
        // Buttons
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);


    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == clear){
            
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if(ae.getSource() == login){
            Conn c = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            
            String query = "Select * from login where Card_Number = '"+cardNumber+"' and Pin_Number = '"+pinNumber+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                System.out.print(rs);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrenct Credentials");
                }
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
