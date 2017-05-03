/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Pva
 */
//public class Admin {
//    
//}
//            //en masse stuff til evt signup creation. ! 
////     til jsp siden       <label><b>Repeat Password</b></label>
////     til jsp siden <input type="password" placeholder="Gentag Password" name="psw-repeat" required>
////            String password2 = request.getParameter("psw-repeat");
////            Hashtable errors = (Hashtable) request.getParameterMap();
////
////            if (firstname.equals("")) {
////                errors.put("firstname", "indtast venligst fornavn");
////
////            }
////            if (lastname.equals("")) {
////                errors.put("lastname", "indtast venligst efternavn");
////
////            }
////            if (adress.equals("")) {
////                errors.put("adress", "indtast venligts adresse");
////
////            }
////            if (zip.equals("") || zip.length() != 4) {
////                errors.put("zip", "indtast venligt postnummer");
////
////            } else {
////
////                try {
////                    int x = Integer.parseInt(zip);
////                } catch (NumberFormatException e) {
////                    errors.put("zip", "indtast venligst postnummer");
////
////                }
////            }
////
////            if (city.equals("")) {
////                errors.put("city", "indtast venligst by");
////
////            }
////            if (phone.equals("") || phone.length() != 8) {
////                errors.put("phone", "indtast venligst tlfnummer");
////
////            }
////            if (email.equals("") || email.indexOf('@') == -1) {
////                errors.put("email", "indtast venligst email");
////
////            }
////            if (password1.equals("")) {
////                errors.put("password1", "indtast venligst password");
////
////            }
////            if (!password1.equals("") && (password2.equals("") || !password1.equals(password2))) {
////                errors.put("password2", "bekræft venligst password");
////
////            } else {
////                    login.
////                r = login.createUser(firstname, lastname, adress, zip, city, phone, email, password1, password2, errors, dataCtrl);
////            }
////
////            if (r == null) {
////                ses.invalidate();
////                RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
////                rd.forward(request, response);
////            } else {
////                ses.setAttribute("register", r);
////                RequestDispatcher rd = request.getRequestDispatcher("signedin.jsp");
////                rd.forward(request, response);
////
////            }
////
////            return;
////        }
////        if (r != null && action2.equals("")) {
////            RequestDispatcher rd = request.getRequestDispatcher("signedin.jsp");
////            rd.forward(request, response);
////            return;
////        }
////        if (r == null) {
////            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
////            rd.forward(request, response);
////            return;
//        
//    }