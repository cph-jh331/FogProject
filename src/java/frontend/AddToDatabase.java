/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.DataCtrl;
import logic.Part;
import java.util.List;
import logic.User;

/**
 *
 * @author Lasse Andersen
 */
public class AddToDatabase {

//    public void addTo2(HttpServletRequest request, HttpServletResponse response, HttpSession session)
//            throws ServletException, IOException
//    {
//        String type = request.getParameter("Type"); //er navnet
//        String category = (String) session.getAttribute("category"); //er kategorien, fx træ
//        String unitname = request.getParameter("Pakketype"); // er pakketypen, fx stk
//        String decs = request.getParameter("Beskrivelse"); // er beskrivelse
//        List<Part> catList = (List<Part>) session.getAttribute("catList"); //vi henter listen
//        String typCat = catList.get(0).getTypeCategory(); //vi tager typekategorien, fx skruer.
//        Part part = new Part(type, unitname, decs, category, typCat); //vi laver en ny part
//        DataCtrl dataCtrl = new DataCtrl(); // vi laver en instans af partmapper.
//        dataCtrl.addPart(part); // vi adder part til databasen.
//        catList = dataCtrl.getTypeCategory(typCat); // vi henter listen fra databasen med typekategorien..
//        session.setAttribute("catList", catList); // vi sætter listen på sessionen.
//        RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp"); // vi gør klar til at sende personen videre til typeCat.jsp.
//        rd.forward(request, response); // vi sender personen videre til typeCat.jsp.        
//    }

    public List<Part> addTo(String type, String category, String unitType, String desc, List<Part> catList, DataCtrl dataCtrl)
    {
        String typeCat = catList.get(0).getTypeCategory();
        Part part = new Part(type, unitType, desc, category, typeCat);
        dataCtrl.addPart(part);
        catList = dataCtrl.getTypeCategory(typeCat);
        return catList;
    }

    public boolean addUser(String email, String userName, String lastName, String address, String city, Integer zip, Integer phone, DataCtrl dataCtrl)   
    {
        User user = new User(email, userName, lastName, address, city, zip, phone);
        dataCtrl.insertUser(user);
        return true;
                
    }
}
