package SuperMarket;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class WalletController implements Initializable {
    
    @FXML
    private Button btnAddBalance;

    @FXML
    private Label lblCurrentUserBalance;

    @FXML
    private TextField txtFieldAmountToAdd;
    
    
    @FXML
    public void btnAddBalance(ActionEvent event) throws IOException{
        
        // get amount from the txtFieldAmountToAdd - cast it to double - Add balance in database and update
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
