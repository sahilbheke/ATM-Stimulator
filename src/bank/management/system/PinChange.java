/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author bheke
 */
public class PinChange extends JFrame implements ActionListener{
    
    String pinNumber;
    JPasswordField repin, pin;
    JButton change, back;
            
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        // NEW PIN
        JLabel pintext = new JLabel("New Pin:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 330, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 330, 180, 25);
        image.add(pin);
        
        // Re-Enter NEW PIN
        JLabel repintext = new JLabel("Re-Enter New Pin:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 370, 180, 25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 370, 180, 25);
        image.add(repin);
        
        // Buttons
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == change){
            try{
                String npin = pin.getText();
                String nrepin = repin.getText();
        
                if(!npin.equals(nrepin)){
                    JOptionPane.showMessageDialog(null, "Pin did not match");  
                    return;
                }  
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");  
                    return;
                }
                if(nrepin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");  
                    return;
                }
                
                Conn c = new Conn();
                String query1 = "update bank set Pin_Number = '"+nrepin+"' where Pin_Number = '"+pinNumber+"'";
                String query2 = "update login set Pin_Number = '"+repin+"' where Pin_Number = '"+pinNumber+"'";
                String query3 = "update signUpThree set Pin_Number = '"+repin+"' where Pin_Number = '"+pinNumber+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transaction(nrepin).setVisible(true);
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new  PinChange("").setVisible(true);
    }
}
