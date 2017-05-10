package backend;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import logic.Customer;
import logic.Part;
import logic.User;
import logic.Register;
import logic.SvgDrawing;

/**
 *
 * @author bloch
 */
public class DataCtrl {

    private PartMapper partMap;
    private UserMapper userMap;
    private SvgMapper svgMap;
    private DBConnector dbc;
    private Connection conn;

    //skal finde ud af hvor langt ud vi skal hente connection.
    public DataCtrl(Connection conn) {
        this.conn = conn;
        this.partMap = new PartMapper(conn);
        this.userMap = new UserMapper(conn);
        this.svgMap = new SvgMapper(conn);
    }

    public DataCtrl() {
        this.dbc = new DBConnector();
        this.conn = dbc.connectDB();
        this.partMap = new PartMapper(conn);
        this.userMap = new UserMapper(conn);
        this.svgMap = new SvgMapper(conn);
    }

    public List<Part> getTypeCategory(String typeCategory) {
        return partMap.getTypeCategory(typeCategory);
    }

    public HashMap<Integer, Part> getWoodMap() {
        return partMap.getWoodParts();
    }

    public HashMap<Integer, Part> getRoofMap() {
        return partMap.getRoofParts();
    }

    public HashMap<Integer, Part> getMiscMap() {
        return partMap.getMiscParts();
    }

    public Customer validateCustomer(String email, String password) {
        return userMap.validateCustomer(email, password);
        //return userMap.validateUser(email, password);
    }

    public Customer validateAdmin(String email, String password) {
        return userMap.validateUser(email, password);
    }

    public void insertUser(Customer customer) {
        userMap.insertUser(customer);
    }

    public void addPart(Part part) {
        partMap.addPart(part);
    }

    public void removePart(int removeId) {
        partMap.removePart(removeId);
    }

    public void insertSvg(String SvgInLine, int customerId) {
        svgMap.saveDrawing(SvgInLine, customerId);
    }
public void removeS(String removeimage, int customerid){
        svgMap.removeDrawing(removeimage, customerid);
    
}
    public List<SvgDrawing> getDrawings(int customerId) {
        return svgMap.getSvg(customerId);

    }

}
