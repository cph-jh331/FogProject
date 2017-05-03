/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import backend.DataCtrl;
import java.util.List;

/**
 *
 * @author bloch
 */
public class LogicCtrl {
    
    private int id;
DataCtrl dataCtrl = new DataCtrl();
    public boolean canParseString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception illegalFormatException) {
            return false;
        }
        return true;
    }

    public User checkLogin(String email, String password) {
        //User user = dataCtrl.validateUser(email, password);
        User user = dataCtrl.validateUser(email, password);
        return user;

    }
    public List<Part> addTo(String type, String category, String unitType, String desc, List<Part> catList)
    {
        String typeCat = catList.get(0).getTypeCategory();
        Part part = new Part(type, unitType, desc, category, typeCat);
        dataCtrl.addPart(part);
        catList = dataCtrl.getTypeCategory(typeCat);
        return catList;
    }
    public void parseId(String removeItem){
        this.id = Integer.parseInt(removeItem);
    }
    public List<Part> removePart(String type){
        dataCtrl.removePart(id);
        List<Part> catList = dataCtrl.getTypeCategory(type);
        return catList;
    }
    public List<Part> typeCat(String typecategory){
        List<Part> typeCategory = dataCtrl.getTypeCategory(typecategory);
        return typeCategory;
    }
    public User addUser(String email, String firstname,String lastname, String adress,int zip, String city, int phone, String password)   
    {
        User user = new User(email, firstname, lastname, adress, city, zip, phone, password);
        dataCtrl.insertUser(user);
        
    //unit test til user validering i datactrl eller partMapper...
    return user;
    } 
}
