package Servlets;

import backend.UserMapper;
import entities.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login {
    //checks if the user is there.

        public void checkLogin(HttpServletRequest request, HttpServletResponse response, User user, HttpSession session)
            throws ServletException, IOException
    {
        UserMapper uMapper = new UserMapper();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        user = uMapper.validateUser(email, password);
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

    }

    

}
