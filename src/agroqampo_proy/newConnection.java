/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroqampo_proy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class newConnection {
    public static Connection getConnection(){
    Connection cn = null;
    
    try {
     Class.forName("com.mysql.cj.jdbc.Driver");
     
     cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maxcaribe","root","Darlenys26");
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println(ex.getMessage ());
    }
    
    return cn;
    
    
    }

    
}
