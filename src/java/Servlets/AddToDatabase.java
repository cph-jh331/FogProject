/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import backend.PartMapper;
import entities.Part;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lasse Andersen
 */
public class AddToDatabase {
    public void addTo(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
        String type = request.getParameter("Type");
        String category = request.getParameter("Kategori");
        String unitname = request.getParameter("Pakketype");
        String decs = request.getParameter("Beskrivelse");
        List<Part> catList = (List<Part>) session.getAttribute("catList");
        String typCat = catList.get(0).getTypeCategory();
        
        Part part = new Part(type, unitname, decs, category, typCat);
        PartMapper pm = new PartMapper();
        catList.add(part);
        session.setAttribute("catList", catList);
        pm.addPart(part);
        RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
        rd.forward(request, response);
        

    }
}
