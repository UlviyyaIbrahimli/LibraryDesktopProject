package project.library.desktop.dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.emp.IPosition;
import project.library.desktop.model.employee.Branch;
import project.library.desktop.model.employee.Position;
import project.library.desktop.model.employee.TimeType;

/**
 *
 * @ Ulviyye Ibrahimli
 */
public class PositionDao implements IPosition {

    @Override
    public List<Position> getPositionList() throws Exception {
        List<Position> positionList = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, P.ID,\n"
                + "       P.POSITION_NAME,\n"
                + "       P.POSITION_OBLIGATION,\n"
                + "       TT.TIME_TYPE_NAME,\n"
                + "       TT.TIME_INTERVALE,\n"
                + "       TT.PAUSE_INTERVAL,\n"
                + "       B.BRANCH_NAME\n"
                + "  FROM position p\n"
                + "       LEFT JOIN branch_position bp\n"
                + "          ON bp.position_id = p.id\n"
                + "       LEFT JOIN branch b\n"
                + "          ON B.ID = bp.branch_id\n"
                + "       LEFT JOIN TIME_TYPE TT\n"
                + "          ON TT.ID = P.P_TIME_TYPE_ID\n"
                + " WHERE P.active = 1 ORDER BY P.POSITION_NAME ASC";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                rs = pr.executeQuery();
                while (rs.next()) {
                    Position p = new Position();
                    p.setId(rs.getLong("Id"));
                    p.setNumber(rs.getLong("r"));
                    p.setPositionName(rs.getString("POSITION_NAME"));
                    p.setPositionObligation(rs.getString("POSITION_OBLIGATION"));
                    TimeType timeType = new TimeType();
                    timeType.setTimeTypeName(rs.getString("TIME_TYPE_NAME"));
                    timeType.setPauseInterval(rs.getString("PAUSE_INTERVAL"));
                    timeType.setTimeInterval(rs.getString("TIME_INTERVALE"));
                    p.setpTimeType(timeType);
                    Branch b = new Branch();
                    b.setBranchName(rs.getString("BRANCH_NAME"));
                    p.setBranch(b);
                    positionList.add(p);
                }
            } else {
                System.out.println("Connection  errror!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return positionList;
    }

    @Override
    public boolean addPosition(Position position) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;
        String sql1 = "Insert  into Position (id,position_name,position_obligation,P_time_type_id) values"
                + "(position_seq.nextval,?,?,?)";
        String sql2 = "INSERT INTO BRANCH_POSITION(ID,POSITION_ID,BRANCH_ID)VALUES (BRANCH_POSITION_SEQ.NEXTVAL,POSITION_SEQ.CURRVAL,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql1);
                pr.setString(1, position.getPositionName());
                pr.setString(2, position.getPositionObligation());
                pr.setLong(3, position.getpTimeType().getId());
                pr.execute();
                pr = c.prepareStatement(sql2);
                pr.setLong(1, position.getBranch().getId());
                pr.execute();
                result = true;

            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, pr, null);
        }
        return result;

    }

    @Override
    public boolean updatePosition(Long id, Position position) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;
        String sql1 = "update position set position_name=?, position_obligation=?,P_time_type_id=? where id=?";
        String sql2 = "update branch_position set branch_id=? where  position_id=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql1);
                pr.setString(1, position.getPositionName());
                pr.setString(2, position.getPositionObligation());
                pr.setLong(3, position.getpTimeType().getId());
                pr.setLong(4, id);
                pr.execute();
                pr = c.prepareStatement(sql2);
                pr.setLong(1, position.getBranch().getId());
                pr.setLong(2, id);
                pr.execute();
                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, pr, null);
        }
        return result;

    }

    @Override
    public Position getPositionById(Long id) throws Exception {
        Position position = new Position();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT  \n"
                + "       p.position_name,\n"
                + "       p.position_obligation,\n"
                + "       b.branch_name,\n"
                + "       bp.branch_id ,\n"
                + "       tt.time_type_name,\n"
                + "       tt.id\n"
                + "  FROM POSITION P\n"
                + "       LEFT JOIN branch_position bp\n"
                + "          ON BP.POSITION_ID = p.ID\n"
                + "       LEFT JOIN branch b\n"
                + "          ON b.ID = BP.BRANCH_ID\n"
                + "       LEFT JOIN time_type tt\n"
                + "          ON TT.ID = P.P_TIME_TYPE_ID\n"
                + " WHERE P.ACTIVE = 1 AND p.ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                pr.setLong(1, id);
                rs = pr.executeQuery();
                while (rs.next()) {
                    position.setPositionName(rs.getString("position_name"));
                    position.setPositionObligation(rs.getString("position_obligation"));
                    Branch branch = new Branch();
                    TimeType timeType = new TimeType();
                    branch.setBranchName(rs.getString("branch_name"));
                    branch.setId(rs.getLong("Branch_id"));
                    position.setBranch(branch);
                    timeType.setTimeTypeName(rs.getString("time_type_name"));
                    timeType.setId(rs.getLong("id"));

                    position.setpTimeType(timeType);

                }
            } else {
                System.out.println("Connection error!");

            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {

            Util.closeConnection(c, pr, rs);
        }
        return position;
    }

    @Override
    public List<Position> getPositionListByBranchId(Long id) throws Exception {
        List<Position> positionList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT rownum r,P.ID,\n"
                + "       P.POSITION_NAME,\n"
                + "       b.branch_name\n"
                + "  FROM position p\n"
                + "       INNER JOIN branch_position bp\n"
                + "          ON BP.POSITION_ID = P.ID\n"
                + "       LEFT JOIN branch b\n"
                + "          ON B.ID = BP.BRANCH_ID\n"
                + " WHERE p.active = 1 and b.id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Position position = new Position();
                    position.setId(rs.getLong("Id"));
                    position.setNumber(rs.getLong("r"));
                    position.setPositionName(rs.getString("POSITION_NAME"));
                    Branch branch = new Branch();
                    branch.setBranchName(rs.getString("branch_name"));
                    position.setBranch(branch);
                    positionList.add(position);
                }
            } else {
                System.out.println("Connection Error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return positionList;
    }

    @Override
    public boolean deletePosition(long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql1 = "update position set active=0 where id=?";
        String sql2 = "update branch_position set active=0 where position_id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
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
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return result;

    }

    @Override
    public List<Position> searchPosition(String keyword) throws Exception {
        List<Position> positionList = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, P.ID,\n"
                + "       P.POSITION_NAME,\n"
                + "       P.POSITION_OBLIGATION,\n"
                + "       TT.TIME_TYPE_NAME,\n"
                + "       TT.TIME_INTERVALE,\n"
                + "       TT.PAUSE_INTERVAL,\n"
                + "       B.BRANCH_NAME\n"
                + "  FROM POSITION P\n"
                + "       left JOIN BRANCH_POSITION BP\n"
                + "          ON BP.POSITION_ID = P.ID\n"
                + "       left JOIN BRANCH B\n"
                + "          ON B.ID = BP.BRANCH_ID\n"
                + "       left JOIN TIME_TYPE TT\n"
                + "          ON TT.ID = P.P_TIME_TYPE_ID\n"
                + " WHERE     P.ACTIVE = 1\n"
                + "       AND (   LOWER (P.POSITION_NAME) LIKE (LOWER (?))\n"
                + "            OR LOWER (P.POSITION_OBLIGATION) LIKE (LOWER (?))\n"
                + "            OR (LOWER (B.BRANCH_NAME)) LIKE (LOWER (?))\n"
                + "            OR LOWER (TT.TIME_TYPE_NAME) LIKE (LOWER (?)))  ORDER BY P.POSITION_NAME ASC";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                pr.setString(1, "%" + keyword + "%");
                pr.setString(2, "%" + keyword + "%");
                pr.setString(3, "%" + keyword + "%");
                pr.setString(4, "%" + keyword + "%");
                rs = pr.executeQuery();
                while (rs.next()) {
                    Position p = new Position();
                    p.setId(rs.getLong("Id"));
                    p.setNumber(rs.getLong("r"));
                    p.setPositionName(rs.getString("POSITION_NAME"));
                    p.setPositionObligation(rs.getString("POSITION_OBLIGATION"));
                    TimeType timeType = new TimeType();
                    timeType.setTimeTypeName(rs.getString("TIME_TYPE_NAME"));
                    timeType.setPauseInterval(rs.getString("PAUSE_INTERVAL"));
                    timeType.setTimeInterval(rs.getString("TIME_INTERVALE"));
                    p.setpTimeType(timeType);
                    Branch b = new Branch();
                    b.setBranchName(rs.getString("BRANCH_NAME"));
                    p.setBranch(b);
                    positionList.add(p);
                }
            } else {
                System.out.println("Connection  errror!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return positionList;
    }
}
