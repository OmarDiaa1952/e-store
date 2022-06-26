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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SignUpController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    //private String fn;
    //private String lastn;
    //private String email;
    //private String un;
    //private String pw;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField emailtxtField;

    @FXML
    private TextField firstNametxtField;

    @FXML
    private TextField lastNametxtField;

    @FXML
    private PasswordField pswdtxtField;

    @FXML
    private PasswordField retypePswdtxtField;

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField usernametxtField;
    
    
    
    private boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    
    
    public void keyReleased(){
        String fn = firstNametxtField.getText().trim();
        String lastn = lastNametxtField.getText().trim();
        String email = emailtxtField.getText().trim();
        String un = usernametxtField.getText().trim();
        String pw = pswdtxtField.getText().trim();
        String retypePw = retypePswdtxtField.getText().trim();
        
        boolean empty = (un.isEmpty() || pw.isEmpty() || fn.isEmpty() || lastn.isEmpty() || email.isEmpty() || retypePw.isEmpty());
        boolean equalpw = (retypePw.equals(pw));
        boolean valid = isValid(email);
        
        boolean isDisabled = (empty || !equalpw || !valid);
        
        signUpBtn.setDisable(isDisabled);
        
        /*if(!isDisabled){
            this.fn = fn;
            this.lastn = lastn;
            this.email = email;
            this.un = un;
            this.pw = pw;
        }
        //System.out.println(empty);
        //System.out.println(equalpw);
        //System.out.println(valid);
        */
        
    }
    
    @FXML
    public void btnSignUp(ActionEvent event) throws IOException{
        
        //register user in database
        String fn = firstNametxtField.getText().trim();
        String lastn = lastNametxtField.getText().trim();
        String email = emailtxtField.getText().trim();
        String un = usernametxtField.getText().trim();
        String pw = pswdtxtField.getText().trim();
        
        DBUtils.signUp(event, fn, lastn, un, email, pw);
        
    }
    
    @FXML
    public void btnCancel(ActionEvent event) throws IOException{
        
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
        keyReleased();
    }    
    
}
