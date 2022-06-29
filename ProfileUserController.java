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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ProfileUserController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button BtnWallet;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeleteAccount;

    @FXML
    private Button btnEditPass;

    @FXML
    private Button btnShowOrders;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblTotUserOrders;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblWalletBalance;

    @FXML
    private TextField txtFieldNewPass;

    @FXML
    private TextField txtFieldOldPass;

    @FXML
    private TextField txtFieldPass;

    @FXML
    private TextField txtFieldRetypeNewPass;

    @FXML
    private TextField txtFieldRetypePass;
    
    
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
    
    @FXML
    public void BtnWallet(ActionEvent event) throws IOException{  //may be changed must try
        
        // Open new stage of wallet screen without closing the main screen
        root = FXMLLoader.load(getClass().getResource("Wallet.fxml"));
        stage = new Stage();
        scene = new Scene(root);
        stage.setTitle("E-Mart");
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
    }
    
    @FXML
    public void btnDeleteAccount(ActionEvent event) throws IOException{
        
        // Delete Account
        
    }
    
    @FXML
    public void btnEditPass(ActionEvent event) throws IOException{
        
        // Edit Pass
        
    }
    
    @FXML
    public void btnShowOrders(ActionEvent event) throws IOException{
        
        // Open new stage of orders screen without closing the main screen
        root = FXMLLoader.load(getClass().getResource("OrdersUser.fxml"));
        stage = new Stage();
        scene = new Scene(root);
        stage.setTitle("E-Mart");
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
