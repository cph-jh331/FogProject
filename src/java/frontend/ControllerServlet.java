/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.UserAlreadyExistException;
import logic.Part;
import logic.Customer;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicCtrl;
import logic.SvgDrawing;

@WebServlet(name = "ControllerServlet", urlPatterns
        =
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

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user");
        LogicCtrl lc = new LogicCtrl();

        //TopDrawing topDrawingSvg = new TopDrawing();
        //topDrawingSvg.createSvg(length, width, height);
        if (action == null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
            return;
        }
        if (action.equals("drawlist"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("adminpanel.jsp");
            rd.forward(request, response);
            return;

        }

        if (action.equals("logout"))
        {
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
            return;
        }
        if (customer != null && action.equals("admin"))
        {
            if (lc.checkAdmin(customer) == true)
            {
                RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
            } else
            {
                RequestDispatcher rd = request.getRequestDispatcher("loggedin.jsp");
                rd.forward(request, response);
            }
            return;
        }
        if (customer != null && action.equals("customer"))
        {
            if (lc.checkAdmin(customer) == true)
            {
                RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
            } else
            {
                RequestDispatcher rd = request.getRequestDispatcher("loggedin.jsp");
                rd.forward(request, response);
            }
            return;
        }
        if (action.equals("admin"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
            rd.forward(request, response);
            return;
        }
        if (action.equals("customer"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return;
        }

        if (action.equals("adminlogin"))
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            customer = lc.checkAdminLogin(email, password);

            if (customer == null)
            {
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
            } else
            {
                session.setAttribute("user", customer);
                if (lc.checkAdmin(customer) == true)
                {
                    List<SvgDrawing> svgsReqApproval = lc.getAllSvgWithStatus(SvgDrawing.Status.reqApproved);
                    List<SvgDrawing> svgsApproved = lc.getAllSvgWithStatus(SvgDrawing.Status.approved);
                    List<SvgDrawing> svgsDone = lc.getAllSvgWithStatus(SvgDrawing.Status.done);
                    session.setAttribute("svgMapReqApproval", svgsReqApproval);
                    session.setAttribute("svgMapApproved", svgsApproved);
                    session.setAttribute("svgMapDone", svgsDone);
                    RequestDispatcher rd = request.getRequestDispatcher("loggedinadmin.jsp");
                    rd.forward(request, response);
                } else
                {
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                }
            }
            return;
        }
        if (action.equals("customerlogin"))
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            customer = lc.checkLogin(email, password);
            if (customer == null)
            {
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else
            {
                session.setAttribute("user", customer);
                if (lc.checkAdmin(customer) == false)
                {
                    session.setAttribute("listDrawings", lc.getAllSvgsWithCustomer(customer.getCustomerId()));
                    List<SvgDrawing> svgsReqApproval = lc.getCustomerSvgWithStatus(SvgDrawing.Status.reqApproved, customer.getCustomerId());
                    List<SvgDrawing> svgsApproved = lc.getCustomerSvgWithStatus(SvgDrawing.Status.approved, customer.getCustomerId());
                    List<SvgDrawing> svgsDone = lc.getCustomerSvgWithStatus(SvgDrawing.Status.done, customer.getCustomerId());
                    session.setAttribute("svgMapReqApproval", svgsReqApproval);
                    session.setAttribute("svgMapApproved", svgsApproved);
                    session.setAttribute("svgMapDone", svgsDone);
                    RequestDispatcher rd = request.getRequestDispatcher("loggedin.jsp");
                    rd.forward(request, response);
                } else
                {
                    RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                    rd.forward(request, response);
                }
            }
            return;
        }

        //ikke done.
        if (action.equals("genDrawing"))
        {
            String length = request.getParameter("length");
            String width = request.getParameter("width");
            String height = request.getParameter("height");
            String svgInlineTop = lc.createSvgSideView(height, length, width);
            session.setAttribute("topDrawing", svgInlineTop);
            RequestDispatcher rd = request.getRequestDispatcher("drawing.jsp");
            rd.forward(request, response);
            return;
        }

        if (action.equals("seeDrawing"))
        {
            int drawingId = Integer.parseInt(request.getParameter("drawId"));
            session.setAttribute("drawingId", drawingId);
            SvgDrawing svgDrawing = lc.getSvgDrawingWithSvgId(drawingId);
            session.setAttribute("svgDrawing", svgDrawing);
            String whatToDo = lc.whatToDoWithDrawing(svgDrawing.getStatus(), customer.isAdmin());
            String uiDanishSubmitButton = lc.uiWhatToDoWithDrawingDanish(svgDrawing.getStatus(), customer.isAdmin());
            session.setAttribute("whatToDo", whatToDo);
            session.setAttribute("seeDrawingSubmitButton", uiDanishSubmitButton);
            RequestDispatcher rd = request.getRequestDispatcher("seeDrawing.jsp");
            rd.forward(request, response);
        }

        if (action.equals("signup"))
        {

            String email = request.getParameter("email");
            String firstname = request.getParameter("Fornavn");
            String lastname = request.getParameter("Efternavn");
            String address = request.getParameter("Adresse");
            String zipStr = request.getParameter("Postnummer");
            String city = request.getParameter("By");
            String phoneStr = request.getParameter("telefon");
            String password = request.getParameter("psw");
            int zip = Integer.parseInt(zipStr);
            int phone = Integer.parseInt(phoneStr);

            try
            {
                customer = lc.addUser(email, firstname, lastname, address, zip, city, phone, password);
            } catch (UserAlreadyExistException ex)
            {
                request.setAttribute("errorMessage", ex.toString());
                RequestDispatcher rd = request.getRequestDispatcher("failed.jsp");
                rd.forward(request, response);
            }
            customer = lc.checkLogin(email, password);
            session.setAttribute("user", customer);
            RequestDispatcher rd = request.getRequestDispatcher("loggedin.jsp");
            rd.forward(request, response);
            return;
            //Check Login with parameters before putting parameters into Db.
        }

        if (customer == null)
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
        if (action.equals("addToDatabase"))
        {
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
        if (action.equals("removeFromDatabase"))
        {
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
        if (action.equals("removesvg"))
        {
            String removeImage = (String) session.getAttribute("topDrawing");
            customer = (Customer) session.getAttribute("user");
            int customerId = customer.getCustomerId();
            lc.remove(removeImage, customerId);
            List<SvgDrawing> liste = lc.svgList(customerId);
            session.setAttribute("listDrawings", liste);
            RequestDispatcher rd = request.getRequestDispatcher("adminpanel.jsp");
            rd.forward(request, response);
            return;
        }

        if (action.equals("seeDrawing"))
        {
            int drawingId = Integer.parseInt(request.getParameter("drawId"));
            session.setAttribute("drawingId", drawingId);
            SvgDrawing svgDrawing = lc.getSvgDrawingWithSvgId(drawingId);
            session.setAttribute("svgDrawing", svgDrawing);
            String whatToDo = lc.whatToDoWithDrawing(svgDrawing.getStatus(), customer.isAdmin());
            String uiDanishSubmitButton = lc.uiWhatToDoWithDrawingDanish(svgDrawing.getStatus(), customer.isAdmin());
            session.setAttribute("whatToDo", whatToDo);
            session.setAttribute("seeDrawingSubmitButton", uiDanishSubmitButton);
            RequestDispatcher rd = request.getRequestDispatcher("seeDrawing.jsp");
            rd.forward(request, response);
        }

        if (action.equals("svgRemoveDrawing"))
        {
            SvgDrawing svgdrawing = (SvgDrawing) session.getAttribute("svgDrawing");
            lc.removeSvgDrawing(svgdrawing.getSvgId());
            String jsp;
            if (customer.isAdmin())
            {
                jsp = "adminpanel.jsp";
            } else
            {
                jsp = "loggedin.jsp";
            }
            session.setAttribute("listDrawings", lc.getAllSvgsWithCustomer(customer.getCustomerId()));
            List<SvgDrawing> svgsReqApproval = lc.getCustomerSvgWithStatus(SvgDrawing.Status.reqApproved, customer.getCustomerId());
            List<SvgDrawing> svgsApproved = lc.getCustomerSvgWithStatus(SvgDrawing.Status.approved, customer.getCustomerId());
            List<SvgDrawing> svgsDone = lc.getCustomerSvgWithStatus(SvgDrawing.Status.done, customer.getCustomerId());
            session.setAttribute("svgMapReqApproval", svgsReqApproval);
            session.setAttribute("svgMapApproved", svgsApproved);
            session.setAttribute("svgMapDone", svgsDone);
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }

        if (action.equals("svgreqapproval"))
        {
            int svgId = (Integer) session.getAttribute("drawingId");
            lc.changeStatusOnSvg(svgId, SvgDrawing.Status.reqApproved);
            session.setAttribute("listDrawings", lc.getAllSvgsWithCustomer(customer.getCustomerId()));
            List<SvgDrawing> svgsReqApproval = lc.getCustomerSvgWithStatus(SvgDrawing.Status.reqApproved, customer.getCustomerId());
            List<SvgDrawing> svgsApproved = lc.getCustomerSvgWithStatus(SvgDrawing.Status.approved, customer.getCustomerId());
            List<SvgDrawing> svgsDone = lc.getCustomerSvgWithStatus(SvgDrawing.Status.done, customer.getCustomerId());
            session.setAttribute("svgMapReqApproval", svgsReqApproval);
            session.setAttribute("svgMapApproved", svgsApproved);
            session.setAttribute("svgMapDone", svgsDone);
            RequestDispatcher rd = request.getRequestDispatcher("loggedin.jsp");
            rd.forward(request, response);
        }

        if (action.equals("approvedrawing"))
        {
            int svgId = (Integer) session.getAttribute("drawingId");
            lc.changeStatusOnSvg(svgId, SvgDrawing.Status.approved);
            List<SvgDrawing> svgsReqApproval = lc.getCustomerSvgWithStatus(SvgDrawing.Status.reqApproved, customer.getCustomerId());
            List<SvgDrawing> svgsApproved = lc.getCustomerSvgWithStatus(SvgDrawing.Status.approved, customer.getCustomerId());
            List<SvgDrawing> svgsDone = lc.getCustomerSvgWithStatus(SvgDrawing.Status.done, customer.getCustomerId());
            session.setAttribute("svgMapReqApproval", svgsReqApproval);
            session.setAttribute("svgMapApproved", svgsApproved);
            session.setAttribute("svgMapDone", svgsDone);
            RequestDispatcher rd = request.getRequestDispatcher("adminpanel.jsp");
            rd.forward(request, response);
        }

        if (action.equals("savedrawing"))
        {
            String svgImage = (String) session.getAttribute("topDrawing");
            customer = (Customer) session.getAttribute("user");
            int customerId = customer.getCustomerId();
            lc.saveSvg(svgImage, customerId);
            List<SvgDrawing> list = lc.svgList(customerId);
            session.setAttribute("listDrawings", list);
            RequestDispatcher rd = request.getRequestDispatcher("loggedin.jsp");
            rd.forward(request, response);
            return;
        }

        if (action.equals("refusedrawing"))
        {

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
