import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQuery {
    private DatabaseConnector databaseConnector;

    public DatabaseQuery(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public void executeQuery() {
        try {
            System.out.println("Executing query...");
            Connection connection = databaseConnector.getConnection();
            System.out.println("Connected to database.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM player");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("Nom"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }
}