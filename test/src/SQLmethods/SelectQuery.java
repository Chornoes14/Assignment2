package SQLmethods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {
	public static void main(String[] args) {
		final String TABLE_NAME = "Managers";

		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			String query = "SELECT * FROM " + TABLE_NAME;

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while(resultSet.next()) {
					System.out.printf("Username: %s | Password: %s | First Name: %s | Last Name: %s | Email: %s\n",
							resultSet.getString("Username"), resultSet.getString("Password"),
							resultSet.getString("Firstname"), resultSet.getString("Lastname"),
							resultSet.getString("Email"));
				}
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
