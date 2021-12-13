package project.library.desktop.dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.emp.ITimeType;
import project.library.desktop.model.employee.TimeType;

public class TimeTypeDao implements ITimeType {

    @Override
    public boolean addTimetype(TimeType timeType) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TimeType> timeTypeList() throws Exception {
        List<TimeType> timeTypeList = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "Select tt.id, tt.time_type_name,tt.time_intervale,tt.pause_interval  from time_type tt where tt.active=1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                rs = pr.executeQuery();
                while (rs.next()) {
                    TimeType timeType = new TimeType();
                    timeType.setId(rs.getLong("id"));
                    timeType.setTimeTypeName(rs.getString("time_type_name"));
                    timeType.setTimeInterval(rs.getString("time_intervale"));
                    timeType.setPauseInterval(rs.getString("pause_interval"));
                    timeTypeList.add(timeType);
                }
            } else {
                System.out.println("connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, rs);
        }
        return timeTypeList;
    }
}
