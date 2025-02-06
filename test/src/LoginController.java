import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Action;

import SQLmethods.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    Label error;
    

    private Stage stage;
    private Scene scene;
    private Parent root;
    

    public void switchToVen(ActionEvent event) throws IOException, SQLException {
        ObservableList<UserCredentials> users = initialData();              //Obtain the list of people that are in the system
        // Get username in the username field
        String username = usernameField.getText();
        // Get password in the password field
        String password = passwordField.getText();
        
        boolean login = false;

        //Check if the username and password is correct
        for (UserCredentials check: users) {
            if (check.getUsername().equals(username) && check.getPassword().equals(password)) {
                login = true;
                break;
            }
        }
        if (login) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ManageVenueAndRequests.fxml"));
        root = loader.load();

        VenueController venControl = loader.getController();
        venControl.displayName(username, password);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

        usernameField.clear();
        passwordField.clear();
    }


    public void switchToCreate(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("fxml/CreateAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    ObservableList<UserCredentials> initialData() throws SQLException {
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

}
