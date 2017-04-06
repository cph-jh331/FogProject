package backend;

import entities.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartMapper {

    private DBConnector dbc = new DBConnector();
    private Connection conn = dbc.connectDB();

    public HashMap<Integer, Part> getWoodParts()
    {
        HashMap<Integer, Part> partMap = new HashMap<>();
        String sql = "select * from part where category = ?;";

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
            preStmt.setString(1, "træ");

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                type = rs.getString("type");
                length = rs.getInt("length");
                packetSize = 0; //skal være 0 og ikke null i databasen.
                unitName = rs.getString("unitname");
                desc = rs.getString("desc");
                partId = rs.getInt("partId");
                category = rs.getString("category");
                partMap.put(partId, new Part(type, length, 0, unitName, desc, partId, category));
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
        String sql = "select * from part where category = ?;";

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
            preStmt.setString(1, "tag");

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                type = rs.getString("type");
                length = rs.getInt("length");
                packetSize = 0; //skal være 0 og ikke null i databasen.
                unitName = rs.getString("unitname");
                desc = rs.getString("desc");
                partId = rs.getInt("partId");
                category = rs.getString("category");
                partMap.put(partId, new Part(type, length, 0, unitName, desc, partId, category));
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
        String sql = "select * from part where category = ?;";

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
            preStmt.setString(1, "løsdele");

            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                type = rs.getString("type");
                length = rs.getInt("length");
                packetSize = 0; //skal være 0 og ikke null i databasen.
                unitName = rs.getString("unitname");
                desc = rs.getString("desc");
                partId = rs.getInt("partId");
                category = rs.getString("category");
                partMap.put(partId, new Part(type, length, 0, unitName, desc, partId, category));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partMap;

    }

}
