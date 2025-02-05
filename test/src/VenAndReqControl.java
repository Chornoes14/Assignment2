import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VenAndReqControl {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToMain(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MusicMatchmakerLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToVen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManageVenueAndRequests.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
