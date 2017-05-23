/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author bloch
 */
public class SvgMapper {

    private Connection conn;

    public SvgMapper(Connection conn)
    {
        this.conn = conn;
    }

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
                String status = rs.getString("status");

                //udkommenteret indtil det er muligt at hive det ud af databasen
                //boolean accepted = rs.getBoolean("accepted");
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

    public boolean removeDrawing(String removeimage, int customerid)
    {
        String sql = "delete from Svg (customerId, svgImage) values (?, ?);";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, customerid);
            preStmt.setString(2, removeimage);
            preStmt.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

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
        }

        return true;
    }

    public void changeStatusOnSvg(int svgId, SvgDrawing.Status status)
    {
        String sql = "update Svg set status = ? where svgId = ?;";
        try
        {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, status.toString());
            preStmt.setInt(2, svgId);
            preStmt.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
                String status = rs.getString("status");
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
                String status = rs.getString("status");
                svgDrawing = new SvgDrawing(svgId, svgInline, custId, dateCreate, dateAccepted, false);
                svgDrawing.setStatus(SvgDrawing.Status.valueOf(status));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svgDrawing;

    }

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
                String status = rs.getString("status");
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
                status = rs.getString("status");
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
