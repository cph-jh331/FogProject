/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.DataCtrl;
import backend.PartMapper;
import logic.Part;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bloch
 */
public class RemoveFromDatabase {
    
    private int id;

//    public void removePar2t(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
//    {
//        int removeId = Integer.parseInt(request.getParameter("removeItem"));
//        String type = (String) session.getAttribute("type");
//        session.setAttribute("type", type);
//        DataCtrl dataCtrl = new DataCtrl();
//        dataCtrl.removePart(removeId);
//        List<Part> typeCategory = dataCtrl.getTypeCategory(type);
//        session.setAttribute("catList", typeCategory);
//        RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
//        rd.forward(request, response);
//    }
    
    public void parseId(String removeItem){
        this.id = Integer.parseInt(removeItem);
    }
    
    public List<Part> removePart(String type, DataCtrl dataCtrl){
        dataCtrl.removePart(id);
        List<Part> catList = dataCtrl.getTypeCategory(type);
        return catList;
    }

}
