import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.TableColumn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Label testLabel;

    //Requests Table
    @FXML
    private TableColumn<?, ?> reqNum;
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private TableColumn<?, ?> artist;
    @FXML
    private TableColumn<?, ?> clientName;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> time;

    //Venue Table
    @FXML
    private TableColumn<?, ?> venueNum;
    @FXML
    private TableColumn<?, ?> venueName;
    @FXML
    private TableColumn<?, ?> suitable;
    @FXML
    private TableColumn<?, ?> compatibility;

    // Initialize table
    ObservableList<UserCredentials> requestsTableData() throws SQLException {
        ObservableList<UserCredentials> users = FXCollections.observableArrayList();    //create object

        try (Connection con = DatabaseConnection.getConnection();
			Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM MANAGERS")) {

            while (resultSet.next()) {
                UserCredentials user = new UserCredentials(resultSet.getString("Username"),
                    resultSet.getString("Password"),
                    resultSet.getString("Firstname"),
                    resultSet.getString("Lastname"),
                    resultSet.getString("Email")
                );
                users.add(user);
                
            }

		} catch (SQLException e) {
			System.out.println("Error: Unable to fetch data from the database");
            e.printStackTrace();
            return FXCollections.observableArrayList();
		}
        return users;
    }


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
