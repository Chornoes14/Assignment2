
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


	/**
	 * Add a new manager into the table
	 * @param manager
	 */
	public static void addManager(UserCredentials manager) {
		final String TABLE_NAME = "MANAGERS";

		try(Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement()) {
			String query = "INSERT INTO " + TABLE_NAME + " Values ('" +
					manager.getUsername() + "', '" +
					manager.getPassword() + "', '" +
					manager.getFirstName() + "', '" +
					manager.getLastName() + "', '" +
					manager.getEmail() + "')";

			
			int result = stmt.executeUpdate(query);

			if (result == 1) {
				System.out.println("Inset into table " + TABLE_NAME + " executed successfully");
				System.out.println(result + " row(s) affected");
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	

}
