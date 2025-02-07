
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Class which has all the methods for accessing SQL
 */
public class SQLMethods {

	public static void checkTable() {
		final String TABLE_NAME = "MANAGERS";

        try (Connection con = DatabaseConnection.getConnection()) {

			DatabaseMetaData dbm = con.getMetaData();
			
			ResultSet tables = dbm.getTables(null, null, TABLE_NAME, null);
				
			if(tables != null) {
				if (tables.next()) {
					System.out.println("Table " + TABLE_NAME + " exists.");
				}
				else {
					System.out.println("Table " + TABLE_NAME + " does not exist.");
				}
				tables.close(); // use close method to close ResultSet object
			} else {
				System.out.println("Problem with retrieving database metadata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}


	public static ObservableList<UserCredentials> getManagerTable() {
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
