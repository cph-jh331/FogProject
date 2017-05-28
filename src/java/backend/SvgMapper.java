package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.SvgDrawing;

/**
 * SvgMapper is used for updating and getting data from the Svg table in the
 * MySQL database.
 *
 * @author Lasse Andersen, Marco Frydshou, John Hansen, Per Andersen
 */
public class SvgMapper {

    /**
     * Connection conn used for setting a SQL Connection.
     */
    private Connection conn;

    /**
     * Constructor that sets the Connection to the Connection parameter.
     *
     * @param conn SQL Connection to set.
     */
    public SvgMapper(Connection conn)
    {
        this.conn = conn;
    }

    /**
     * Returns a List with SvgDrawing objects based on the int parameter
     * customerId. The List can be empty.
     *
     * @param customerId int of the customerId you want to get a List of
     * SvgDrawings from.
     * @return List with SvgDrawing objects from a specific customer. List will
     * return empty, if no rows contains the specified customerId.
     */
    public List<SvgDrawing> getCustomerSvgs(int customerId)
    {
        String sql = "select * from Svg where customerId = ?;";
        List<SvgDrawing> SvgList = new ArrayList<>();
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, customerId);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                int svgId = rs.getInt("svgId");
                String svgInline = rs.getString("svgImage");
                customerId = rs.getInt("customerId");
                String dateCreate = rs.getString("dateCreate");
                String dateAccepted = rs.getString("dateAccept");
                String status = rs.getString("status").toUpperCase();
                SvgDrawing svgDrawing = new SvgDrawing(svgId, svgInline, customerId, dateCreate, dateAccepted, false);
                svgDrawing.setStatus(SvgDrawing.Status.valueOf(status));
                SvgList.add(svgDrawing);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SvgList;
    }

    /**
     * Remove a row from Svg table in the MySQL database based on the svgId.
     * Returns true if the if succeded.
     *
     * @param svgId int value for the SvgDrawing's id you want to remove.
     * @return true if the svgId existed.
     */
    public boolean removeSvgDrawing(int svgId)
    {
        String sql = "delete from Svg where svgId = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, svgId);
            preStmt.executeUpdate();
            return true;
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Remove an row in the Svg table based ont the int customerId and the
     * String removeImage. Returns true if it succeded.
     *
     * @param removeimage String with Svg in html.
     * @param customerid int of a customer id.
     * @return boolean true if no exception happened.
     */
    public boolean removeDrawing(String removeimage, int customerid)
    {
        boolean removedDrawing = false;
        String sql = "delete from Svg (customerId, svgImage) values (?, ?);";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, customerid);
            preStmt.setString(2, removeimage);
            preStmt.executeUpdate();
            removedDrawing = true;
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);

        }
        return removedDrawing;
    }

    /**
     * Inserts a row in the MySQL database based on the string SvgInline and a
     * CustomerId. Returns true if succeded.
     *
     * @param SvgInLine String with Svg in html.
     * @param customerId int value of the customerId.
     * @return returns true if no SQLException has happened.
     */
    public boolean saveDrawing(String SvgInLine, int customerId)
    {
        String sql = "insert into Svg (customerId, svgImage) values (?, ?);";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, customerId);
            preStmt.setString(2, SvgInLine);
            preStmt.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    /**
     * Updates the status of a row in the SvgTable based on the svgId and the
     * Status.
     *
     * @param svgId int value of the svgId.
     * @param status Enum Status to set. Expected values are CREATED,
     * REQAPPROVED, APPROVED and DONE.
     */
    public void changeStatusOnSvg(int svgId, SvgDrawing.Status status)
    {
        String sql = "update Svg set status = ? where svgId = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, status.toString().toLowerCase());
            preStmt.setInt(2, svgId);
            preStmt.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a List with SvgDrawing objects based on the int parameter
     * customerId. The List can be empty.
     *
     * @param customerId int for the customer you want to get a List of
     * SvgDrawings from.
     * @return List with SvgDrawing objects from a specific customer. The List
     * will return empty if the customerId does not exist in the Svg table.
     */
    public List<SvgDrawing> getAllSvgsWithCustomer(int customerId)
    {
        List<SvgDrawing> svgList = new ArrayList<>();
        String sql = "select * from Svg where customerId = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, customerId);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                int svgId = rs.getInt("svgId");
                String svgInline = rs.getString("svgImage");
                int custId = rs.getInt("customerId");
                String dateCreate = rs.getString("dateCreate");
                String dateAccepted = rs.getString("dateAccept");
                String status = rs.getString("status").toUpperCase();
                SvgDrawing svgDrawing = new SvgDrawing(svgId, svgInline, custId, dateCreate, dateAccepted, false);
                svgDrawing.setStatus(SvgDrawing.Status.valueOf(status));
                svgList.add(svgDrawing);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svgList;

    }

    /**
     * Returns a SvgDrawing object with the specified svgId. SvgDrawing CAN BE
     * NULL.
     *
     * @param svgId int value of the svgId.
     * @return SvgDrawing object. SvgDrawing Object will be null, if the svgId
     * does not exists in the Svg table in the MySQL database.
     */
    public SvgDrawing getSvgDrawingWithSvgId(int svgId)
    {
        SvgDrawing svgDrawing = null;
        String sql = "select * from Svg where svgId = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, svgId);
            ResultSet rs = preStmt.executeQuery();
            if (rs.next())
            {
                svgId = rs.getInt("svgId");
                String svgInline = rs.getString("svgImage");
                int custId = rs.getInt("customerId");
                String dateCreate = rs.getString("dateCreate");
                String dateAccepted = rs.getString("dateAccept");
                String status = rs.getString("status").toUpperCase();
                svgDrawing = new SvgDrawing(svgId, svgInline, custId, dateCreate, dateAccepted, false);
                svgDrawing.setStatus(SvgDrawing.Status.valueOf(status));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svgDrawing;

    }

    /**
     * Returns a List with SvgDrawing objects based on the customerId and
     * svgStatus. List can be empty.
     *
     * @param svgStatus Enum SvgDrawing.Status to set. Expected values are
     * CREATED, REQAPPROVED, APPROVED and DONE.
     * @param customerId int value of customerId.
     * @return List with SvgDrawing objects. The List will return empty if the
     * customer does not exist in the Svg table or if the status does not exist
     * with specific customerId.
     */
    public List<SvgDrawing> getCustomerSvgWithStatus(SvgDrawing.Status svgStatus, int customerId)
    {
        List<SvgDrawing> svgList = new ArrayList<>();
        String sql = "select * from Svg where customerId = ? && status = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, customerId);
            preStmt.setString(2, svgStatus.toString());
            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                int svgId = rs.getInt("svgId");
                String svgInline = rs.getString("svgImage");
                int custId = rs.getInt("customerId");
                String dateCreate = rs.getString("dateCreate");
                String dateAccepted = rs.getString("dateAccept");
                String status = rs.getString("status").toUpperCase();
                SvgDrawing svgDrawing = new SvgDrawing(svgId, svgInline, custId, dateCreate, dateAccepted, false);
                svgDrawing.setStatus(SvgDrawing.Status.valueOf(status));
                svgList.add(svgDrawing);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svgList;
    }

    /**
     * Returns a List with SvgDrawing objects based on the SvgDrawing.Status
     * parameter. The List can be empty.
     *
     * @param svgStatus Enum SvgDrawing.Status to set. Expected values are
     * CREATED, REQAPPROVED, APPROVED and DONE.
     * @return A List of SvgDrawing objects with a specific Status. The List
     * will be empty if the specified Status does not exist in the Svg table.
     */
    public List<SvgDrawing> getAllSvgWithStatus(SvgDrawing.Status svgStatus)
    {
        List<SvgDrawing> svgList = new ArrayList<>();
        String sql = "select * from Svg where status = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            String status = svgStatus.toString();
            preStmt.setString(1, status);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next())
            {
                int svgId = rs.getInt("svgId");
                String svgInline = rs.getString("svgImage");
                int customerId = rs.getInt("customerId");
                String dateCreate = rs.getString("dateCreate");
                String dateAccepted = rs.getString("dateAccept");
                status = rs.getString("status").toUpperCase();
                SvgDrawing svgDrawing = new SvgDrawing(svgId, svgInline, customerId, dateCreate, dateAccepted, false);
                svgDrawing.setStatus(SvgDrawing.Status.valueOf(status));
                svgList.add(svgDrawing);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svgList;
    }

}
