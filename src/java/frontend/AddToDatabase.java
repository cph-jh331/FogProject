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
        String type = request.getParameter("Type"); //er navnet
        String category = (String) session.getAttribute("category"); //er kategorien, fx træ
        String unitname = request.getParameter("Pakketype"); // er pakketypen, fx stk
        String decs = request.getParameter("Beskrivelse"); // er beskrivelse
        List<Part> catList = (List<Part>) session.getAttribute("catList"); //vi henter listen
        String typCat = catList.get(0).getTypeCategory(); //vi tager typekategorien, fx skruer.
        Part part = new Part(type, unitname, decs, category, typCat); //vi laver en ny part
        PartMapper pm = new PartMapper(); // vi laver en instans af partmapper.
        pm.addPart(part); // vi adder part til databasen.
        catList = pm.getTypeCategory(typCat); // vi henter listen fra databasen med typekategorien..
        session.setAttribute("catList", catList); // vi sætter listen på sessionen.
        RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp"); // vi gør klar til at sende personen videre til typeCat.jsp.
        rd.forward(request, response); // vi sender personen videre til typeCat.jsp.
        

    }
}
