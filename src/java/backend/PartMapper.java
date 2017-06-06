package backend;

import logic.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PartMapper is used for updating the Part table in the MySQL database.
 *
 * @author Lasse Andersen, Marco Frydshou, John Hansen, Per Andersen
 */
public class PartMapper {

    /**
     * SQL Connection attribute for the mapper.
     */
    private Connection conn;

    /**
     * Constructor that sets the private Connection to the Connection parameter.
     *
     * @param conn SQL Connection to set.
     */
    public PartMapper(Connection conn)
    {
        this.conn = conn;
    }

    /**
     * Removes the row designated by the int parameter PartId in the Part table.
     *
     * @param partId int value of the partId to be removed from the Part table.
     */
    public void removePart(int partId)
    {
        String sql = "delete from Part where partId = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, partId);
            preStmt.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Adds a row with the data of the Part object designated by the parameter
     * part in the Part table.
     *
     * @param part Part object to be added to the Part table.
     */
    public void addPart(Part part)
    {
        String sql = "insert into Part (ptype, category, unitName, pdesc, typeCategory) values (?,?,?,?,?);";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, part.getType());
            preStmt.setString(2, part.getCategory());
            preStmt.setString(3, part.getUnitName());
            preStmt.setString(4, part.getDescription());
            preStmt.setString(5, part.getTypeCategory());
            preStmt.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a List with Part Objects based on the String parameter
     * typeCategory. The List can be empty.
     *
     * @param typeCategory String value of the typeCategory to set.
     * @return A List with Part objects. The List can return empty if the
     * specific typeCategory does not exist.
     */
    public List<Part> getTypeCategory(String typeCategory)
    {
        List<Part> typeCatMap = new ArrayList<>();
        String sql = "select * from Part where typeCategory = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, typeCategory);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                int partId = rs.getInt("partId");
                String type = rs.getString("ptype");
                String category = rs.getString("category");
                int length = rs.getInt("length");
                int packetSize = 0;
                String unitName = rs.getString("unitName");
                String desc = rs.getString("pdesc");
                String typeCat = rs.getString("typeCategory");
                typeCatMap.add(new Part(type, length, packetSize, unitName, desc, partId, category, typeCat));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeCatMap;
    }

    /**
     * Returns a HashMap with Part objects with the category of 'Træ' with
     * integer keys of the partId and the values of a Part Object. HashMap can
     * return empty.
     *
     * @return HashMap with Parts as value and integer keys based on the partId.
     * The HashMap will return empty if no rows contains the category of 'Træ'.
     */
    public HashMap<Integer, Part> getWoodParts()
    {
        HashMap<Integer, Part> partMap = new HashMap<>();
        String sql = "select * from Part where category = ?;";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, "Træ");

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                int partId = rs.getInt("partId");
                String type = rs.getString("type");
                String category = rs.getString("category");
                int length = rs.getInt("length");
                int packetSize = 0;
                String unitName = rs.getString("unitName");
                String desc = rs.getString("desc");
                String typeCat = rs.getString("typeCategory");
                partMap.put(partId, new Part(type, length, packetSize, unitName, desc, partId, category, typeCat));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partMap;
    }

    /**
     * Returns a HashMap with Part objects with the category of 'tag' with
     * integer keys of the partId and the values of a Part Object. HashMap can
     * return empty.
     *
     * @return HashMap with Parts as value and integer keys based on the partId.
     * The HashMap will return empty if no rows contains the category of 'tag'.
     */
    public HashMap<Integer, Part> getRoofParts()
    {
        HashMap<Integer, Part> partMap = new HashMap<>();
        String sql = "select * from Part where category = ?;";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, "tag");

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                int partId = rs.getInt("partId");
                String type = rs.getString("type");
                String category = rs.getString("category");
                int length = rs.getInt("length");
                int packetSize = 0; //skal være 0 og ikke null i databasen.
                String unitName = rs.getString("unitName");
                String desc = rs.getString("desc");
                String typeCat = rs.getString("typeCategory");
                partMap.put(partId, new Part(type, length, packetSize, unitName, desc, partId, category, typeCat));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partMap;

    }

    /**
     * Returns a HashMap with Part objects with the category of 'løsdele' with
     * integer keys of the partId and the values of a Part Object. HashMap can
     * return empty.
     *
     * @return HashMap with Parts as value and integer keys based on the partId.
     * The HashMap will return empty if no rows contains the category of 'løsdele'.
     */
    public HashMap<Integer, Part> getMiscParts()
    {
        HashMap<Integer, Part> partMap = new HashMap<>();
        String sql = "select * from Part where category = ?;";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, "løsdele");

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                int partId = rs.getInt("partId");
                String type = rs.getString("type");
                String category = rs.getString("category");
                int length = rs.getInt("length");
                int packetSize = 0; //skal være 0 og ikke null i databasen.
                String unitName = rs.getString("unitName");
                String desc = rs.getString("desc");
                String typeCat = rs.getString("typeCategory");
                partMap.put(partId, new Part(type, length, packetSize, unitName, desc, partId, category, typeCat));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partMap;

    }

}
