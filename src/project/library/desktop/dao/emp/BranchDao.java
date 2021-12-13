package project.library.desktop.dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.emp.IBranch;
import project.library.desktop.model.employee.Branch;
import project.library.desktop.model.employee.Department;

/**
 *
 * @ Ulviyye Ibrahimli
 */
public class BranchDao implements IBranch {

    @Override
    public List<Branch> getBranchList() throws Exception {
        List<Branch> branchList = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "  SELECT ROWNUM R,\n"
                + "         B.ID,\n"
                + "         B.BRANCH_NAME,\n"
                + "         B.FOUNDATION_DATE,\n"
                + "         B.PHONE,\n"
                + "         B.ASSETS,\n"
                + "         B.ADDRESS,\n"
                + "         B.EMAIL,\n"
                + "         D.DEPARTMENT_NAME\n"
                + "    FROM BRANCH B INNER JOIN DEPARTMENT D ON D.ID = B.DEPARTENT_ID\n"
                + "   WHERE B.ACTIVE = 1\n"
                + "ORDER BY B.BRANCH_NAME ASC";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                rs = pr.executeQuery();
                while (rs.next()) {
                    Branch branch = new Branch();
                    Department department = new Department();
                    branch.setId(rs.getLong("ID"));
                    branch.setNumber(rs.getLong("r"));
                    branch.setBranchName(rs.getString("BRANCH_NAME"));
                    branch.setPhone(rs.getString("PHONE"));
                    branch.setAddress(rs.getString("ADDRESS"));
                    branch.setFoundate(rs.getDate("FOUNDATION_DATE"));
                    branch.seteMail(rs.getString("EMAIL"));
                    branch.setAssets(rs.getFloat("ASSETS"));
                    department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                    branch.setDepartment(department);
                    branchList.add(branch);
                }
            } else {
                System.out.println("Connection error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, rs);
        }
        return branchList;

    }

    @Override
    public boolean addBranch(Branch branch) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;
        String sql = "INSERT INTO BRANCH(ID,BRANCH_NAME,FOUNDATION_DATE,PHONE,ASSETS,ADDRESS,EMAIL,Departent_id)VALUES(BRANCH_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                pr.setString(1, branch.getBranchName());
                pr.setDate(2, new java.sql.Date(branch.getFoundate().getTime()));
                pr.setString(3, branch.getPhone());
                pr.setFloat(4, branch.getAssets());
                pr.setString(5, branch.getAddress());
                pr.setString(6, branch.geteMail());
                pr.setLong(7, branch.getDepartment().getId());
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
    public Branch getBranchById(Long id) throws Exception {
        Branch branch = new Branch();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        Department dep = new Department();
        String sql = " SELECT b.id, b.branch_name,\n"
                + "       b.phone,\n"
                + "       b.email,\n"
                + "       b.assets,\n"
                + "       b.address,\n"
                + "       b.foundation_date,\n"
                + "       departent_id,\n"
                + "       D.DEPARTMENT_NAME\n"
                + "  FROM branch b INNER JOIN Department d ON D.ID = B.DEPARTENT_ID\n"
                + " WHERE b.id = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                pr.setLong(1, id);
                pr.execute();
                rs = pr.executeQuery();
                while (rs.next()) {
                    branch.setId(rs.getLong("Id"));
                    branch.setBranchName(rs.getString("branch_name"));
                    branch.setPhone(rs.getString("Phone"));
                    branch.seteMail(rs.getString("email"));
                    branch.setAssets(rs.getFloat("assets"));
                    branch.setAddress(rs.getString("address"));
                    branch.setFoundate(rs.getDate("foundation_date"));
                    dep.setId(rs.getLong("Departent_id"));
                    dep.setDepartmentName(rs.getString("Department_name"));
                    branch.setDepartment(dep);
                }
            } else {
                System.out.println("Connection error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, rs);

        }

        return branch;
    }

