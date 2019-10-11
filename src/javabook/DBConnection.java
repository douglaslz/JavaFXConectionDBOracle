/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabook;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas.Sierra
 */
public class DBConnection {


public Connection Conect(){

        String user = "douglaslz";
        String pass = "006054";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        Connection conn;
        
        
                    try {
			Class.forName("oracle.jdbc.OracleDriver");
                        conn = DriverManager.getConnection(url, user, pass);
                        return  conn;
                       // System.out.println("Connected");
			//JOptionPane.showMessageDialog(null, "Conexon realizada");
		} catch (ClassNotFoundException |   SQLException e) {
			JOptionPane.showMessageDialog(null, "No se realizo la conexion"+ e);
		}
                    return null;
}


    
}
