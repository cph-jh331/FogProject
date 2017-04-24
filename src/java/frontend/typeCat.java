/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.DataCtrl;
import logic.Part;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class typeCat {

//    public void typeCate(HttpServletRequest request, HttpServletResponse response, HttpSession session)
//            throws ServletException, IOException
//    {
//        String type = request.getParameter("TypeCategory");
//        session.setAttribute("type", type);
//        List<Part> typeCategory;
//        DataCtrl dataCtrl = new DataCtrl();
//        typeCategory = dataCtrl.getTypeCategory(type);
//        String category = typeCategory.get(0).getCategory();
//        session.setAttribute("category", category);
//        session.setAttribute("catList", typeCategory);
//        RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
//        rd.forward(request, response);
//    }
    
    public List<Part> typeCat(String typecategory, DataCtrl dataCtrl){
        List<Part> typeCategory = dataCtrl.getTypeCategory(typecategory);
        return typeCategory;
    }

}
