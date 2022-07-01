package SuperMarket;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class AdminMainController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
     @FXML
    private Button btnCategory;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnUsers;

    @FXML
    private Label lblName;

    @FXML
    private Label lblTotCategory;

    @FXML
    private Label lblTotOrders;

    @FXML
    private Label lblTotProd;

    @FXML
    private Label lblTotUsers;
    
    
    @FXML
    public void btnCategory(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("CategoriesAdmin.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
    }
    
    @FXML
    public void btnProducts(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("ProductsAdmin.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
    }
    
    @FXML
    public void btnUsers(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("UsersAdminView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
    }
    
    @FXML
    public void btnLogOut(ActionEvent event) throws IOException{
        
        //close remote connection to database and release resources
        //to be implemented
        
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
    }
    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // initialize labels from database
        
    }    
    
}
