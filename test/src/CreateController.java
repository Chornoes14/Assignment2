import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Action;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateController {
    
	private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField createEmail;

    @FXML
    private TextField createFirst;

    @FXML
    private TextField createLast;

    @FXML
    private TextField createPassword;

    @FXML
    private TextField createUsername;

    @FXML
    private TextField managerPIN;
    
    
    
    
    
    /**
     * Return to login screen when staff account is created
     * @param event
     * @throws IOException
     */
    public void staffRegisterLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("fxml/MusicMatchmakerLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Return to main menu with manager account created
     * @param event
     * @throws IOException
     */
    public void managerRegisterLogin(ActionEvent event) throws IOException {
    	
    	//Get all of the user inputs
    	String firstname = createFirst.getText();
    	String lastname = createLast.getText();
    	String username = createUsername.getText();
    	String password = createPassword.getText();
    	String email = createEmail.getText();
    	String pinManager = managerPIN.getText();
    	
    	if (pinManager.equals("909")) {
    	
    		root = FXMLLoader.load(getClass().getResource("fxml/MusicMatchmakerLogin.fxml"));
        	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	scene = new Scene(root);
        	stage.setScene(scene);
        	stage.show();
    	}
    	else {
    		managerPIN.clear();
    		managerPIN.setText("PIN was incorrect");
    	}
    }
    
    
    
    
    /**
     * Get the data for the managers
     * @return
     * @throws SQLException
     */
    ObservableList<UserCredentials> managerData() throws SQLException {
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
