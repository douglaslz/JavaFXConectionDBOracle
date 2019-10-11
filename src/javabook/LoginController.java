/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabook;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Douglas.Sierra
 */
public class LoginController implements Initializable {
private DBConnection dc;
    Statement stm;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnEnter;
    @FXML
    private Button btnExit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dc = new DBConnection();
    }    
    
    
    
    @FXML
    private void Search(ActionEvent event) throws IOException {
        
    Connection conn;
        conn = dc.Conect();
        
    
        try {
            ResultSet rs= conn.createStatement().executeQuery("select * from Users where USERID = '"+txtUser.getText()+"' and PASSWORD = '"+txtPassword.getText()+"' ");
            if(rs.next()){
                
           final Node source = (Node) event.getSource();
           final Stage stage1 = (Stage) source.getScene().getWindow();
           stage1.close();
        
        //Platform.exit();
        
    FXMLLoader fxmlLoader = new 
    FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    
    
    //set what you want on your stage
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Report Page");
    stage.setScene(new Scene(root1));
    stage.setResizable(false);
    stage.show();
             
             }else{
             
             
               JOptionPane.showMessageDialog(null, "User or Password is incorrect");
               txtUser.setText("");
               txtPassword.setText("");
               
             }
           
        } catch (SQLException ex) {
           
        }

    }
    
    private void Exit(ActionEvent event) throws IOException {
    final Node source = (Node) event.getSource();
    final Stage stage1 = (Stage) source.getScene().getWindow();
    stage1.close();
        
        //Platform.exit();
        
    FXMLLoader fxmlLoader = new 
    FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    
    
    
    //set what you want on your stage
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Report Page");
    stage.setScene(new Scene(root1));
    stage.setResizable(false);
    stage.show();
    
    
    
    }
    
    public void Exit2(ActionEvent event) throws IOException {
    
    
    Platform.exit();
    }
    
    
    
}
