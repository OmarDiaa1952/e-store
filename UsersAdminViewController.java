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


public class UsersAdminViewController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<?, ?> columnEmail;

    @FXML
    private TableColumn<?, ?> columnFirstName;

    @FXML
    private TableColumn<?, ?> columnLastName;

    @FXML
    private TableColumn<?, ?> columnNumOfOrdersOfUser;

    @FXML
    private TableColumn<?, ?> columnOrderDate;

    @FXML
    private TableColumn<?, ?> columnOrderPrice;

    @FXML
    private TableColumn<?, ?> columnUserOrderID;

    @FXML
    private TableColumn<?, ?> columnUsername;

    @FXML
    private TableColumn<?, ?> columnWalletBalanceOfUser;

    @FXML
    private Label lblSelectedEmail;

    @FXML
    private Label lblSelectedUsername;

    @FXML
    private Label lblTotOrdersInSystem;

    @FXML
    private Label lblTotUsersInSystem;

    @FXML
    private TableView<?> tableSelectedUserOrders;

    @FXML
    private TableView<?> tableUsers;
    
    
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
