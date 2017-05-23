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
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private int zip;
    private int phone;
    private boolean isAdmin = false;
    private int id;
    
    
    public User(int adminId, String email, String userName, boolean admin)
    {
        this.id = adminId;
        this.email = email;
        this.firstName = userName;
        this.isAdmin = admin;
    }

    public User(int customerId, String email, String firstName, String lastName, String address, String city, int zip, int phone, boolean isAdmin)
    {
        this.id = customerId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.isAdmin = isAdmin;
    }

    public String getEmail()
    {
        return email;
    }


    public String getLastName()
    {
        return lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getZip()
    {
        return zip;
    }

    public void setZip(int zip)
    {
        this.zip = zip;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    /**
     * @return the isAdmin
     */
    public boolean isAdmin()
    {
        return isAdmin;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @return the id
     */
    public int getUserId()
    {
        return id;
    }

}
