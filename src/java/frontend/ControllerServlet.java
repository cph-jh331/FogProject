/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;



import logic.Part;
import logic.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicCtrl;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        //String actionSign = request.getParameter("actionSign");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        LogicCtrl lc = new LogicCtrl();

        if (action.equals("login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            user = lc.checkLogin(email, password);
            if (user == null) {
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else {
                session.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
            }
            return;
        }
        if (action.equals("signup")) {
            
            String email = request.getParameter("email");
            String firstname = request.getParameter("Fornavn");
            String lastname = request.getParameter("Efternavn");
            String adress = request.getParameter("Adresse");
            String zipStr = request.getParameter("Postnummer");
            String city = request.getParameter("By");
            String phoneStr = request.getParameter("telefon");
            String password = request.getParameter("psw");
            int zip = Integer.parseInt(zipStr);
            int phone = Integer.parseInt(phoneStr);
            user = lc.addUser(email, firstname, lastname, adress, zip, city, phone, password);
            user = lc.checkLogin(email, password);
            session.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("loggedIn.jsp");
            rd.forward(request, response);
            return;
            //Check Login with parameters before putting parameters into Db.
            
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

            String type = request.getParameter("TypeCategory");
            session.setAttribute("type", type);
            List<Part> typeCategory = lc.typeCat(type);
            String category = typeCategory.get(0).getCategory();
            session.setAttribute("category", category);
            session.setAttribute("catList", typeCategory);
            RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
            rd.forward(request, response);
            return;
        }
        if (action.equals("addToDatabase")) {
            String type = request.getParameter("Type");
            String category = (String) session.getAttribute("category");
            String unitType = request.getParameter("Pakketype");
            String desc = request.getParameter("Beskrivelse");
            List<Part> catList = (List<Part>) session.getAttribute("catList");
            catList = lc.addTo(type, category, unitType, desc, catList);
            session.setAttribute("catList", catList);
            RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
            rd.forward(request, response);
            return;
        }
        if (action.equals("removeFromDatabase")) {
            String removeId = request.getParameter("removeItem");
            String type = (String) session.getAttribute("type");
            session.setAttribute("type", type);
            lc.parseId(removeId);
            List<Part> typeCategory = lc.removePart(type);
            session.setAttribute("catList", typeCategory);
            RequestDispatcher rd = request.getRequestDispatcher("typeCat.jsp");
            rd.forward(request, response);

            return;
        }
//             if(action.equals("hej")){
//            RequestDispatcher rd = request.getRequestDispatcher("adminpanel.jsp");
//            rd.forward(request, response);
//            return;
        //}
        }
//        if(action.equals("blueAccept")){
//           // Fog skal hente fra en liste hvori, der bliver vist de kunder der er klar til godkendelse af carport.
//           // den liste skal sendes videre gennem lagene (klasserne).
//           // fog skal have mulighed for at se og godkende kundernes tegning.
//           blueAccept ba = new blueAccept();
//
//            if(action.equals("draw")){
//                RequestDispatcher rd = request.getRequestDispatcher("")
//             Ja/nej til submit button. Sender metoden videre, og så skal der vises noget nyt på siden. 
//             if(ja){
//                 Godkendes tegning - Og hvad så? besked sendes til kunden.
//             } else {
//                 Kasseres tegningen - og hvad så?
//             }
             

    

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
