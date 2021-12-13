package project.library.desktop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.interfaces.ISubject;
import project.library.desktop.model.AbstractClass;
import project.library.desktop.model.Subjects;

/**
 *
 * @Ulviyye Ibrahimli
 */
public class SubjectDao extends AbstractClass implements ISubject {

    @Override
    public List<Subjects> getSubjectList() throws Exception {
        List<Subjects> subjectList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROW_NUMBER () OVER (ORDER BY subject_name ASC) AS r,\n"
                + "       id,\n"
                + "       subject_name,\n"
                + "       subject_info\n"
                + "  FROM subjects\n"
                + " WHERE active = 1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Subjects subject = new Subjects();
                    subject.setNumber(rs.getLong("r"));
                    subject.setId(rs.getLong("id"));
                    subject.setSubjectName(rs.getString("subject_name"));
                    subject.setSubjectInfo(rs.getString("subject_info"));
                    subjectList.add(subject);
                }
            } else {
                System.out.println("Connection  Error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return subjectList;
    }

    @Override
    public boolean addSubject(Subjects subjects) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "insert into subjects (id,subject_name,subject_info) values(Subjects_seq.nextval,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, subjects.getSubjectName());
                ps.setString(2, subjects.getSubjectInfo());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean updateSubject(Subjects subject, Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "update subjects  set subject_name=?, subject_info=? where id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, subject.getSubjectName());
                ps.setString(2, subject.getSubjectInfo());
                ps.setLong(3, id);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean deleteSubject(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "update  subjects set active=0 where id=?";
        String sql1 = "update book_subject set active=0 where subject_id=?";
        String sql2 = "update author_subject set active=0 where subject_id=? ";
        Subjects subjects = new Subjects();
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                ps = c.prepareStatement(sql1);
                ps.setLong(1, id);
                ps.execute();
                ps = c.prepareStatement(sql2);
                ps.setLong(1, id);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, null);
        }
        return result;

    }

    @Override
    public Subjects getSubjectById(Long id) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select subject_name,subject_info  from subjects where id=?";
        Subjects subjects = new Subjects();
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    subjects.setSubjectName(rs.getString("subject_name"));
                    subjects.setSubjectInfo(rs.getString("subject_info"));
                }
            } else {
                System.out.println("Connection error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return subjects;
    }

}
