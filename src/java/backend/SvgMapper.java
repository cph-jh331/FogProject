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
import logic.User;

/**
 *
 * @author bloch
 */
public class SvgMapper {

    private Connection conn;

    public SvgMapper(Connection conn) {
        this.conn = conn;
    }

    public List<SvgDrawing> getSvg(int customerId) {
        String sql = "select * from Svg where customerId = ?;";
        List<SvgDrawing> SvgList = new ArrayList<>();
        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, customerId);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                int svgId = rs.getInt("svgId");
                String svgInline = rs.getString("svgImage");
                customerId = rs.getInt("customerId");
                String dateCreate = rs.getString("dateCreate");
                String dateAccepted = rs.getString("dateAccept");
                //udkommenteret indtil det er muligt at hive det ud af databasen
                //boolean accepted = rs.getBoolean("accepted");
                SvgDrawing svgDrawing = new SvgDrawing(svgId, svgInline, customerId, dateCreate, dateAccepted, false);
                SvgList.add(svgDrawing);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SvgList;
    }
    
    public boolean saveDrawing(String SvgInLine, int customerId) {
       String sql = "insert into Svg (customerId, svgImage) values (?, ?);" ;
        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, customerId);
            preStmt.setString(2, SvgInLine);
            preStmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SvgMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}
