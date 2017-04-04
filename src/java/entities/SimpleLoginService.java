/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import backend.DataAccessObject;

/**
 *
 * @author Lasse Andersen
 */
public class SimpleLoginService implements LoginService {

     
    
    
    @Override
    public User login(String userName, String email) {
        
       if("test@test.dk".equals(email) && "Bob".equals(userName)){
           return new User(email, userName);
       }
       return null;
    }
    
}
