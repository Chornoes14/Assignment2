import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

// import javax.swing.table.TableColumn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class VenueController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    // Testing 
    @FXML
    private Label testLabel;

    //Requests Table
    @FXML
    private TableView<Requests> requestTable;
    @FXML
    private TableColumn<Requests, Integer> reqNum;
    @FXML
    private TableColumn<Requests, String> title;
    @FXML
    private TableColumn<Requests, String> artist;
    @FXML
    private TableColumn<Requests, String> clientName;
    @FXML
    private TableColumn<Requests, String> date;
    @FXML
    private TableColumn<Requests, String> time;

    //Venue Table
    @FXML
    private TableView<Venue> venueTable;
    @FXML
    private TableColumn<Venue, Integer> venueNum;
    @FXML
    private TableColumn<Venue, String> venueName;
    @FXML
    private TableColumn<Venue, String> suitable;
    @FXML
    private TableColumn<Venue, Double> compatibility;

    // Initialize table
    ObservableList<Venue> venueTableData() throws SQLException {
        ObservableList<Venue> venues = FXCollections.observableArrayList();    //create object

        try (Connection con = DatabaseConnection.getConnection();
			Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM VENUES")) {

            while (resultSet.next()) {
                Venue venue = new Venue(resultSet.getString("Name"),
                    resultSet.getString("Category"),
                    resultSet.getInt("Capacity"),
                    resultSet.getDouble("Booking price / hour"),
                    resultSet.getString("Suitable for")
                );
                venues.add(venue);
                
            }

		} catch (SQLException e) {
			System.out.println("Error: Unable to fetch data from the database");
            e.printStackTrace();
            return FXCollections.observableArrayList();
		}
        return venues;
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


    /**
     * obtain the values of the table and fill the table with what is in the database
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //initialize venues table
        // venueNum.setCellValueFactory(new PropertyValueFactory<Venue, Integer>("username"));      TO BE COMPLETED
        venueName.setCellValueFactory(new PropertyValueFactory<Venue, String>("venueName"));
        suitable.setCellValueFactory(new PropertyValueFactory<Venue, String>("suitableFor"));
        // compatibility.setCellValueFactory(new PropertyValueFactory<Venue, Double>("email"));     TO BE COMPLETED
    
        try {
            venueTable.setItems(venueTableData());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: unable to load table data.");
        }
    }
}
