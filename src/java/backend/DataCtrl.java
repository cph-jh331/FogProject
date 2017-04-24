package backend;

import java.util.HashMap;
import java.util.List;
import logic.Part;
import logic.User;

/**
 *
 * @author bloch
 */
public class DataCtrl {
    
    private PartMapper partMap;
    private UserMapper userMap;
    //private Connection conn;

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
    
    public void addPart(Part part)
    {
        partMap.addPart(part);
    }
    
    public void removePart(int removeId)
    {
        partMap.removePart(removeId);
    }
    
}
