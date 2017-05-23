/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import backend.DataFacade;
import backend.UserAlreadyExistException;
import java.util.List;

/**
 *
 * @author bloch
 */
public class LogicCtrl {

    private DataFacade dataCtrl = new DataFacade();

    public void changeStatusOnSvg(int svgId, SvgDrawing.Status status)
    {
        dataCtrl.changeStatusOnSvg(svgId, status);
    }

    public SvgDrawing getSvgDrawingWithSvgId(int svgId)
    {
        return dataCtrl.getSvgDrawingWithSvgId(svgId);
    }

    public List<SvgDrawing> getAllSvgsWithCustomer(int customerId)
    {
        return dataCtrl.getAllSvgsWithCustomer(customerId);
    }

    public List<SvgDrawing> getCustomerSvgWithStatus(SvgDrawing.Status svgStatus, int customerId)
    {
        return dataCtrl.getCustomerSvgWithStatus(svgStatus, customerId);
    }

    public List<SvgDrawing> getAllSvgWithStatus(SvgDrawing.Status status)
    {
        return dataCtrl.getAllSvgWithStatus(status);
    }

    public User checkLogin(String email, String password)
    {
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

    public int parseId(String removeItem)
    {
        return Integer.parseInt(removeItem);
    }

    public List<Part> removePart(String type, int partId)
    {
        dataCtrl.removePart(partId);
        List<Part> catList = dataCtrl.getTypeCategory(type);
        return catList;
    }

    public List<Part> typeCat(String typecategory)
    {
        List<Part> typeCategory = dataCtrl.getTypeCategory(typecategory);
        return typeCategory;
    }

    public User addUser(String email, String firstname, String lastname, String adress, int zip, String city, int phone, String password) throws UserAlreadyExistException
    {
        User customer = new Customer(phone, email, firstname, lastname, adress, city, zip, phone, false);
        dataCtrl.insertUser(customer, password);

        //unit test til user validering i datactrl eller partMapper...
        return customer;
    }

    public String createSvgSideView(String height, String length)
    {
        SideDrawing sideDrawing = new SideDrawing();
        String svgImage = sideDrawing.createSideView(length, height);
        return svgImage;
    }

    public String createSvgTopView(String height, String length, String width)
    {
        TopDrawing topDrawing = new TopDrawing();
        String svgImage = topDrawing.createTopView(length, width, height);
        return svgImage;
    }

    public void saveSvg(String svgInline, int customerId)
    {
        dataCtrl.insertSvg(svgInline, customerId);

    }

    public boolean removeSvgDrawing(int svgId)
    {
        return dataCtrl.removeSvgDrawing(svgId);
    }

    public void remove(String removeImage, int customerId)
    {
        dataCtrl.removeS(removeImage, customerId);
    }

    public List<SvgDrawing> svgList(int customerId)
    {
        return dataCtrl.getDrawings(customerId);

    }

    public String getSvgInLine(List<SvgDrawing> drawList, int drawingId)
    {
        for (int i = 0; i < drawList.size(); i++)
        {
            if (drawingId == drawList.get(i).getSvgId())
            {
                return drawList.get(i).getSvgInline();
            }
        }
        return null;
    }

    public SvgDrawing getDrawing(List<SvgDrawing> drawList, int drawingId)
    {
        for (SvgDrawing svgDrawing : drawList)
        {
            if (svgDrawing.getSvgId() == drawingId)
            {
                return svgDrawing;
            }
        }
        return null;
    }

    public String whatToDoWithDrawing(SvgDrawing.Status status, Boolean isAdmin)
    {
        if (status.equals(SvgDrawing.Status.created))
        {
            return "svgreqapproval";
        } else if (status.equals(SvgDrawing.Status.reqApproved) && isAdmin == true)
        {
            return "approvedrawing";
        } else if (status.equals(SvgDrawing.Status.approved))
        {
            return "completeDrawing";
        } else
        {
            return "return";
        }
    }

    public String uiWhatToDoWithDrawingDanish(SvgDrawing.Status status, Boolean isAdmin)
    {
        if (status.equals(SvgDrawing.Status.created))
        {
            return "Send til fog";
        } else if (status.equals(SvgDrawing.Status.reqApproved) && isAdmin == true)
        {
            return "Godkend tegning";
        } else if (status.equals(SvgDrawing.Status.approved))
        {
            return "Afslut tegning";
        } else
        {
            return "Tilbage";
        }

    }

}
