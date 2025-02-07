import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VenueController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    // Testing 
    @FXML
    Label testLabel;



    public void displayName(String username, String password) {
        testLabel.setText("Hello: " + username + password);
    }

    public void switchToMain(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("fxml/MusicMatchmakerLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToStaff(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("fxml/ManageStaff.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void table(ActionEvent event) throws IOException {
        SQLMethods.checkTable();
    }
}
