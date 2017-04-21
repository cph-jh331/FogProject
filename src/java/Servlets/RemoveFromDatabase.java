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
 * @author bloch
 */
public class RemoveFromDatabase {

    public void removePart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
    {
        int removeId = Integer.parseInt(request.getParameter("removeItem"));
        String type = (String) session.getAttribute("type");
        session.setAttribute("type", type);
        PartMapper pm = new PartMapper();
        pm.removePart(removeId);
        List<Part> typeCategory = pm.getTypeCategory(type);
        session.setAttribute("catList", typeCategory);
        RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
        rd.forward(request, response);

    }

}
