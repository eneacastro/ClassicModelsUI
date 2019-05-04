/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddbbclassicmodel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Guillem
 */
public class ConexionMySQL {
    
    public String bd;
    public String login;
    public String password;
    public String url;

    public Connection conectar(){
        bd="db_classicmodels_tuned";
        login="employee";
        password="Pwd12345.";
        url="jdbc:mysql://localhost:3306/"+bd;
        
        Connection link=null;    
        try {
            //Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(this.url,this.login,this.password);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;   
    }
    
     public Connection conectarCustomer(){
        bd="db_classicmodels_tuned";
        login="customer";
        password="pwd123";
        url="jdbc:mysql://localhost/"+bd;
        
        Connection link=null;    
        try {
            //Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(this.url,this.login,this.password);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
     return link;   
    }
    
    
    
    
    
    
    
    
}
