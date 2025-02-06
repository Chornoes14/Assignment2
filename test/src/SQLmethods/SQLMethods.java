package SQLmethods;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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


	public static ResultSet getManagerTable() {
		final String TABLE_NAME = "Managers";

		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			String query = "SELECT * FROM " + TABLE_NAME;

			// try (ResultSet resultSet = stmt.executeQuery(query)) {
			// 	while(resultSet.next()) {
			// 		System.out.printf("Username: %s | Password: %s | First Name: %s | Last Name: %s | Email: %s\n",
			// 				resultSet.getString("Username"), resultSet.getString("Password"),
			// 				resultSet.getString("Firstname"), resultSet.getString("Lastname"),
			// 				resultSet.getString("Email"));
			// 	}
			// } 
			ResultSet resultSet = stmt.executeQuery(query);
			return resultSet;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

}
