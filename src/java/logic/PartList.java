package logic;

import backend.DataFacade;
import logic.Part;
import logic.PieceList;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PartList {

//    //prints out a list
//    public void seeList2(HttpServletRequest request, HttpServletResponse response, HttpSession session)
//            throws ServletException, IOException
//    {
////        PieceList pl = new PieceList();
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

//        PieceList pl = new PieceList();
//        List<Part> woodList;
//        List<Part> roofList;
//        List<Part> miscList;
//
//        int length = Integer.parseInt(request.getParameter("length"));
//        int width = Integer.parseInt(request.getParameter("width"));
//        int height = Integer.parseInt(request.getParameter("height"));
//        pl.updateParts(length, width, height);
//        woodList = pl.getWoodList();
//        roofList = pl.getRoofList();
//        miscList = pl.getMiscList();
//        session.setAttribute("woodMap", woodList);
//        session.setAttribute("roofMap", roofList);
//        session.setAttribute("miscMap", miscList);
//        RequestDispatcher rd = request.getRequestDispatcher("seelist.jsp");
//        rd.forward(request, response);
//
//    }

    private final PieceList pieceList;
    private int height;
    private int width;
    private int length;

    public PartList()
    {
        pieceList = new PieceList();
    }

    public void parseMeasure(String len, String wid, String hei)
    {
        this.length = Integer.parseInt(len);
        this.height = Integer.parseInt(hei);
        this.width = Integer.parseInt(wid);
    }

    public void updateParts()
    {
        pieceList.updateParts(length, width, height);
    }

    public List<Part> getWoodList()
    {
        List<Part> woodList = pieceList.getWoodList();
        return woodList;
    }

    public List<Part> getRoofList()
    {
        List<Part> roofList = pieceList.getRoofList();
        return roofList;
    }

    public List<Part> getMiscList()
    {
        List<Part> woodList = pieceList.getMiscList();
        return woodList;
    }

}
