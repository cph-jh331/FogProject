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

    private DataFacade dataFacade;

    public LogicCtrl()
    {
        dataFacade = new DataFacade();
    }

    public void changeStatusOnSvg(int svgId, SvgDrawing.Status status)
    {
        dataFacade.changeStatusOnSvg(svgId, status);
    }

    public SvgDrawing getSvgDrawingWithSvgId(int svgId)
    {
        return dataFacade.getSvgDrawingWithSvgId(svgId);
    }

    public List<SvgDrawing> getAllSvgsWithCustomer(int customerId)
    {
        return dataFacade.getAllSvgsWithCustomer(customerId);
    }

    public List<SvgDrawing> getCustomerSvgWithStatus(SvgDrawing.Status svgStatus, int customerId)
    {
        return dataFacade.getCustomerSvgWithStatus(svgStatus, customerId);
    }

    public List<SvgDrawing> getAllSvgWithStatus(SvgDrawing.Status status)
    {
        return dataFacade.getAllSvgWithStatus(status);
    }

    public User checkLogin(String email, String password)
    {
        User user = dataFacade.validateCustomer(email, password);
        return user;
    }

    public User checkAdminLogin(String email, String password)
    {
        User user = dataFacade.validateAdmin(email, password);

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
        dataFacade.addPart(part);
        catList = dataFacade.getTypeCategory(typeCat);
        return catList;
    }

    public int parseId(String removeItem)
    {
        return Integer.parseInt(removeItem);
    }

    public List<Part> removePart(String type, int partId)
    {
        dataFacade.removePart(partId);
        List<Part> catList = dataFacade.getTypeCategory(type);
        return catList;
    }

    public List<Part> typeCat(String typecategory)
    {
        List<Part> typeCategory = dataFacade.getTypeCategory(typecategory);
        return typeCategory;
    }

    public User addUser(String email, String firstname, String lastname, String address, int zip, String city, int phone, String password) throws UserAlreadyExistException
    {
        User customer = new Customer(9999, email, firstname, lastname, address, city, zip, phone, false);
        dataFacade.insertUser(customer, password);
        
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
        dataFacade.insertSvg(svgInline, customerId);

    }

    public boolean removeSvgDrawing(int svgId)
    {
        return dataFacade.removeSvgDrawing(svgId);
    }

    public void remove(String removeImage, int customerId)
    {
        dataFacade.removeDrawing(removeImage, customerId);
    }

    public List<SvgDrawing> svgList(int customerId)
    {
        return dataFacade.getDrawings(customerId);

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
        if (status.equals(SvgDrawing.Status.CREATED))
        {
            return "svgreqapproval";
        } else if (status.equals(SvgDrawing.Status.REQAPPROVED) && isAdmin == true)
        {
            return "approvedrawing";
        } else if (status.equals(SvgDrawing.Status.APPROVED))
        {
            return "completeDrawing";
        } else
        {
            return "return";
        }
    }

    public String uiWhatToDoWithDrawingDanish(SvgDrawing.Status status, Boolean isAdmin)
    {
        if (status.equals(SvgDrawing.Status.CREATED))
        {
            return "Send til fog";
        } else if (status.equals(SvgDrawing.Status.REQAPPROVED) && isAdmin == true)
        {
            return "Godkend tegning";
        } else if (status.equals(SvgDrawing.Status.APPROVED))
        {
            return "Afslut tegning";
        } else
        {
            return "Tilbage";
        }

    }

}
