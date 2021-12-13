package project.library.desktop.dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.emp.IRole;
import project.library.desktop.model.Role;

/**
 *
 * @Ulviyye Ibrahimli
 */
public class RoleDao implements IRole {

    @Override
    public List<Role> getRoles() throws Exception {
        List<Role> roles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select  rownum r, id, role_name, description   from role where active=1 order by role_name asc";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Role role = new Role();
                    role.setId(rs.getLong("id"));
                    role.setNumber(rs.getLong("r"));
                    role.setRoleName(rs.getString("role_name"));
                    role.setDescription(rs.getString("description"));
                    roles.add(role);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return roles;

    }

    @Override
    public boolean addRole(Role role) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "insert into role(id,role_name,description) values(role_seq.nextval,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, role.getRoleName());
                ps.setString(2, role.getDescription());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean update(Role role, Long roleId) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "update role set role_name=?, description=? where id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, role.getRoleName());
                ps.setString(2, role.getDescription());
                ps.setLong(3, roleId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean deleteRole(Long roleId) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "update role set active=0 where id=?";
        String sql1 = "update login set active=0 where role_id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, roleId);
                ps.execute();
                ps = c.prepareStatement(sql1);
                ps.setLong(1, roleId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, rs);
        }
        return result;
    }

    @Override
    public Role getRoleById(Long id) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Role role = new Role();
        String sql = "select role_name, description from role where id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    role.setRoleName(rs.getString("role_name"));
                    role.setDescription(rs.getString("description"));
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return role;
    }

    @Override
    public String getRoleName(String userName, String password) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String roleName = null;
        String sql = "select   R.ROLE_NAME  from role r inner join login l on L.ROLE_ID=r.id where l.active=1 and L.USER_NAME=? and L.PASSWORD=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, userName);
                ps.setString(2, password);
                rs = ps.executeQuery();
                while (rs.next()) {
                    roleName = rs.getString("role_name");
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return roleName;
    }

}
