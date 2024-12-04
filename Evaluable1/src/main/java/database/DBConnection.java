package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null) {
                createConnection();
            }
        return connection;
    }

    private void createConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s/%s", SchemaDB.HOST, SchemaDB.DB_NAME);
            connection = DriverManager.getConnection(url, "root", "");

    }
}
