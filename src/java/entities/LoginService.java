/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Lasse Andersen
 */
public interface LoginService {
    public User login(String userName, String email);
 
}
