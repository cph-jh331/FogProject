/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import backend.UserMapper;
import entities.Part;
import entities.PieceList;
import entities.User;
import java.io.IOException;
import java.util.HashMap;
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

    UserMapper dao = new UserMapper();
    PieceList pl = new PieceList();

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
        HttpSession session = request.getSession();
        String seelist = request.getParameter("seelist");
        HashMap<Integer, Part> woodMap = (HashMap<Integer, Part>) session.getAttribute("woodMap");
        HashMap<Integer, Part> roofMap = (HashMap<Integer, Part>) session.getAttribute("roofMap");
        HashMap<Integer, Part> miscMap = (HashMap<Integer, Part>) session.getAttribute("miscMap");
        String action = request.getParameter("action");
        User user = (User) session.getAttribute("user");

        if (action != null)
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            user = dao.validateUser(email, password);
            if (user == null)
            {
                RequestDispatcher rd = request.getRequestDispatcher("failed.jsp");
                rd.forward(request, response);
            } else
            {
                request.getSession().setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);

            }
        }

        if (seelist != null)
        {
            if (seelist.equals("seelist"))
            {
                int length = Integer.parseInt(request.getParameter("length"));
                int width = Integer.parseInt(request.getParameter("width"));
                int height = Integer.parseInt(request.getParameter("height"));
                pl.updateParts(length, width, height);
                woodMap = pl.getWoodMap();
                roofMap = pl.getRoofMap();
                miscMap = pl.getMiscMap();
                session.setAttribute("woodMap", woodMap);
                session.setAttribute("roofMap", roofMap);
                session.setAttribute("miscMap", miscMap);
                RequestDispatcher rd = request.getRequestDispatcher("seelist.jsp");
                rd.forward(request, response);
            }
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
