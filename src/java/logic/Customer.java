/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

public class Customer {

    private String userName;
    private String lastName;
    private String address;
    private String city;
    private int zip;
    private int phone;
    private String cusEmail;
    private String password;
    private boolean isAdmin = false;
    private int customerId;

    // Used for empUser
    public Customer(int customerId, String cusEmail, String userName, boolean admin) {
        this.customerId = customerId;
        this.cusEmail = cusEmail;
        this.userName = userName;
        this.isAdmin = admin;
    }
    public Customer(int customerId, String email, String firstName, String lastName, String address, String city, int zip, int phone, boolean isAdmin) {
        this.customerId = customerId;
        this.cusEmail = email;
        this.userName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.isAdmin = isAdmin;

    }

    public Customer(String email, String userName, String lastName, String address, String city, int zip, int phone, String password) {
        this.cusEmail = email;
        this.userName = userName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.password = password;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public String getCusName() {
        return this.userName;
    }

    public String getCusLastname() {
        return this.lastName;
    }

    public String getCusAddress() {
        return this.address;
    }

    public int getCusZip() {
        return this.zip;
    }

    public String getCusCity() {
        return this.city;
    }

    public int getCusPhone() {
        return this.phone;
    }

    public String getCusEmail() {
        return this.cusEmail;
    }

    public String getCusPassword() {
        return this.password;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

}
