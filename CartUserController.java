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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class CartUserController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    

    @FXML
    private Button btnCheckOut;

    @FXML
    private Button btnRemoveItem;

    @FXML
    private TableColumn<?, ?> columnPrice;

    @FXML
    private TableColumn<?, ?> columnProd;

    @FXML
    private TableColumn<?, ?> columnQty;

    @FXML
    private Label lblCartPrice;

    @FXML
    private Label lblCurrentBalanceWallet;

    @FXML
    private TableView<?> tableCart;
    
    
    
    
    @FXML
    public void btnRemoveItem(ActionEvent event) throws IOException{
        
        // remove selected product from cart
        
    }
    
    @FXML
    public void btnCheckOut(ActionEvent event) throws IOException{
        
        // check out
        // decrease wallet - add entry in orders table with customers id - reset cart to empty
        
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // initialize table columns and label text from database
        
    }    
    
}
