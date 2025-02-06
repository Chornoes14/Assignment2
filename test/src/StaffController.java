import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import SQLmethods.SQLMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StaffController implements Initializable{

    private ResultSet resultSet;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<UserCredentials, String> emailList;
    @FXML
    private TableColumn<UserCredentials, String> firstnameList;
    @FXML
    private TableColumn<UserCredentials, String> lastnameList;
    @FXML
    private TableColumn<UserCredentials, String> usernameList;
    @FXML
    private TableView<UserCredentials> staffTable;


    
    public void switchToMain(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("fxml/MusicMatchmakerLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToVenue(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("fxml/ManageVenueAndRequests.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    /**
     * Initialising data for table
     * @throws SQLException 
     */
    ObservableList<UserCredentials> initialData() throws SQLException {
        resultSet = SQLMethods.getManagerTable();
        // ArrayList<UserCredentials> initTable;
        
        UserCredentials user1 = new UserCredentials(resultSet.getString("Username"), resultSet.getString("Password"),
                            resultSet.getString("Firstname"), resultSet.getString("Lastname"), resultSet.getString("Email"));
        System.out.println(user1.getEmail());
        
        

        return FXCollections.observableArrayList(user1);

    }

    /**
     * obtain the values of the table and fill the table with what is in the database
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameList.setCellValueFactory(new PropertyValueFactory<UserCredentials, String>("username"));
        firstnameList.setCellValueFactory(new PropertyValueFactory<UserCredentials, String>("firstName"));
        firstnameList.setCellValueFactory(new PropertyValueFactory<UserCredentials, String>("lastName"));
        emailList.setCellValueFactory(new PropertyValueFactory<UserCredentials, String>("email"));
    
        try {
            staffTable.setItems(initialData());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
