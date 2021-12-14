/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.interfaces.IStatus;
import project.library.desktop.model.Status;
import project.library.desktop.model.Subjects;

/**
 *
 * @author user
 */
public class StatusDao implements IStatus{

    @Override
    public List<Status> getStatusList() throws Exception {
         List<Status> statusList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select id, status from status where active=1";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Status status = new Status();
//                    status.setNumber(rs.getLong("r"));
                    status.setId(rs.getLong("id"));
                    status.setStatus(rs.getString("status"));
                    statusList.add(status);
                }
            } else {
                System.out.println("Connection  Error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return statusList;
    }
    
}
