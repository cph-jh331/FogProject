package frontend;

import backend.DataCtrl;
import backend.UserMapper;
import logic.User;

import java.io.IOException;
import java.util.Hashtable;
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
    
    public Register createUser(String firstname, String lastname, String adress, String zip, String city, String phone, String email, String password1, String password2, Hashtable errors, DataCtrl dataCtrl){
        
        Register reg = dataCtrl.validate(firstname, lastname, adress, zip, city, phone, email, password1, password2, errors);
        return reg;
        
       
            }
         
        
        
        
            
    public User checkLogin(String email, String password, DataCtrl dataCtrl)
    {
        User user = dataCtrl.validateUser(email, password);
        return user;

    }

   

}
