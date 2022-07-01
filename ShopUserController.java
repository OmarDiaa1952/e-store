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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ShopUserController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDecreaseQty;

    @FXML
    private Button btnIncreaseQty;

    @FXML
    private Button btnSearch;

    @FXML
    private TableColumn<?, ?> columnAvailable;

    @FXML
    private TableColumn<?, ?> columnCategory;

    @FXML
    private TableColumn<?, ?> columnPrice;

    @FXML
    private TableColumn<?, ?> columnProd;

    @FXML
    private TableView<?> tableShop;

    @FXML
    private TextField txtFieldSearch;
    
    @FXML
    private TextField txtFieldQty;
    
    
    @FXML
    public void btnBack(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("UserMainScreen.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
    }
    
    private int count = 0;
    
    @FXML
    public void btnIncreaseQty(ActionEvent event) throws IOException{
        
        // increment txtFieldQty by 1
        count++;
        txtFieldQty.setText(Integer.toString(count));
        
    }
    
    @FXML
    public void btnDecreaseQty(ActionEvent event) throws IOException{
        
        // decrement txtFieldQty by 1
        if(count > 0){
            count--;
            txtFieldQty.setText(Integer.toString(count));
        }
        
    }
    
    
    
    @FXML
    public void btnAddToCart(ActionEvent event) throws IOException{
        
        // getting quantity for txtFieldQty and add to user cart then maybe reset the txtField to empty
        
    }
    
    @FXML
    public void btnSearch(ActionEvent event) throws IOException{
        
        // search in table
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
