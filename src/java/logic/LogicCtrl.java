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

    public boolean canParseString(String string)
    {
        try
        {
            Integer.parseInt(string);
        } catch (Exception illegalFormatException)
        {
            return false;
        }
        return true;
    }

    public User checkLogin(String email, String password)
    {
        //User user = dataCtrl.validateUser(email, password);
        User user = dataCtrl.validateCustomer(email, password);
        return user;
    }
    public User checkAdminLogin(String email, String password)
    {
       User user = dataCtrl.validateAdmin(email, password);
       
        return user;
    }

    public boolean checkAdmin(User user)
    {
        return user.isAdmin();
    }

    public List<Part> addTo(String type, String category, String unitType, String desc, List<Part> catList)
    {
        String typeCat = catList.get(0).getTypeCategory();
        Part part = new Part(type, unitType, desc, category, typeCat);
        dataCtrl.addPart(part);
        catList = dataCtrl.getTypeCategory(typeCat);
        return catList;
    }

    public void parseId(String removeItem)
    {
        this.id = Integer.parseInt(removeItem);
    }

    public List<Part> removePart(String type)
    {
        dataCtrl.removePart(id);
        List<Part> catList = dataCtrl.getTypeCategory(type);
        return catList;
    }

    public List<Part> typeCat(String typecategory)
    {
        List<Part> typeCategory = dataCtrl.getTypeCategory(typecategory);
        return typeCategory;
    }

    public User addUser(String email, String firstname, String lastname, String adress, int zip, String city, int phone, String password)
    {
        User user = new User(email, firstname, lastname, adress, city, zip, phone, password);
        dataCtrl.insertUser(user);

        //unit test til user validering i datactrl eller partMapper...
        return user;
    }
    
    public String createSvgSideView(String height, String length, String width){
        SideDrawing sideDrawing = new SideDrawing();
        String svgImage = sideDrawing.createSideView(length, width, height);
        return svgImage;
    }
    public String createSvgTopView(String height, String length, String width){
        TopDrawing topDrawing = new TopDrawing();
        String svgImage = topDrawing.createTopView(length, width, height);
        return svgImage;
    }
//    public SvgDrawing saveSvg (int svgId, String svgInline, int userId, String dateCreated, String dateAccepted, boolean accepted){
//        SvgDrawing svgDrawing = new SvgDrawing(svgId, svgInline, userId, dateCreated, dateAccepted, accepted);
//        dataCtrl.insertSvg(svgInline, userId);
//        return svgDrawing;
//    }
     public void saveSvg (String svgInline, int userId){
        dataCtrl.insertSvg(svgInline, userId);
       
    }
     public List<SvgDrawing> svgList(int userId){
         return dataCtrl.getDrawings(userId);
         
     }
    //CreateSvg
    //SaveSvg
}
