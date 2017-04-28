package frontend;

import backend.DataCtrl;
import backend.UserMapper;
import logic.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Register;

public class Login {
    //checks if the user is there.

//    public void checkLogin(HttpServletRequest request, HttpServletResponse response, User user, HttpSession session)
//            throws ServletException, IOException
//    {
//        DataCtrl dataCtrl = new DataCtrl();
//
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        user = dataCtrl.validateUser(email, password);
//        if (user == null)
//        {
//            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//            rd.forward(request, response);
//        } else
//        {
//            session.setAttribute("user", user);
//            RequestDispatcher rd = request.getRequestDispatcher("loggedIn.jsp");
//            rd.forward(request, response);
//        }
//
//    }
    
    public void checkSignUp(HttpServletRequest request, HttpServletResponse response, Register r, HttpSession session)
            throws ServletException, IOException {
        UserMapper map = new UserMapper();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String adress = request.getParameter("adress");
        String zip = request.getParameter("zip");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password1");
        Hashtable>String = request.getParameterMap("errors");
         
        r = map.validate(firstname, lastname, adress, zip, city, phone, email, password, errors);
        if(r==null){
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
            } else {
                session.setAttribute("register", r);
                RequestDispatcher rd = request.getRequestDispatcher("signedin.jsp");
                rd.forward(request, response);
            }
                        
    }
    public User checkLogin(String email, String password, DataCtrl dataCtrl)
    {
        User user = dataCtrl.validateUser(email, password);
        return user;

    }

}
