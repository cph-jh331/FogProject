package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnector is used for creating and getting a connection to a MySQL
 * database.
 *
 * @author Lasse Andersen, Marco Frydshou, John Hansen, Per Andersen
 */
public class DBConnector {

    private final String ip = "207.154.193.223";
    private final int port = 3306;
    private final String database = "Fogshop";
    private final String username = "fog";
    private final String password = "Fog12345";
    private Connection conn = null;

    /**
     * ConnectDB() is used for connecting and returning a connection.
     *
     * @return A SQL Connection to a specific database.
     */
    public Connection connectDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
            conn = (Connection) DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e)
        {
            System.err.println(e);
        }
        return conn;

    }
}
