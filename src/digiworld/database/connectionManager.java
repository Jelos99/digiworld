package digiworld.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionManager {
	public static Connection databaseConnection;
	
	public static void createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova?useSSL=false&serverTimezone=UTC","root","elos");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: Autogenerato, da cambiare
			e.printStackTrace();
		}
		
		
	}
	
	public static void closeConnection() throws SQLException {
		 /* Esegue il commit delle transazioni in attesa prima della chiusura della connessione */
		 databaseConnection.commit();
		 
		 databaseConnection.close();
	}
	
}
