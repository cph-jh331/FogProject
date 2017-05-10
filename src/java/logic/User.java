/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Pva
 */
public class User {

   
    private String email;
    private String userName;
    private String lastName;
    private String address;
    private String city;
    private int zip;
    private int phone;
    private String password;
    private boolean isAdmin = false;
    private int customerId;
    
    public User(int customerId, String email, String userName, boolean admin) {
        this.customerId = customerId;
        this.email = email;
        this.userName = userName;
        this.isAdmin = admin;

    }

    public User(int customerId ,String email, String firsName, String lastName, String address, String city, int zip, int phone, String password) {
        this.customerId = customerId;
        this.email = email;
        this.userName = firsName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.password = password;
    }

    
    public User(int customerId, String email, String firstName, String lastName, String address, String city, int zip, int phone, boolean isAdmin) {
        this.customerId = customerId;
        this.email = email;
        this.userName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.isAdmin = isAdmin;
        
    }

    public User(String email, String userName, String lastName, String address, String city, int zip, int phone, String password) {
        this.email = email;
        this.userName = userName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.password = password;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    /**
     * @return the isAdmin
     */
    public boolean isAdmin()
    {
        return isAdmin;
    }
    

}
