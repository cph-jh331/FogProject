/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import logic.Register;
import logic.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bloch
 */


//Sofar working as login to Employee at Fog with test@test.dk // 123.. need to split up to make 1 for Fog 1 for customer.
public class UserMapper {

    private DBConnector dbc = new DBConnector();
    private Connection conn = dbc.connectDB();
   Register r = new Register();
    Statement st;
    
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

                return new User(id, mail, name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    //Making userRegistration.
    public Register validate(String firstname, String lastname, String adress, String zip, String city, String phone, String email, String password1, String password2, Hashtable errors) {
       // boolean bool = true;

        if (firstname.equals("")) {
            errors.put("firstname", "indtast venligst fornavn");

            firstname = "";
            //bool = false;
        }
        if (lastname.equals("")) {
            errors.put("lastname", "indtast venligst efternavn");
            lastname = "";
           // bool = false;
        }
        if (adress.equals("")) {
            errors.put("adress", "indtast venligts adresse");
            adress = "";
           // bool = false;
        }
        if (zip.equals("") || zip.length() != 4) {
            errors.put("zip", "indtast venligt postnummer");
            zip = "";
           // bool = false;
        } else {
            
            try {
                int x = Integer.parseInt(zip);
            } catch (NumberFormatException e) {
                errors.put("zip", "indtast venligst postnummer");
                zip = "";
              //  bool = false;

            }
        }

        if (city.equals("")) {
            errors.put("city", "indtast venligst by");
            city = "";
           // bool = false;
        }
        if (phone.equals("") || phone.length() != 8) {
            errors.put("phone", "indtast venligst tlfnummer");
            phone = "";
           // bool = false;

        }
        if (email.equals("") || email.indexOf('@') == -1) {
            errors.put("email", "indtast venligst email");
            email = "";
           // bool = false;
        }
        if (password1.equals("")) {
            errors.put("password1", "indtast venligst password");
            password1 = "";
          //  bool = false;
        }
        if (!password1.equals("") && (password2.equals("") || !password1.equals(password2))) {
            errors.put("password2", "bekræft venligst password");
            password2 = "";
          //  bool = false;

        }
        return null;

    }

    public String getErrorMsg(String s, Hashtable errors) {

        String errorMsg = (String) errors.get(s.trim());
        return (errorMsg == null) ? "" : errorMsg;

    }

    public void insertData(String firstname, String lastname, String adress, String zip, String city, String phone, String email, String password1, String password2, Hashtable errors) throws SQLException {

        String sql = "insert into Customer(userName, userLastname, userAddress, userZip, userCity, userPhone, userEmail, password)
                + values (?,?,?,?,?,?,?,?);";
        
        try {
            try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("Error in class.forname" + ex.getCause());
            org.jboss.logging.Logger.getLogger(Register.class.getName()).log(org.jboss.logging.Logger.Level.FATAL, lastname);
        }

        conn = (Connection) DriverManager.getConnection("207.154.193.223");

        PreparedStatement prStmt = conn.prepareStatement(sql);
                
              
        
//        String table = "create table if not exists Fogshop.Customer (first_Name varchar(20), last_name varchar(20), adress varchar(20), "
//                + " zip_Code varchar(20), city varchar (20), phone varchar(20), email_Adress varchar(20), password  varchar(20)) ";
        String table = null;

        st.executeUpdate(table);
        firstname = r.getFirstname();
        lastname = r.getLastname();
        adress = r.getAdress();
        zip = r.getZip();
        city = r.getCity();
        phone = r.getPhone();
        email = r.getEmail();
        password1 = r.getPassword1();
        
        st.executeUpdate("insert into Fogshop.Customer(userName, userLastname, userAddress, userZip, userCity, userPhone, userEmail, password)"
                + "values ('" + firstname + "','" + lastname + "', '" + adress + "','" + zip + "', '" + city + "', '" + phone + "', " + email + "', '" + password1 + "') ");

        System.out.println("Store into the database");
    }
     catch (Exception ex) {
        System.out.println("Error in connection::" + ex.getCause());
     }
    }

}
