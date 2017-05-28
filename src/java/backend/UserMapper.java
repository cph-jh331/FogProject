package backend;

import logic.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logic.Admin;
import logic.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UserMapper is used for updating and getting data from the Customer and
 * FogUser table in the MySQL database.
 *
 * @author Lasse Andersen, Marco Frydshou, John Hansen, Per Andersen
 */
public class UserMapper {

    private Connection conn;

    /**
     * Constructor that sets the private attribute Connection to the Connection
     * parameter.
     *
     * @param conn SQL Connection to set.
     */
    public UserMapper(Connection conn)
    {
        this.conn = conn;
    }

    /**
     * Returns a User object based on the two String parameters email and pass.
     * User object can be null. Should be used when validating a customer.
     *
     * @param email String value of the email.
     * @param pass String value of the password.
     * @return User object. Will return NULL if the email or password are not
     * equal to the ones in the Customer table.
     */
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

    /**
     * Returns a User object based on the two String parameters email and pass.
     * User object can be null. Should be used when validating a FogUser/admin.
     *
     * @param email String value of the email.
     * @param pass String value of the password.
     * @return User object. Will return NULL if the email or password are not
     * equal to the ones in the FogUser table.
     */
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

    /**
     * Inserts a User object's data into Customer table in the MySQL database.
     * Throws an UserAlreadyExistException if email is already in the database.
     *
     * @param customer User object to be inserted into the Customer table.
     * @param password String value for password to be inserted into the
     * Customer table.
     * @throws UserAlreadyExistException if the email is already in the Customer
     * table in the MySQL database.
     */
    public void insertUser(User customer, String password) throws UserAlreadyExistException
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
            throw new UserAlreadyExistException("user already exists");
        }
    }
}
