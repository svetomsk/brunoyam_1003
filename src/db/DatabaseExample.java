package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseExample {
    public static void main(String[] args) throws SQLException {
        // JDBC drivers
        String driverName = "jdbc";
        String dbType = "sqlite";
        String dbPath = "client_db.db";
        String url =  driverName + ":" + dbType + ":" + dbPath;
        Connection connection = DriverManager.getConnection(url);

        createTables(connection);
//        createUsers(connection);
        selectAllUsers(connection);

        connection.close();
    }

    private static void selectAllUsers(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Client;");
        ResultSet results = statement.executeQuery();
        while (results.next()) {
            int clientId = results.getInt("client_id");
            String firstName = results.getString("first_name");
            String lastName = results.getString("last_name");
            System.out.println(clientId + " " + firstName + " " + lastName);
        }
    }

    private static void createUsers(Connection connection) throws SQLException {
        List<ClientEntity> clients = new ArrayList<>();
        clients.add(new ClientEntity("Ivan", "Ivanov"));
        clients.add(new ClientEntity("Pert", "Petnov"));
        clients.add(new ClientEntity("Svetozar", "Milykh"));
        for(ClientEntity client : clients) {
            PreparedStatement statement = connection.prepareStatement(client.getInsertStatementSql());
            statement.execute();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS \"Client\" (\n" +
                "  \"client_id\" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  \"first_name\" TEXT NOT NULL,\n" +
                "  \"last_name\" TEXT NOT NULL\n" +
                ");");
        statement.execute();

        statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS \"Zakazy\" (\n" +
                "  \"order_id\" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  \"description\" TEXT NOT NULL,\n" +
                "  \"client\" INTEGER NOT NULL REFERENCES \"Client\" (\"client_id\") ON DELETE CASCADE\n" +
                ");");
        statement.execute();
    }
}
