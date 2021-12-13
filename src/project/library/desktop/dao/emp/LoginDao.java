
package project.library.desktop.dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.emp.ILogin;
import project.library.desktop.model.Login;
import project.library.desktop.model.Role;

/**
 *
 * @Ulviyye Ibrahimli
 */
public class LoginDao implements ILogin {

    @Override
    public List<Login> logins() throws Exception {
        List<Login> logins = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROW_number() over(order by l.f_name) as r,\n"
                + "                         L.ID,\n"
                + "                         L.USER_NAME,\n"
                + "                         L.PASSWORD,\n"
                + "                         R.ROLE_NAME,\n"
                + "                         l.F_NAME,\n"
                + "                         l.L_NAME\n"
                + "                    FROM login l INNER JOIN role r ON L.ROLE_ID = r.id\n"
                + "                   WHERE l.active = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Login login = new Login();
                    Role role = new Role();
                    login.setNumber(rs.getLong("r"));
                    role.setRoleName(rs.getString("role_name"));
                    login.setFirstName(rs.getString("l_name"));
                    login.setLastName(rs.getString("f_name"));
                    login.setId(rs.getLong("id"));
                    login.setUserName(rs.getString("user_name"));
                    login.setPassword(rs.getString("password"));
                    login.setRole(role);
                    logins.add(login);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return logins;
    }

    @Override
    public boolean addLogin(Login login) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "insert into login (id,user_name,password,role_id,f_name,l_name) values(login_seq.nextval,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, login.getUserName());
                ps.setString(2, login.getPassword());
                ps.setLong(3, login.getRole().getId());
                ps.setString(4, login.getFirstName());
                ps.setString(5, login.getLastName());
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
    public boolean updateLogin(Long loginId, Login login) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "update login set user_name=?, password=?, role_id=?, f_name=?,l_name=? where id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, login.getUserName());
                ps.setString(2, login.getPassword());
                ps.setLong(3, login.getRole().getId());
                ps.setString(4, login.getFirstName());
                ps.setString(5, login.getLastName());
                ps.setLong(6, loginId);
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
    public boolean deleteLogin(Long loginId) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "update login set active=0 where id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, loginId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {c.commit();
            Util.closeConnection(c, ps, rs);
        }
        return result;
    }

    @Override
    public Login getLoginById(Long id) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT  l.USER_NAME,\n"
                + "       l.PASSWORD,\n"
                + "       l.ROLE_ID,\n"
                + "       r.ROLE_NAME,\n"
                + "       l.f_name,\n"
                + "       l.l_name\n"
                + "  FROM login l INNER JOIN role r ON r.id = L.ROLE_ID\n"
                + " WHERE l.ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Role role = new Role();
                    role.setRoleName(rs.getString("role_name"));
                    login.setUserName(rs.getString("user_name"));
                    login.setPassword(rs.getString("password"));
                    login.setFirstName(rs.getString("f_name"));
                    login.setLastName(rs.getString("l_name"));
                    role.setId(rs.getLong("role_id"));
                    login.setRole(role);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return login;
    }

    @Override
    public Login checkLogin(String userName, String password, String roleName) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT \n"
                + "         L.ID as LID,\n"
                + "         l.f_name,\n"
                    + "         R.ROLE_NAme,\n"
                + "         R.id,\n"
                + "         l.l_name\n"
                + "    FROM login l INNER JOIN role r ON L.ROLE_ID = r.id\n"
                + "   WHERE l.active = 1 and user_name=? and password=? and role_name=? \n"
                + "ORDER BY l.f_name ASC ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, userName);
                ps.setString(2, password);
                ps.setString(3, roleName);
                rs = ps.executeQuery();
                while (rs.next()) {
                    login.setId(rs.getLong("lid"));
                    login.setFirstName(rs.getString("f_name"));
                    login.setLastName(rs.getString("l_name"));
                    Role role = new Role();
                    role.setId(rs.getLong("id"));
                    role.setRoleName(rs.getString("ROLE_NAME"));
                    login.setRole(role);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return login;
    }
}
