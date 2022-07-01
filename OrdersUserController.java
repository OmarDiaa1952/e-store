package SuperMarket;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class OrdersUserController implements Initializable {
    
    @FXML
    private TableColumn<?, ?> columnDate;

    @FXML
    private TableColumn<?, ?> columnOrderID;

    @FXML
    private TableColumn<?, ?> columnPrice;

    @FXML
    private Label lblTotUsersOrders;

    @FXML
    private TableView<?> tableOrders;
    
    
    // set the values

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
