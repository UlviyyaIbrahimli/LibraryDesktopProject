
package project.library.desktop.dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.IEducationType;
import project.library.desktop.model.employee.EducationType;

/**
 *
 * @Ulviyye Ibrahimli
 */
public class EducationTypeDao implements IEducationType {

    @Override
    public List<EducationType> getEeducationTypeList() throws Exception {
        List<EducationType> educationTypes = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="select  et.id,  et.type_name from education_type et where  et.active=1 ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps=c.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                   EducationType educationType=new EducationType();
                   educationType.setId(rs.getLong("id"));
                   educationType.setDegreeName(rs.getString("type_name"));
                   educationTypes.add(educationType);
                }
            }
                else{
                        System.out.println("Connection error!");
                        }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return educationTypes;
    }

}
