/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{

    JTextField pan, aadhar;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    JComboBox religionChooser, categoryChooser, occupationChooser, educationChooser, incomeChooser;
    String formno;
    
    SignupTwo (String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
       
        // Frame
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
     
        //Personal Deatils
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        //Name
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christan", "Other"};
        religionChooser = new JComboBox(valReligion);
        religionChooser.setBounds(300, 140, 400, 30);
        religionChooser.setBackground(Color.WHITE);
        add(religionChooser);
 
        //Father name
        JLabel category = new JLabel("Categroy:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryChooser = new JComboBox(valcategory);
        categoryChooser.setBounds(300, 190, 400, 30);
        categoryChooser.setBackground(Color.WHITE);
        add(categoryChooser);
        
        //Income
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        
        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomeChooser = new JComboBox(incomecategory);
        incomeChooser.setBounds(300, 240, 400, 30);
        incomeChooser.setBackground(Color.WHITE);
        add(incomeChooser);
        
        //Education Qualification
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);
        
        String educationValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        educationChooser = new JComboBox(educationValues);
        educationChooser.setBounds(300, 315, 400, 30);
        educationChooser.setBackground(Color.WHITE);
        add(educationChooser);
        
        // Occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Other"};
        occupationChooser = new JComboBox(occupationValues);
        occupationChooser.setBounds(300, 390, 400, 30);
        occupationChooser.setBackground(Color.WHITE);
        add(occupationChooser); 
        
        // PAN Number
        JLabel panNumber = new JLabel("PAN Number:");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        panNumber.setBounds(100, 440, 200, 30);
        add(panNumber);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        //Aadhar Number
        JLabel aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNumber.setBounds(100, 490, 200, 30);
        add(aadharNumber);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        //Senior Citizen
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
      
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);
        
        
        // Existing Account
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 200, 30);
        add(existingAccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
      
        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);
        
        next = new JButton("NEXT");
        
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sReligion = (String)religionChooser.getSelectedItem();
        String sCategory = (String)categoryChooser.getSelectedItem();
        String income = (String)incomeChooser.getSelectedItem();
        String sEducation = (String)educationChooser.getSelectedItem();
        String Soccupation = (String)occupationChooser.getSelectedItem();
        
        String seniorCitizen = null;
        
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        } else if(sno.isSelected()){
            seniorCitizen = "No";
        }

        String existingAccount = null;
        
        if(eyes.isSelected()){
            existingAccount = "Yes";
        }else if(eno.isSelected()){
            existingAccount = "Unmarrid";
        }
        
        String sPan = pan.getText();
        String sAadhar = aadhar.getText();
        
        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sReligion+"' , '"+sCategory+"', '"+income+"', '"+sEducation+"', '"+Soccupation+"', '"+sPan+"', '"+sAadhar+"', '"+seniorCitizen+"','"+existingAccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
     
    public static void main(String args[]){
        new SignupTwo("");
    }
}
