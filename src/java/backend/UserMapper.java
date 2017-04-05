/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bloch
 */
public class UserMapper {

    private DBConnector dbc = new DBConnector();
    private Connection conn = dbc.connectDB();

    public User validateUser(String email, String pass) {
        String sql = "select * from user where email = ? && password = ?;";

        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, email);
            preStmt.setString(2, pass);
            ResultSet rs = preStmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("userID");
                String mail = rs.getString("email");
                String name = rs.getString("userName");
                
                

                return new User(id, email, name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
