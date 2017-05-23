/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import logic.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Admin;
import logic.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bloch
 */
//So far working as login to Employee at Fog with test@test.dk // 123.. need to split up to make 1 for Fog 1 for customer.
public class UserMapper {

    private DBConnector dbc;
    private Connection conn;

    public UserMapper(Connection conn)
    {
        this.conn = conn;
    }

    public UserMapper()
    {
        this.dbc = new DBConnector();
        this.conn = dbc.connectDB();
    }

    public User validateCustomer(String email, String pass)
    {
        String sql = "select * from Customer where userEmail = ? && password = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, email);
            preStmt.setString(2, pass);
            ResultSet rs = preStmt.executeQuery();
            if (rs.next())
            {
                int customerId = rs.getInt("customerId");
                String firstname = rs.getString("userName");
                String lastname = rs.getString("userLastname");
                String address = rs.getString("userAddress");
                int zip = rs.getInt("userZip");
                String city = rs.getString("userCity");
                int phone = rs.getInt("userPhone");
                email = rs.getString("userEmail");
                boolean isAdmin = rs.getBoolean("admin");
                User user = new Customer(customerId, email, firstname, lastname, address, city, zip, phone, isAdmin);
                return user;

            }
        } catch (SQLException ex)
        {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }


    public User validateAdmin(String email, String pass)
    {

        String sql = "select * from FogUser where empEmail = ? && password = ?;";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, email);
            preStmt.setString(2, pass);
            ResultSet rs = preStmt.executeQuery();
            if (rs.next())
            {
                int id = rs.getInt("empId");
                String mail = rs.getString("empEmail");
                String name = rs.getString("empName");
                boolean admin = rs.getBoolean("admin");
                User user = new Admin(id, mail, name, admin);
                return user;
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertUser(User customer, String password)
    {

        String sql = "insert into Customer (userName, userLastname, userAddress, userZip, userCity, userPhone, userEmail, password) values (?,?,?,?,?,?,?,?);";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, customer.getFirstName());
            preStmt.setString(2, customer.getLastName());
            preStmt.setString(3, customer.getAddress());
            preStmt.setInt(4, customer.getZip());
            preStmt.setString(5, customer.getCity());
            preStmt.setInt(6, customer.getPhone());
            preStmt.setString(7, customer.getEmail());
            preStmt.setString(8, password);
            preStmt.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
