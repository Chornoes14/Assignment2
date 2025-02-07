import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import org.w3c.dom.events.MouseEvent;

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
    //Outputs
    @FXML
    private Label output;

    @FXML
    private TextField inputName;

    //Requests Table
    @FXML
    private TableView<Request> requestTable;
    @FXML
    private TableColumn<Request, Integer> reqNum;
    @FXML
    private TableColumn<Request, String> title;
    @FXML
    private TableColumn<Request, String> artist;
    @FXML
    private TableColumn<Request, String> clientName;
    @FXML
    private TableColumn<Request, String> date;
    @FXML
    private TableColumn<Request, String> time;

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

    //Add venue
    @FXML
    private TextField inputVenue;
    @FXML
    private TextField inputCap;
    @FXML
    private TextField inputSuit;
    @FXML
    private TextField inputCategory;
    @FXML
    private TextField inputBook;



    // Initialize venue table
    ObservableList<Venue> venueTableData() throws SQLException {
        ObservableList<Venue> venues = FXCollections.observableArrayList();    //create object

        try (Connection con = DatabaseConnection.getConnection();
			Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT rowid, Name, Category, Capacity, Booking_price, Suitable_for FROM VENUES")) {

            while (resultSet.next()) {
                Venue venue = new Venue(resultSet.getInt("rowid"),
                    resultSet.getString("Name"),
                    resultSet.getString("Category"),
                    resultSet.getInt("Capacity"),
                    resultSet.getInt("Booking_price"),
                    resultSet.getString("Suitable_for")
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

    // Initialize requests table
    ObservableList<Request> requestTableData() throws SQLException {
        ObservableList<Request> requests = FXCollections.observableArrayList();    //create object

        try (Connection con = DatabaseConnection.getConnection();
			Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT rowid, Client, Title, Artist, Date, Time, Duration, Target_Audience, Type, Category FROM REQUESTS")) {

            while (resultSet.next()) {
                Request request = new Request(resultSet.getInt("rowid"),
                    resultSet.getString("Client"),
                    resultSet.getString("Title"),
                    resultSet.getString("Artist"),
                    resultSet.getString("Date"),
                    resultSet.getString("Time"),
                    resultSet.getInt("Duration"),
                    resultSet.getInt("Target_Audience"),
                    resultSet.getString("Type"),
                    resultSet.getString("Category")
                );
                requests.add(request);
                
            }

		} catch (SQLException e) {
			System.out.println("Error: Unable to fetch data from the database");
            e.printStackTrace();
            return FXCollections.observableArrayList();
		}
        return requests;
    }


    /**
     * Test method
     * @param username
     * @param password
     */
    public void displayName(String username, String password) {
        testLabel.setText("Hello " + username);
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


    public void getVenueData(ActionEvent event) throws IOException{

        try {
            //get table data
            ObservableList<Venue> venues = venueTableData();

            //Get inputID
            String venueName = inputName.getText();
            boolean valid = false;

            //Venue field is not filled
            if (venueName.isEmpty()) {
                output.setText("Please enter a name of the venue to get the details of");
                return;
            }
            //Check if the name of the venue is part of the venues
            for (Venue venue: venues) {
                if (venueName.equals(venue.getVenueName())) {
                    output.setText("Capacity = " + venue.getCapacity() + "\nCategory = " + venue.getCategory() + "\nBooking price = $" + venue.getBookingPrice() + " per hour");
                    valid = true;
                    break;
                }
            }
            //Venue not in database
            if (!valid) {
                output.setText(venueName + " is not in our database, please check if the name of the venue is correct.");
            }
        }
        catch (SQLException e) {
            System.out.println("Cannot get table data");
        }

    }

    public void addVenue(ActionEvent event) throws IOException {
        //get venue name
        String venueName = inputVenue.getText();
        if (venueName.isBlank()) {
            output.setText("Please enter a venue name");
            return;
        }
        //get capacity
        try {
        	int capacity = Integer.parseInt(inputCap.getText());
        }
        catch (NumberFormatException e) {
            output.setText("Please enter a valid whole number for capacity.");
            return;
        }
        int capacity = Integer.parseInt(inputCap.getText());
        //get suitability
        String suitable = inputSuit.getText();
        if (suitable.isBlank()) {
            output.setText("Please enter a suitability for the venue");
            return;
        }

        //get category
        String category = inputCategory.getText();
        if (category.isBlank()) {
            output.setText("Please enter category for the venue");
            return;
        }
        //Get booking price
        try {
        	int book = Integer.parseInt(inputBook.getText());
        }
        catch (NumberFormatException e) {
            output.setText("Please enter a valid whole number for booking price.");
            return;
        }
        int book = Integer.parseInt(inputBook.getText());

        // Add new venue to the database
        try {
            //get current size of the venue
            ObservableList<Venue> venues = venueTableData();
            int venueID = venues.size() + 1;
            SQLMethods.addVenue(new Venue(venueID, venueName, category, capacity, book, suitable));

            root = FXMLLoader.load(getClass().getResource("fxml/ManageVenueAndRequests.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (SQLException e) {
            System.out.println("Fail");
        }


    }


















    /**
     * obtain the values of the table and fill the table with what is in the database
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //initialize venues table values
        venueNum.setCellValueFactory(new PropertyValueFactory<Venue, Integer>("venueID"));      //TO BE COMPLETED, add the designated column to table after
        venueName.setCellValueFactory(new PropertyValueFactory<Venue, String>("venueName"));
        suitable.setCellValueFactory(new PropertyValueFactory<Venue, String>("suitableFor"));
        // compatibility.setCellValueFactory(new PropertyValueFactory<Venue, Double>("email"));     TO BE COMPLETED, add the designated column to table after
    

        //initialize requests table values
        reqNum.setCellValueFactory(new PropertyValueFactory<Request, Integer>("requestID"));     //TO BE COMPLETED, add the designated column to table after 
        title.setCellValueFactory(new PropertyValueFactory<Request, String>("title"));
        artist.setCellValueFactory(new PropertyValueFactory<Request, String>("artist"));
        clientName.setCellValueFactory(new PropertyValueFactory<Request, String>("clientName"));
        date.setCellValueFactory(new PropertyValueFactory<Request, String>("requestDate"));
        time.setCellValueFactory(new PropertyValueFactory<Request, String>("requestTime"));
        

        try {
            venueTable.setItems(venueTableData());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: unable to load table data.");
        }

        try {
            requestTable.setItems(requestTableData());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: unable to load table data.");
        }

    }
}
