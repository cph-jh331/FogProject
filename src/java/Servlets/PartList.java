package Servlets;

import entities.Part;
import entities.PieceList;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PartList {

    public void seeList(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException
    {
//        PieceList pl = new PieceList();
//        HashMap<Integer, Part> woodMap;
//        HashMap<Integer, Part> roofMap;
//        HashMap<Integer, Part> miscMap;
//
//        int length = Integer.parseInt(request.getParameter("length"));
//        int width = Integer.parseInt(request.getParameter("width"));
//        int height = Integer.parseInt(request.getParameter("height"));
//        pl.updateParts(length, width, height);
//        woodMap = pl.getWoodMap();
//        roofMap = pl.getRoofMap();
//        miscMap = pl.getMiscMap();
//        session.setAttribute("woodMap", woodMap);
//        session.setAttribute("roofMap", roofMap);
//        session.setAttribute("miscMap", miscMap);
//        RequestDispatcher rd = request.getRequestDispatcher("seelist.jsp");
//        rd.forward(request, response);
        
        PieceList pl = new PieceList();
        List<Part> woodList;
        List<Part> roofList;
        List<Part> miscList;

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        pl.updateParts(length, width, height);
        woodList = pl.getWoodList();
        roofList = pl.getRoofList();
        miscList = pl.getMiscList();
        session.setAttribute("woodMap", woodList);
        session.setAttribute("roofMap", roofList);
        session.setAttribute("miscMap", miscList);
        RequestDispatcher rd = request.getRequestDispatcher("seelist.jsp");
        rd.forward(request, response);

    }
}
