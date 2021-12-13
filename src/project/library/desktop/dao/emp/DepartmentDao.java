package project.library.desktop.dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.emp.IDepartment;
import project.library.desktop.model.employee.Department;

/**
 * *
 * 
 * @Ulviyye Ibrahimli
 */
public class DepartmentDao implements IDepartment {

    @Override
    public List<Department> getDepartmentList() throws Exception {
        List<Department> departmentList = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT  ROWNUM R,D.ID,\n"
                + "       D.DEPARTMENT_NAME,\n"
                + "       D.FOUNDATE,\n"
                + "       D.ASSETS,\n"
                + "       D.EMAIL,\n"
                + "       D.PHONE,\n"
                + "       D.ADDRESS,\n"
                + "       D.DEPARTMENT_OBLIGATION\n"
                + "  FROM DEPARTMENT D\n"
                + " WHERE D.ACTIVE = 1  ORDER BY D.DEPARTMENT_NAME desc";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                rs = pr.executeQuery();
                while (rs.next()) {
                    Department department = new Department();
                    department.setNumber(rs.getLong("r"));
                    department.setId(rs.getLong("ID"));
                    department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                    department.setFoundate(rs.getDate("FOUNDATE"));
                    department.setAssets(rs.getFloat("ASSETS"));
                    department.setObligation(rs.getString("DEPARTMENT_OBLIGATION"));
                    department.setAddress(rs.getString("ADDRESS"));
                    department.setPhone(rs.getString("PHONE"));
                    department.seteMail(rs.getString("Email"));
                    departmentList.add(department);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, rs);
        }

