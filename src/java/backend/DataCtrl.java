package backend;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import logic.Part;
import logic.User;
import logic.Register;

/**
 *
 * @author bloch
 */
public class DataCtrl {

    private PartMapper partMap;
    private UserMapper userMap;
    //private Connection conn;
    
    //skal finde ud af hvor langt ud vi skal hente connection.
//    public DataCtrl(Connection conn)
//    {
//        this.conn = conn;
//        this.partMap = new PartMapper(conn);
//        this.userMap = new UserMapper(conn);
//    }

    public DataCtrl()
    {
        partMap = new PartMapper();
        userMap = new UserMapper();
    }

    public List<Part> getTypeCategory(String typeCategory)
    {
        return partMap.getTypeCategory(typeCategory);
    }

    public HashMap<Integer, Part> getWoodMap()
    {
        return partMap.getWoodParts();
    }

    public HashMap<Integer, Part> getRoofMap()
    {
        return partMap.getRoofParts();
    }

    public HashMap<Integer, Part> getMiscMap()
    {
        return partMap.getMiscParts();
    }

    public User validateUser(String email, String password)
    {
        return userMap.validateUser(email, password);
    }
     
     public void insertUser(User user){
         userMap.insertUser(user);
     }
     
     
    public void addPart(Part part)
    {
        partMap.addPart(part);
    }

    public void removePart(int removeId)
    {
        partMap.removePart(removeId);
    }

}
