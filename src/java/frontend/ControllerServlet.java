/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.DataCtrl;
import backend.PartMapper;
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

@WebServlet(name = "ControllerServlet", urlPatterns =
{
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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        User user = (User) session.getAttribute("user");
        DataCtrl dataCtrl = new DataCtrl();

        if (action.equals("login"))
        {
            Login login = new Login();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            user = login.checkLogin(email, password, dataCtrl);
            if (user == null)
            {
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else
            {
                session.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("loggedIn.jsp");
                rd.forward(request, response);
            }
            return;
        }

        if (user != null && action.equals(""))
        {
            RequestDispatcher rd = request.getRequestDispatcher("loggedIn.jsp");
            rd.forward(request, response);
            return;
        }

        if (user == null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return;
        }

        if (action.equals("seelist"))
        {
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
        if (action.equals("seeTypeCategory"))
        {
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
        if (action.equals("addToDatabase"))
        {
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
        if (action.equals("removeFromDatabase"))
        {
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
