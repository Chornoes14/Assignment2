import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    
    // Create textfield of username, password and pin
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    PasswordField fieldPIN;

    @FXML
    Label error;
    

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToMain(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("fxml/MusicMatchmakerLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToVen(ActionEvent event) throws IOException {
        
        // Get username in the username field
        String username = usernameField.getText();
        // Get password in the password field
        String password = passwordField.getText();
        // Get PIN in the PIN field
        String userPIN = fieldPIN.getText();

        // 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ManageVenueAndRequests.fxml"));
        root = loader.load();

        VenueController venControl = loader.getController();
        venControl.displayName(username, password);

        // root = FXMLLoader.load(getClass().getResource("fxml/ManageVenueAndRequests.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