    @Override
    public boolean updateBranch(Long id, Branch branch) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;
        String sql = "Update branch set branch_name=?,  phone=?,email=?,address=?,foundation_date=?,assets=?, departent_id=? where id=?";
        try {
            c = DbHelper.getConnection();
            pr = c.prepareStatement(sql);
            pr.setString(1, branch.getBranchName());
            pr.setString(2, branch.getPhone());
            pr.setString(3, branch.geteMail());
            pr.setString(4, branch.getAddress());
            pr.setDate(5, new java.sql.Date(branch.getFoundate().getTime()));
            pr.setFloat(6, branch.getAssets());
            pr.setLong(7, branch.getDepartment().getId());
            pr.setLong(8, id);
            pr.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, null);
        }
        return result;
    }

    @Override
    public boolean deleteBranc(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;
        Branch branch = new Branch();
        String sql = "UPDATE BRANCH SET ACTIVE=0 WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                pr.setLong(1, id);
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
    public Branch countEmployee(String name) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Branch branch = new Branch();
        String sql = "SELECT  BRANCH.BRANCH_NAME,  COUNT(EMPLOYEE.ID)  as total FROM EMPLOYEE  INNER JOIN BRANCH ON EMPLOYEE.BRANCH_ID=BRANCH.ID WHERE EMPLOYEE.ACTIVE=1  group by branch_name having BRANCH.BRANCH_NAME=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {

                ps = c.prepareStatement(sql);
                ps.setString(1, name);
                ps.execute();
                rs = ps.executeQuery();
                while (rs.next()) {
                    branch.setEmployeeCount(rs.getInt("total"));

                }

            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return branch;

    }

    @Override
    public List<Branch> getBranchListForDepartment(Long id) throws Exception {
        List<Branch> branchList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT B.ID, B.BRANCH_NAME\n"
                + "  FROM branch b INNER JOIN department d ON D.ID = B.DEPARTENT_ID where D.ID=? and b.active=1";
        try {
            c = DbHelper.getConnection();
            ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Branch branch = new Branch();
                branch.setId(rs.getLong("id"));
                branch.setBranchName(rs.getString("Branch_name"));
                branchList.add(branch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return branchList;
    }

    @Override
    public List<Branch> searchBranch(String keyword) throws Exception {
        List<Branch> branchList = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM  r,\n"
                + "       B.ID,\n"
                + "       B.BRANCH_NAME,\n"
                + "       B.FOUNDATION_DATE,\n"
                + "       B.ADDRESS,\n"
                + "       B.EMAIL,\n"
                + "       B.PHONE,\n"
                + "       B.ASSETS,\n"
                + "       D.DEPARTMENT_NAME\n"
                + "  FROM BRANCH B LEFT JOIN DEPARTMENT D ON D.ID = B.DEPARTENT_ID\n"
                + " WHERE  b.active=1 and(  LOWER (B.BRANCH_NAME) LIKE LOWER (?)\n"
                + "       OR TO_CHAR (B.FOUNDATION_DATE, 'mm/dd/yyyy') LIKE ? \n"
                + "       OR LOWER (B.ADDRESS) LIKE LOWER (?)\n"
                + "       OR LOWER (D.DEPARTMENT_NAME) LIKE LOWER (?)\n"
                + "       OR B.ASSETS LIKE ? \n"
                + "       OR B.PHONE LIKE ?  \n"
                + "       OR LOWER (B.EMAIL) LIKE LOWER (?)) ORDER BY B.BRANCH_NAME ASC ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                pr.setString(1, "%" + keyword + "%");
                pr.setString(2, "%" + keyword + "%");
                pr.setString(3, "%" + keyword + "%");
                pr.setString(4, "%" + keyword + "%");
                pr.setString(5, "%" + keyword + "%");
                pr.setString(6, "%" + keyword + "%");
                pr.setString(7, "%" + keyword + "%");
                rs = pr.executeQuery();
                while (rs.next()) {
                    Branch branch = new Branch();
                    Department department = new Department();
                    branch.setNumber(rs.getLong("r"));
                    branch.setId(rs.getLong("ID"));
                    branch.setBranchName(rs.getString("BRANCH_NAME"));
                    branch.setPhone(rs.getString("PHONE"));
                    branch.setAddress(rs.getString("ADDRESS"));
                    branch.setFoundate(rs.getDate("FOUNDATION_DATE"));
                    branch.seteMail(rs.getString("EMAIL"));
                    department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                    branch.setDepartment(department);
                    branchList.add(branch);
                }
            } else {
                System.out.println("Connection error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, rs);
        }
        return branchList;
    }

    @Override
    public List<Branch> showBranchForDeleteDep(Long id) throws Exception {
        List<Branch> getBranchs = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT row_number() over (order by b.branch_name) as r, B.ID,\n"
                + "       B.BRANCH_NAME,\n"
                + "       B.FOUNDATION_DATE,\n"
                + "       B.PHONE,\n"
                + "       B.ASSETS,\n"
                + "       B.ADDRESS,\n"
                + "       B.EMAIL,\n"
                + "       D.DEPARTMENT_NAME\n"
                + "  FROM BRANCH B INNER JOIN DEPARTMENT D ON D.ID = B.DEPARTENT_ID\n"
                + " WHERE B.ACTIVE = 1 AND D.ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Branch branch = new Branch();
                    branch.setId(rs.getLong("id"));
                    branch.setNumber(rs.getLong("r"));
                    branch.setBranchName(rs.getString("branch_name"));
                    branch.setAddress(rs.getString("address"));
                    branch.setAssets(rs.getFloat("assets"));
                    branch.seteMail(rs.getString("email"));
                    branch.setFoundate(rs.getDate("foundation_date"));
                    branch.setPhone(rs.getString("phone"));
                    Department department = new Department();
                    department.setDepartmentName(rs.getString("department_name"));
                    branch.setDepartment(department);
                    getBranchs.add(branch);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return getBranchs;

    }

}
