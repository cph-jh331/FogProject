/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

public class UserAlreadyExistException extends Exception {
    
    public UserAlreadyExistException(String str)
    {        
        super(str);
    }
    
}

