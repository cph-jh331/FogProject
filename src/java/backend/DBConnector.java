/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lasse Andersen
 */
public class DBConnector {
    private final String ip = "";
    private final int port = 3306;
    private final String database = "FogProject";
    private final String username = "root";
    private final String password = "test";
    private Connection conn = null;

    public Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
            conn = (Connection) DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println(e);
        }
        return conn;
        
        
    }
}
