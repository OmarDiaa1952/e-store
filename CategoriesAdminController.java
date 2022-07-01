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


public class CategoriesAdminController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button btnAddCategory;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeleteCategory;

    @FXML
    private Button btnEditCategory;

    @FXML
    private TableColumn<?, ?> columnCategoryID;

    @FXML
    private TableColumn<?, ?> columnCategoryName;

    @FXML
    private TableColumn<?, ?> columnCategoryStatus;

    @FXML
    private ComboBox<?> comboStatus;

    @FXML
    private Label lblTotCategories;

    @FXML
    private TableView<?> tableCategories;

    @FXML
    private TextField txtFieldCategoryName;
    
    
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
    public void btnAddCategory(ActionEvent event) throws IOException{
        
        // add category to table and database
        
    }
    
    @FXML
    public void btnDeleteCategory(ActionEvent event) throws IOException{
        
        // delete selected category from table and database
        
    }
    
    @FXML
    public void btnEditCategory(ActionEvent event) throws IOException{
        
        // Edit selected category in table and database
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