        return departmentList;

    }

    @Override
    public boolean addDepartment(Department department) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;
        String sql = "INSERT INTO DEPARTMENT (ID,DEPARTMENT_NAME,FOUNDATE,ASSETS,ADDRESS,DEPARTMENT_OBLIGATION,PHONE,EMAIL)"
                + "VALUES(DEPARTMENT_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                pr.setString(1, department.getDepartmentName());
                pr.setDate(2, new java.sql.Date(department.getFoundate().getTime()));
                pr.setFloat(3, department.getAssets());
                pr.setString(4, department.getAddress());
                pr.setString(5, department.getObligation());
                pr.setString(6, department.getPhone());
                pr.setString(7, department.geteMail());
                pr.execute();
                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, null);
        }
        return result;
    }

    @Override
    public Department getDepartmentById(Long id) throws Exception {
        Department department = new Department();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT d.id,\n"
                + "       D.DEPARTMENT_NAME,\n"
                + "       D.FOUNDATE,\n"
                + "       D.ASSETS,\n"
                + "       D.ADDRESS,\n"
                + "      D.PHONE,\n"
                + "       D.EMAIL,\n"
                + "       D.DEPARTMENT_OBLIGATION\n"
                + "  FROM DEPARTMENT D\n"
                + " WHERE D.ACTIVE = 1  and  d.id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                pr.setLong(1, id);
                pr.execute();
                rs = pr.executeQuery();
                while (rs.next()) {
                    department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                    department.setFoundate(rs.getDate("FOUNDATE"));
                    department.setPhone(rs.getString("Phone"));
                    department.seteMail(rs.getString("EMAIL"));
                    department.setAssets(rs.getFloat("ASSETS"));
                    department.setAddress(rs.getString("ADDRESS"));
                    department.setObligation(rs.getString("DEPARTMENT_OBLIGATION"));
                }

            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, rs);
        }
        return department;
    }

    @Override
    public boolean updateDepartment(Department department, Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "Update department set department_name=?, phone=?, email=?,department_obligation=?, foundate=?, "
                + "assets=?, address=? where id=?";
        try {
            c = DbHelper.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, department.getDepartmentName());
            ps.setString(2, department.getPhone());
            ps.setString(3, department.geteMail());
            ps.setString(4, department.getObligation());
            ps.setDate(5, new java.sql.Date(department.getFoundate().getTime()));
            ps.setFloat(6, department.getAssets());
            ps.setString(7, department.getAddress());
            ps.setLong(8, id);
            ps.execute();
            result = true;
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {

            Util.closeConnection(c, ps, null);
        }
        return result;

    }

    @Override
    public boolean deleteDepartment(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;
        Department department = new Department();
        String sql1 = "UPDATE DEPARTMENT SET ACTIVE=0 WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql1);
                pr.setLong(1, id);
                pr.execute();
                result = true;
            } else {
                System.out.println("Connection Error!");
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, pr, null);
        }
        return result;
    }

    @Override
    public Department branchCount(Long id) throws Exception {
        Department department = new Department();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT (B.DEPARTENT_ID) as Emp_total \n"
                + "    FROM BRANCH B INNER JOIN DEPARTMENT D ON B.DEPARTENT_ID = D.ID\n"
                + "   WHERE B.ACTIVE = 1\n"
                + "GROUP BY B.DEPARTENT_ID\n"
                + "  HAVING B.DEPARTENT_ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                rs = ps.executeQuery();
                while (rs.next()) {
                    department.setBranchCount(rs.getInt("Emp_total"));
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return department;

    }

    @Override
    public Department employeeCount(Long id) throws Exception {
        Department department = new Department();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT (E.ID) AS emp_count\n"
                + "    FROM EMPLOYEE E\n"
                + "         INNER JOIN BRANCH B\n"
                + "            ON B.ID = E.BRANCH_ID\n"
                + "         INNER JOIN DEPARTMENT D\n"
                + "            ON D.ID = B.DEPARTENT_ID\n"
                + "   WHERE e.active = 1\n"
                + "GROUP BY B.DEPARTENT_ID\n"
                + "  HAVING B.DEPARTENT_ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                rs = ps.executeQuery();
                while (rs.next()) {
                    department.setEmployeeCount(rs.getInt("emp_count"));
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return department;
    }

    @Override
    public List<Department> getDepHaveBranch() throws Exception {
        List<Department> departmentList = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT  D.id, D.DEPARTMENT_NAME\n"
                + "  FROM branch b right JOIN department d ON B.DEPARTENT_ID = D.ID \n"
                + " WHERE B.ACTIVE = 1 group by D.id, D.DEPARTMENT_NAME ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                rs = pr.executeQuery();
                while (rs.next()) {
                    Department department = new Department();
                    department.setId(rs.getLong("d.id"));
                    department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                    departmentList.add(department);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, rs);
        }
        return departmentList;
    }

    @Override
    public List<Department> searchDepartment(String keyword) throws Exception {
        List<Department> departmentList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R,\n"
                + "       D.ID,\n"
                + "       D.DEPARTMENT_NAME,\n"
                + "       D.FOUNDATE,\n"
                + "       D.ASSETS,\n"
                + "       D.ADDRESS,\n"
                + "       D.PHONE,\n"
                + "       D.EMAIL,\n"
                + "       D.DEPARTMENT_OBLIGATION\n"
                + "  FROM department d\n"
                + " WHERE     active = 1\n"
                + "       AND (   LOWER (D.DEPARTMENT_NAME) LIKE LOWER (?)\n"
                + "            OR LOWER (D.DEPARTMENT_OBLIGATION) LIKE (LOWER (?))\n"
                + "            OR TO_CHAR (D.FOUNDATE, 'MM/dd/yyyy') LIKE ? \n"
                + "            OR LOWER (D.ADDRESS) LIKE LOWER (?)\n"
                + "            OR D.ASSETS LIKE ? \n"
                + "            OR D.phone LIKE ? \n"
                + "            OR LOWER (D.email) LIKE LOWER (?))  ORDER BY D.DEPARTMENT_NAME desc";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                ps.setString(7, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Department department = new Department();
                    department.setNumber(rs.getLong("r"));
                    department.setId(rs.getLong("ID"));
                    department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                    department.setFoundate(rs.getDate("FOUNDATE"));
                    department.setPhone(rs.getString("PHONE"));
                    department.seteMail(rs.getString("EMAIL"));
                    department.setAssets(rs.getFloat("ASSETS"));
                    department.setObligation(rs.getString("DEPARTMENT_OBLIGATION"));
                    department.setAddress(rs.getString("ADDRESS"));
                    departmentList.add(department);
                }

            } else {
                System.out.println("Connection error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return departmentList;

    }
}
