import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VenueController {
    
    // Testing 
    @FXML
    Label testLabel;

    public void displayName(String username, String password) {
        testLabel.setText("Hello: " + username + password);
    }

    

}
