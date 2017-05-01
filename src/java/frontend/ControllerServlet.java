/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.DataCtrl;
import backend.UserMapper;
import logic.Part;
import logic.User;
import logic.Register;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControllerServlet", urlPatterns
        = {
            "/controllerServlet"
        })
public class ControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void checkSignUp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        UserMapper map = new UserMapper();

        HttpSession ses = request.getSession();
        String action2 = request.getParameter("action2");
        Register r = (Register) ses.getAttribute("r");
        DataCtrl dataCtrl = new DataCtrl();

        if (action2.equals("signup")) {

            Login login = new Login();

            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String adress = request.getParameter("adress");
            String zip = request.getParameter("zip");
            String city = request.getParameter("city");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            Hashtable errors = (Hashtable) request.getParameterMap();
        

        if (firstname.equals("")) {
            errors.put("firstname", "indtast venligst fornavn");

           
        }
        if (lastname.equals("")) {
            errors.put("lastname", "indtast venligst efternavn");
            
        }
        if (adress.equals("")) {
            errors.put("adress", "indtast venligts adresse");
            
        }
        if (zip.equals("") || zip.length() != 4) {
            errors.put("zip", "indtast venligt postnummer");
            
        } else {
            
            try {
                int x = Integer.parseInt(zip);
            } catch (NumberFormatException e) {
                errors.put("zip", "indtast venligst postnummer");
                

            }
        }

        if (city.equals("")) {
            errors.put("city", "indtast venligst by");
           
        }
        if (phone.equals("") || phone.length() != 8) {
            errors.put("phone", "indtast venligst tlfnummer");
            

        }
        if (email.equals("") || email.indexOf('@') == -1) {
            errors.put("email", "indtast venligst email");
            
        }
        if (password1.equals("")) {
            errors.put("password1", "indtast venligst password");
            
        }
        if (!password1.equals("") && (password2.equals("") || !password1.equals(password2))) {
            errors.put("password2", "bekræft venligst password");
           

        }else{
            

          // r = login.createUser(firstname, lastname, adress, zip, city, phone, email, password1, password2, errors, dataCtrl);
    }
            
            
           
            if (r == null) {
                ses.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                rd.forward(request, response);
            } else {
                ses.setAttribute("register", r);
                RequestDispatcher rd = request.getRequestDispatcher("signedin.jsp");
                rd.forward(request, response);

            }

            return;
        }
        if (r != null && action2.equals("")) {
        RequestDispatcher rd = request.getRequestDispatcher("signedin.jsp");
        rd.forward(request, response);
        return;
        }
        if (r == null) {
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
            return;
    }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        User user = (User) session.getAttribute("user");
        DataCtrl dataCtrl = new DataCtrl();

        if (action.equals("login")) {
            Login login = new Login();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            user = login.checkLogin(email, password, dataCtrl);
            if (user == null) {
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else {
                session.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("loggedIn.jsp");
                rd.forward(request, response);
            }
            return;
        }

        if (user != null && action.equals("")) {
            RequestDispatcher rd = request.getRequestDispatcher("loggedIn.jsp");
            rd.forward(request, response);
            return;
        }

        if (user == null) {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return;
        }

        if (action.equals("seelist")) {
            PartList partList = new PartList();
            String length = request.getParameter("length");
            String width = request.getParameter("width");
            String height = request.getParameter("height");
            partList.parseMeasure(length, width, height);
            partList.updateParts();
            session.setAttribute("woodMap", partList.getWoodList());
            session.setAttribute("roofMap", partList.getRoofList());
            session.setAttribute("miscMap", partList.getMiscList());
            RequestDispatcher rd = request.getRequestDispatcher("seelist.jsp");
            rd.forward(request, response);
            return;
        }
        if (action.equals("seeTypeCategory")) {
            typeCat tcat = new typeCat();
            String type = request.getParameter("TypeCategory");
            session.setAttribute("type", type);
            List<Part> typeCategory = tcat.typeCat(type, dataCtrl);
            String category = typeCategory.get(0).getCategory();
            session.setAttribute("category", category);
            session.setAttribute("catList", typeCategory);
            RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
            rd.forward(request, response);
            return;
        }
        if (action.equals("addToDatabase")) {
            AddToDatabase adb = new AddToDatabase();
            String type = request.getParameter("Type");
            String category = (String) session.getAttribute("category");
            String unitType = request.getParameter("Pakketype");
            String desc = request.getParameter("Beskrivelse");
            List<Part> catList = (List<Part>) session.getAttribute("catList");
            catList = adb.addTo(type, category, unitType, desc, catList, dataCtrl);
            session.setAttribute("catList", catList);
            RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
            rd.forward(request, response);
            return;
        }
        if (action.equals("removeFromDatabase")) {
            RemoveFromDatabase rfd = new RemoveFromDatabase();
            String removeId = request.getParameter("removeItem");
            String type = (String) session.getAttribute("type");
            session.setAttribute("type", type);
            rfd.parseId(removeId);
            List<Part> typeCategory = rfd.removePart(type, dataCtrl);
            session.setAttribute("catList", typeCategory);
            RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
            rd.forward(request, response);

            return;
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
