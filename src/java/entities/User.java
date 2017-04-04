/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Pva
 */
public class User {
    
    private int userId;
    private String email;
    private String userName;

    public User(int userId, String email, String userName) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
    }
    public User(String email, String userName){
        this.userName = userName;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    
    
    
    
    
}
