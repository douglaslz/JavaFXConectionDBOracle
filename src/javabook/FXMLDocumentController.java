
package javabook;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
   
    //Lista Form
    private Label label;
    @FXML
    private TableView<Book> TableBook;
    @FXML
    private TableColumn<Book, Integer> colId;
    @FXML
    private TableColumn<Book, String> colTittle;
    @FXML
    private TableColumn<Book, String> colAuthor;
    @FXML
    private TableColumn<Book, String> colGenre;
    @FXML
    private TableColumn<Book, Double> colPrice;
    @FXML
    private TableColumn<Book, Integer> colQuantity;
    private ObservableList<Book>data;
    private DBConnection dc;
    
   
    
//    private TextField txt_Author;
//    @FXML private Label txt_Quantity;
    @FXML private Button btnLoadDetails;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dc = new DBConnection();
        loadData();
    }    
    
    
    @FXML
    private void loadData() {
        
    Connection conn = dc.Conect();
    data = FXCollections.observableArrayList();      
        try {
            ResultSet rs= conn.createStatement().executeQuery("select * from Book ");
            while(rs.next()){
            data.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTittle.setCellValueFactory(new PropertyValueFactory<>("tittle"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        
        TableBook.setItems(null);
        TableBook.setItems(data);
        
    }
        @FXML
    private void OpenForm(ActionEvent event) throws IOException {
    
        
    final Node source = (Node) event.getSource();
    final Stage stage1 = (Stage) source.getScene().getWindow();
    stage1.close();
        
        //Platform.exit();
        
    FXMLLoader fxmlLoader = new 
    FXMLLoader(getClass().getResource("FXMLDocument3.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    
    
    
    //set what you want on your stage
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Report Page");
    stage.setScene(new Scene(root1));
    stage.setResizable(false);
    stage.show();
    
        
    }
    @FXML
    private void SaleForm(ActionEvent event) throws IOException {
        
        
        Platform.exit();
//    final Node source = (Node) event.getSource();
//    final Stage stage1 = (Stage) source.getScene().getWindow();
//    stage1.close();
//        
//        //Platform.exit();
//        
//    FXMLLoader fxmlLoader = new 
//    FXMLLoader(getClass().getResource("Sale.fxml"));
//    Parent root1 = (Parent) fxmlLoader.load();
//    Stage stage = new Stage();
//    
//    
//    
//    //set what you want on your stage
//    stage.initModality(Modality.APPLICATION_MODAL);
//    stage.setTitle("Report Page");
//    stage.setScene(new Scene(root1));
//    stage.setResizable(false);
//    stage.show();
//    
    
    
    }
    
}
