/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.sql.*;
/**
 *
 * @author bheke
 */
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        // for catching run time errors because database is external entity
        try{
//            Driver register when not using mysql connector
//            Class.forName(com.mysql.cj.jdbc.Driver);
            
//          Creating connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartbank", "root", "1234");
            
//          Creating statement
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
