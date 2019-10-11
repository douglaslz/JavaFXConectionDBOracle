
package javabook;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Douglas.Sierra
 */
public class FXMLDocumentController3 implements Initializable {

    private DBConnection dc;
    Statement stm;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnSearch;
    @FXML private TextField txt_Quantity;
    @FXML private TextField txt_Id;
    @FXML private TextField txt_Author;
    @FXML private TextField txt_Genre;
    @FXML private TextField txt_Price;
    @FXML private TextField txt_Tittle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   dc = new DBConnection();
    }    

    @FXML
    private void Search(ActionEvent event) {
        
    Connection conn;
        conn = dc.Conect();
    
        try {
            ResultSet rs= conn.createStatement().executeQuery("select * from Book where id = '"+Integer.parseInt(txt_Id.getText())+"' ");
            while(rs.next()){
                
                txt_Tittle.setText(rs.getString(2));
                txt_Author.setText(rs.getString(3));
                txt_Genre.setText(rs.getString(4));
                txt_Price.setText(rs.getString(5));
                txt_Quantity.setText(rs.getString(6));
               
            }
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Record was not found" + ex);
        }

    }
    
     @FXML
    private void Insert(ActionEvent event) {

        Connection conn;
        conn = dc.Conect();
        
        	int r;
		String cadSql;
		

		try {
                        stm = conn.createStatement();
			cadSql = "insert into Book values ('" + Integer.parseInt(txt_Id.getText()) + "', '" + txt_Tittle.getText()+ "','" + txt_Author.getText() + "','" + txt_Genre.getText() + "','" + Double.parseDouble(txt_Price.getText()) + "','" + Integer.parseInt(txt_Quantity.getText()) + "')";
			r = stm.executeUpdate(cadSql);
			JOptionPane.showMessageDialog(null, r + " The record was added");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The record was not added" + e);
		}
                Clean();
    }
    
    @FXML
    private void Update(ActionEvent event) {
        
        Connection conn;
        conn = dc.Conect();
        
        	int r;
		String cadSql;
		

		try {
                        stm = conn.createStatement();
			cadSql = "UPDATE Book SET Tittle = '" + txt_Tittle.getText()+ "', Author = '" + txt_Author.getText() + "',Genre = '" + txt_Genre.getText() + "',Price='" + Double.parseDouble(txt_Price.getText()) + "', Quantity = '" + Integer.parseInt(txt_Quantity.getText()) + "' WHERE Id = '"+Integer.parseInt(txt_Id.getText())+"' ";
			r = stm.executeUpdate(cadSql);
			JOptionPane.showMessageDialog(null, r + "The record was updated");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The record was not updated" + e);
		}
                Clean();
    }
    @FXML
    private void Delete(ActionEvent event) {
    
    
        int r;
        Connection conn;
        conn = dc.Conect();
        	try {
                    stm = conn.createStatement();

		String cadSql;
			
			cadSql = "delete from Book where Id = '"+Integer.parseInt(txt_Id.getText())+"'";
			 stm.executeQuery(cadSql);
                         JOptionPane.showMessageDialog(null, "It was Delete");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The code not exist"+ e);                    
}
    Clean();
    }
    
    
    @FXML
    private void Clean(){
    
    
    txt_Quantity.setText("");
    txt_Id.setText("");;
    txt_Author.setText("");
    txt_Genre.setText("");
    txt_Price.setText("");
    txt_Tittle.setText("");
    txt_Id.requestFocus();

    }
    
    @FXML
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
    
    }

    

