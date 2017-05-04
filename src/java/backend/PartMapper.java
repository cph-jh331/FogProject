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

public class PartMapper {

    private DBConnector dbc = new DBConnector();
    private Connection conn = dbc.connectDB();

    public PartMapper(Connection conn)
    {
        this.conn = conn;
    }

    public void removePart(int PartId)
    {
        String sql = "delete from Part where partId = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, PartId);
            preStmt.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addPart(Part part)
    {
        String sql = "insert into Part (type, category, unitname, descript, typeCategory) values (?,?,?,?,?);";

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

    public void removePart(Part part)
    {
        String sql = "delete from Part where partId = ?;";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, part.getPartId());
            preStmt.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Part> getTypeCategory(String typeCategory)
    {
        List<Part> typeCatMap = new ArrayList<>();
        String sql = "select * from Part where typeCategory = ?;";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            String type;
            Integer length;
            int packetSize;
            String unitName;
            String desc;
            int partId;
            String category;
            String typeCat;
            preStmt.setString(1, typeCategory);

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                partId = rs.getInt("partId");
                type = rs.getString("type");
                category = rs.getString("category");
                length = rs.getInt("length");
                packetSize = 0; //skal være 0 og ikke null i databasen.
                unitName = rs.getString("unitName");
                desc = rs.getString("desc");
                typeCat = rs.getString("typeCategory");
                typeCatMap.add(new Part(type, length, 0, unitName, desc, partId, category, typeCat));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeCatMap;
    }

    public HashMap<Integer, Part> getWoodParts()
    {
        HashMap<Integer, Part> partMap = new HashMap<>();
        String sql = "select * from Part where category = ?;";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            String type;
            Integer length;
            int packetSize;
            String unitName;
            String desc;
            int partId;
            String category;
            String typeCat;
            preStmt.setString(1, "Træ");

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                partId = rs.getInt("partId");
                type = rs.getString("type");
                category = rs.getString("category");
                length = rs.getInt("length");
                packetSize = 0; //skal være 0 og ikke null i databasen.
                unitName = rs.getString("unitName");
                desc = rs.getString("desc");
                typeCat = rs.getString("typeCategory");
                partMap.put(partId, new Part(type, length, 0, unitName, desc, partId, category, typeCat));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partMap;
    }

    public HashMap<Integer, Part> getRoofParts()
    {
        HashMap<Integer, Part> partMap = new HashMap<>();
        String sql = "select * from Part where category = ?;";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            String type;
            Integer length;
            int packetSize;
            String unitName;
            String desc;
            int partId;
            String category;
            String typeCat;
            preStmt.setString(1, "tag");

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                partId = rs.getInt("partId");
                type = rs.getString("type");
                category = rs.getString("category");
                length = rs.getInt("length");
                packetSize = 0; //skal være 0 og ikke null i databasen.
                unitName = rs.getString("unitName");
                desc = rs.getString("desc");
                typeCat = rs.getString("typeCategory");
                partMap.put(partId, new Part(type, length, 0, unitName, desc, partId, category, typeCat));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partMap;

    }

    public HashMap<Integer, Part> getMiscParts()
    {
        HashMap<Integer, Part> partMap = new HashMap<>();
        String sql = "select * from Part where category = ?;";

        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            String type;
            Integer length;
            int packetSize;
            String unitName;
            String desc;
            int partId;
            String category;
            String typeCat;
            preStmt.setString(1, "løsdele");

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                partId = rs.getInt("partId");
                type = rs.getString("type");
                category = rs.getString("category");
                length = rs.getInt("length");
                packetSize = 0; //skal være 0 og ikke null i databasen.
                unitName = rs.getString("unitName");
                desc = rs.getString("desc");
                typeCat = rs.getString("typeCategory");
                partMap.put(partId, new Part(type, length, 0, unitName, desc, partId, category, typeCat));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partMap;

    }

}
