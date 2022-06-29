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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ProductsAdminController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button btnAddProdToSystem;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeleteProdFromSystem;

    @FXML
    private Button btnEditProdInSystem;

    @FXML
    private TableColumn<?, ?> columnProdCategory;

    @FXML
    private TableColumn<?, ?> columnProdID;

    @FXML
    private TableColumn<?, ?> columnProdName;

    @FXML
    private TableColumn<?, ?> columnProdPrice;

    @FXML
    private TableColumn<?, ?> columnProdQty;

    @FXML
    private TableColumn<?, ?> columnProdStatus;

    @FXML
    private ComboBox<?> comboCategory;

    @FXML
    private ComboBox<?> comboStatus;

    @FXML
    private Label lblTotSystemProd;

    @FXML
    private TableView<?> tableProducts;

    @FXML
    private TextField txtFieldProdName;

    @FXML
    private TextField txtFieldProdPrice;

    @FXML
    private TextField txtFieldQtyToBeAdded;
    
    
    @FXML
    public void btnBack(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("AdminMainScreen.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
    }
    
    @FXML
    public void btnAddProd(ActionEvent event) throws IOException{
        
        // add product to table and database
        
    }
    
    @FXML
    public void btnDeleteProd(ActionEvent event) throws IOException{
        
        // delete selected product from table and database
        
    }
    
    @FXML
    public void btnEditProd(ActionEvent event) throws IOException{
        
        // Edit selected product in table and database
        
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
