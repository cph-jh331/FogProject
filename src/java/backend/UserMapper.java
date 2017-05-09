/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import logic.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.SvgDrawing;

/**
 *
 * @author bloch
 */
//Sofar working as login to Employee at Fog with test@test.dk // 123.. need to split up to make 1 for Fog 1 for customer.
public class UserMapper {

    private DBConnector dbc;
    private Connection conn;

    public UserMapper(Connection conn) {
        this.conn = conn;
    }

    public UserMapper() {
        this.dbc = new DBConnector();
        this.conn = dbc.connectDB();
    }

    public User validateCustomer(String email, String pass) {
        String sql = "select * from Customer where userEmail = ? && password = ?;";
        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, email);
            preStmt.setString(2, pass);
            ResultSet rs = preStmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("customerId");
                String firstname = rs.getString("userName");
                String lastName = rs.getString("userLastname");
                String address = rs.getString("userAddress");
                int zip = rs.getInt("userZip");
                String userCity = rs.getString("userCity");
                int userPhone = rs.getInt("userPhone");
                String mail = rs.getString("userEmail");
                boolean isAdmin = rs.getBoolean("admin");

                return new User(id, mail, firstname, lastName, address, userCity, zip, userPhone, isAdmin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public User validateUser(String email, String pass) {
        String sql = "select * from FogUser where empEmail = ? && password = ?;";

        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, email);
            preStmt.setString(2, pass);
            ResultSet rs = preStmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("empId");
                String mail = rs.getString("empEmail");
                String name = rs.getString("empName");
                boolean admin = rs.getBoolean("admin");

                return new User(id, mail, name, admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertUser(User user) {

        String sql = "insert into Customer (userName, userLastname, userAddress, userZip, userCity, userPhone, userEmail, password) values (?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, user.getUserName());
            preStmt.setString(2, user.getLastName());
            preStmt.setString(3, user.getAddress());
            preStmt.setInt(4, user.getZip());
            preStmt.setString(5, user.getCity());
            preStmt.setInt(6, user.getPhone());
            preStmt.setString(7, user.getEmail());
            preStmt.setString(8, user.getPassword());
            preStmt.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<SvgDrawing> getDrawings(int customerId) {
        String sql = "select * from Svg where customerId = ?";
        List<SvgDrawing> svgDrawings = new ArrayList<>();
        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, customerId);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                int svgId = rs.getInt("svgId");
                customerId = rs.getInt("customerId");
                String dateCreated = rs.getString("dateCreated");
                int empId = rs.getInt("empId");
                String dateAccept = rs.getString("dateAccept");
                String svgImage = rs.getString("svgImage");
                

                svgDrawings.add(new SvgDrawing(svgId, customerId, dateCreated, empId, dateAccept, svgImage));
               
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svgDrawings;
    }

}

//    public void insertData(String firstname, String lastname, String adress, String zip, String city, String phone, String email, String password1, String password2, Hashtable errors) throws SQLException {
//        
//        String sql = "insert into Customer (userName, userLastname, userAddress, userZip, userCity, userPhone, userEmail, password) values (?,?,?,?,?,?,?,?);";
//        
//        try {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (Exception ex) {
//                System.out.println("Error in class.forname" + ex.getCause());
//                org.jboss.logging.Logger.getLogger(Register.class.getName()).log(org.jboss.logging.Logger.Level.FATAL, lastname);
//            }
//            
//            conn = (Connection) DriverManager.getConnection("207.154.193.223");
//            
//            PreparedStatement prStmt = conn.prepareStatement(sql);
//        String table = "create table if not exists Fogshop.Customer (first_Name varchar(20), last_name varchar(20), adress varchar(20), "
//                + " zip_Code varchar(20), city varchar (20), phone varchar(20), email_Adress varchar(20), password  varchar(20)) ";
//            String table = null;
//            
//            st.executeUpdate(table);
//            firstname = r.getFirstname();
//            lastname = r.getLastname();
//            adress = r.getAdress();
//            zip = r.getZip();
//            city = r.getCity();
//            phone = r.getPhone();
//            email = r.getEmail();
//            password1 = r.getPassword1();
//            
//            st.executeUpdate("insert into Fogshop.Customer(userName, userLastname, userAddress, userZip, userCity, userPhone, userEmail, password)"
//                    + "values ('" + firstname + "','" + lastname + "', '" + adress + "','" + zip + "', '" + city + "', '" + phone + "', " + email + "', '" + password1 + "') ");
//            
//            System.out.println("Store into the database");
//        } catch (Exception ex) {
//            System.out.println("Error in connection::" + ex.getCause());
//        }
//    }

