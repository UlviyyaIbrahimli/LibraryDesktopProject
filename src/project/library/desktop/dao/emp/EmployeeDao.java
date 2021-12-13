package project.library.desktop.dao.emp;

import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.emp.IEmployee;
import project.library.desktop.model.employee.Branch;
import project.library.desktop.model.employee.Employee;
import project.library.desktop.model.employee.Position;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.model.employee.Department;
import project.library.desktop.model.employee.EducationType;

/* @ Ulviyye Ibrahimli
 */
public class EmployeeDao implements IEmployee {

    @Override
    public List<Employee> getEmployeeList(int choose) throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (choose == 1) {
                    String sql = "SELECT ROWNUM r,\n"
                            + "       E.id,\n"
                            + "       E.F_NAME,\n"
                            + "       E.L_NAME,\n"
                            + "       E.FATHER_NAME,\n"
                            + "       E.DOB,\n"
                            + "       E.GENDER,\n"
                            + "       E.IDENTIFY_NUMBER,\n"
                            + "       E.MARRIAGE_STATUS,\n"
                            + "       E.NATIONALITY,\n"
                            + "       E.CARD_NUMBER,\n"
                            + "       E.BEGIN_TO_WORK,\n"
                            + "       E.SALARY,\n"
                            + "       E.BEGIN_TO_WORK,\n"
                            + "       EE.GRADUATE_DATE,\n"
                            + "       EE.UNIVERSITY,\n"
                            + "       ET.TYPE_NAME,\n"
                            + "       EE.DIPLOMA_NUMBER,\n"
                            + "       P.POSITION_NAME,\n"
                            + "       B.BRANCH_NAME,\n"
                            + "       D.DEPARTMENT_NAME,\n"
                            + "       TT.TIME_TYPE_NAME,\n"
                            + "       EP.PHONE_1,\n"
                            + "       EP.PHONE_2,\n"
                            + "       E.NOTE,\n"
                            + "       EA.COUNTRY,\n"
                            + "       EA.CITY,\n"
                            + "       EA.HOME_NUMBER,\n"
                            + "       EA.HOUSE_NUMBER,\n"
                            + "       EA.STREET,\n"
                            + "       EA.EMAIL,\n"
                            + "       EP.HOME_PHONE,\n"
                            + "       EE.CERTIF_NUMBER\n"
                            + "  FROM employee e\n"
                            + "       LEFT JOIN emp_edu_info eei\n"
                            + "          ON EEI.EMPLOYEE_ID = E.ID\n"
                            + "       LEFT JOIN education ee\n"
                            + "          ON EE.ID = EEI.EDUCATION_ID\n"
                            + "       LEFT JOIN education_type et\n"
                            + "          ON et.id = EE.EDU_DEGREE\n"
                            + "       LEFT JOIN position p\n"
                            + "          ON p.id = E.POSITION_ID\n"
                            + "       LEFT JOIN branch b\n"
                            + "          ON b.id = E.BRANCH_ID\n"
                            + "       LEFT JOIN emp_address ea\n"
                            + "          ON EA.EMPLOYEE_ID = e.id\n"
                            + "       LEFT JOIN emp_phone ep\n"
                            + "          ON EP.EMPLOYEE_ID = e.id\n"
                            + "       LEFT JOIN time_type tt\n"
                            + "          ON TT.ID = P.P_TIME_TYPE_ID\n"
                            + "       LEFT JOIN department d\n"
                            + "          ON d.id = B.DEPARTENT_ID\n"
                            + " WHERE e.active = 1 order by E.F_NAME asc ";
                    pr = c.prepareStatement(sql);
                    rs = pr.executeQuery();
                    while (rs.next()) {
                        Employee employee = new Employee();
                        Branch branch = new Branch();
                        Position position = new Position();
                        EducationType educationType = new EducationType();
                        employee.setId(rs.getLong("ID"));
                        employee.setNumber(rs.getLong("r"));
                        employee.setFirstName(rs.getString("F_NAME"));
                        employee.setLastName(rs.getString("L_NAME"));
                        employee.setFatherName(rs.getString("FATHER_NAME"));
                        employee.setGender(rs.getString("GENDER"));
                        employee.setDob(rs.getDate("DOB"));
                        employee.setIndentifyNumber(rs.getString("IDENTIFY_NUMBER"));
                        employee.setMaritalStatus(rs.getString("MARRIAGE_STATUS"));
                        employee.setNationality(rs.getString("NATIONALITY"));
                        employee.setCardNumber(rs.getString("CARD_NUMBER"));
                        employee.setSalary(rs.getFloat("SALARY"));
                        employee.setNote(rs.getString("NOTE"));
                        employee.setBeginToWork(rs.getDate("BEGIN_TO_WORK"));
                        employee.setUniversity(rs.getString("UNIVERSITY"));
                        employee.setGraduateDate(rs.getDate("GRADUATE_DATE"));
                        employee.setCertification(rs.getString("CERTIF_NUMBER"));
                        employee.setDiplomaNumber(rs.getString("DIPLOMA_NUMBER"));
                        employee.setCountry(rs.getString("COUNTRY"));
                        employee.setCity(rs.getString("CITY"));
                        employee.setStreet(rs.getString("STREET"));
                        employee.setHouseNumber(rs.getString("HOUSE_NUMBER"));
                        employee.setHomeNumber(rs.getString("HOME_NUMBER"));
                        employee.seteMail(rs.getString("EMAIL"));
                        employee.setPhone1(rs.getString("Phone_1"));
                        employee.setPhone2(rs.getString("PHONE_2"));
                        employee.setHomePhone(rs.getString("HOME_PHONE"));
                        position.setPositionName(rs.getString("POSITION_NAME"));
                        branch.setBranchName(rs.getString("BRANCH_NAME"));
                        educationType.setDegreeName(rs.getString("TYPE_NAME"));
                        employee.setEducationType(educationType);
                        employee.setPosition(position);
                        employee.setBranc(branch);
                        employeeList.add(employee);
                    }
                } else if (choose == 2) {
                    String sql = "SELECT ROW_NUMBER () OVER (ORDER BY f_name) AS r, ID,\n"
                            + "         F_NAME,\n"
                            + "         L_NAME,\n"
                            + "         FATHER_NAME,\n"
                            + "         GENDER,\n"
                            + "         DOB,\n"
                            + "         IDENTIFY_NUMBER,\n"
                            + "         NATIONALITY,\n"
                            + "         CARD_NUMBER,\n"
                            + "         MARRIAGE_STATUS\n"
                            + "    FROM EMPLOYEE WHERE  ACTIVE=1\n";
                    pr = c.prepareStatement(sql);
                    rs = pr.executeQuery();
                    while (rs.next()) {
                        Employee employee = new Employee();
                        Branch branch = new Branch();
                        Position position = new Position();
                        employee.setId(rs.getLong("ID"));
                        employee.setNumber(rs.getLong("r"));
                        employee.setFirstName(rs.getString("F_NAME"));
                        employee.setLastName(rs.getString("L_NAME"));
                        employee.setFatherName(rs.getString("FATHER_NAME"));
                        employee.setGender(rs.getString("GENDER"));
                        employee.setDob(rs.getDate("DOB"));
                        employee.setIndentifyNumber(rs.getString("IDENTIFY_NUMBER"));
                        employee.setNationality(rs.getString("NATIONALITY"));
                        employee.setCardNumber(rs.getString("CARD_NUMBER"));
                        employee.setMaritalStatus(rs.getString("MARRIAGE_STATUS"));
                        employeeList.add(employee);
                    }
                } else if (choose == 3) {
                    String sql = "  SELECT ROW_NUMBER () OVER (ORDER BY E.F_NAME) AS r,\n"
                            + "         E.ID,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         E.FATHER_NAME,\n"
                            + "         LISTAGG (TO_CHAR (ET.TYPE_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY TO_CHAR (ET.TYPE_NAME))\n"
                            + "            AS education_degree,\n"
                            + "         EE.UNIVERSITY,\n"
                            + "         EE.GRADUATE_DATE,\n"
                            + "         EE.CERTIF_NUMBER,\n"
                            + "         EE.DIPLOMA_NUMBER\n"
                            + "    FROM EMPLOYEE e\n"
                            + "         LEFT JOIN emp_edu_info eei\n"
                            + "            ON EEI.EMPLOYEE_ID = e.id\n"
                            + "         LEFT JOIN education ee\n"
                            + "            ON EE.ID = EEI.EDUCATION_ID\n"
                            + "         LEFT JOIN education_type et\n"
                            + "            ON et.id = EE.EDU_DEGREE\n"
                            + "   WHERE e.active = 1\n"
                            + "GROUP BY E.ID,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         E.FATHER_NAME,\n"
                            + "         EE.UNIVERSITY,\n"
                            + "         EE.GRADUATE_DATE,\n"
                            + "         EE.CERTIF_NUMBER,\n"
                            + "         EE.DIPLOMA_NUMBER\n"
                            + "ORDER BY E.F_NAME ASC";
                    pr = c.prepareStatement(sql);
                    rs = pr.executeQuery();
                    while (rs.next()) {
                        Employee employee = new Employee();
                        Branch branch = new Branch();
                        EducationType educationType = new EducationType();
                        employee.setId(rs.getLong("ID"));
                        employee.setNumber(rs.getLong("r"));
                        employee.setFirstName(rs.getString("F_NAME"));
                        employee.setLastName(rs.getString("L_NAME"));
                        employee.setFatherName(rs.getString("FATHER_NAME"));
                        employee.setUniversity(rs.getString("UNIVERSITY"));
                        employee.setGraduateDate(rs.getDate("GRADUATE_DATE"));
                        employee.setCertification(rs.getString("CERTIF_NUMBER"));
                        employee.setDiplomaNumber(rs.getString("DIPLOMA_NUMBER"));
                        educationType.setDegreeName(rs.getString("education_degree"));
                        employee.setEducationType(educationType);
                        employeeList.add(employee);
                    }
                } else if (choose == 4) {
                    String sql = "SELECT ROW_NUMBER () OVER (ORDER BY e.f_name) AS r,\n"
                            + "       E.ID,\n"
                            + "       E.F_NAME,\n"
                            + "       E.L_NAME,\n"
                            + "       E.FATHER_NAME,\n"
                            + "       EA.COUNTRY,\n"
                            + "       EA.CITY,\n"
                            + "       EA.STREET,\n"
                            + "       EA.HOUSE_NUMBER,\n"
                            + "       EA.HOME_NUMBER,\n"
                            + "       EA.EMAIL,\n"
                            + "       EP.PHONE_1,\n"
                            + "       EP.PHONE_2,\n"
                            + "       EP.HOME_PHONE,\n"
                            + "       P.POSITION_NAME,\n"
                            + "       B.BRANCH_NAME,\n"
                            + "       B.ADDRESS,\n"
                            + "       B.PHONE\n"
                            + "  FROM EMPLOYEE E\n"
                            + "       LEFT JOIN EMP_ADDRESS EA\n"
                            + "          ON E.ID = EA.EMPLOYEE_ID\n"
                            + "       LEFT JOIN EMP_PHONE EP\n"
                            + "          ON EP.EMPLOYEE_ID = E.ID\n"
                            + "       LEFT JOIN POSITION P\n"
                            + "          ON P.ID = E.POSITION_ID\n"
                            + "       LEFT JOIN BRANCH B\n"
                            + "          ON B.ID = E.BRANCH_ID WHERE E.ACTIVE=1";
                    pr = c.prepareStatement(sql);
                    rs = pr.executeQuery();
                    while (rs.next()) {
                        Employee employee = new Employee();
                        Branch branch = new Branch();
                        Position position = new Position();
                        employee.setId(rs.getLong("ID"));
                        employee.setNumber(rs.getLong("r"));
                        employee.setFirstName(rs.getString("F_NAME"));
                        employee.setLastName(rs.getString("L_NAME"));
                        employee.setFatherName(rs.getString("FATHER_NAME"));
                        employee.setCountry(rs.getString("COUNTRY"));
                        employee.setCity(rs.getString("CITY"));
                        employee.setStreet(rs.getString("STREET"));
                        employee.setHouseNumber(rs.getString("HOUSE_NUMBER"));
                        employee.setHomeNumber(rs.getString("HOME_NUMBER"));
                        employee.seteMail(rs.getString("EMAIL"));
                        employee.setPhone1(rs.getString("Phone_1"));
                        employee.setPhone2(rs.getString("PHONE_2"));
                        employee.setHomePhone(rs.getString("HOME_PHONE"));
                        position.setPositionName(rs.getString("POSITION_NAME"));
                        branch.setBranchName(rs.getString("BRANCH_NAME"));
                        branch.setAddress(rs.getString("ADDRESS"));
                        branch.setPhone(rs.getString("PHONE"));
                        employee.setPosition(position);
                        employee.setBranc(branch);
                        employeeList.add(employee);
                    }
                } else if (choose == 5) {
                    String sql = "SELECT rownum r, E.ID,\n"
                            + "       E.F_NAME,\n"
                            + "       E.L_NAME,\n"
                            + "       E.FATHER_NAME,\n"
                            + "       E.GENDER,\n"
                            + "       E.IDENTIFY_NUMBER,\n"
                            + "       P.POSITION_NAME,\n"
                            + "       B.BRANCH_NAME\n"
                            + "  FROM EMPLOYEE E\n"
                            + "       LEFT JOIN EMP_INFO EI\n"
                            + "          ON EI.EMPLOYEE_ID = E.ID\n"
                            + "       LEFT JOIN EMP_ADDRESS EA\n"
                            + "          ON E.ID = EA.EMPLOYEE_ID\n"
                            + "       LEFT JOIN EMP_PHONE EP\n"
                            + "          ON EP.EMPLOYEE_ID = E.ID\n"
                            + "       LEFT JOIN POSITION P\n"
                            + "          ON P.ID = E.POSITION_ID\n"
                            + "       LEFT JOIN BRANCH B\n"
                            + "          ON B.ID = E.ID\n"
                            + "       LEFT JOIN DEPARTMENT D\n"
                            + "          ON D.ID = B.DEPARTENT_ID  WHERE E.ACTIVE=1 ORDER BY E.F_NAME ASC ";
                    pr = c.prepareStatement(sql);
                    rs = pr.executeQuery();
                    while (rs.next()) {
                        Employee employee = new Employee();
                        Branch branch = new Branch();
                        Position position = new Position();
                        employee.setId(rs.getLong("ID"));
                        employee.setNumber(rs.getLong("r"));
                        employee.setFirstName(rs.getString("F_NAME"));
                        employee.setLastName(rs.getString("L_NAME"));
                        employee.setFatherName(rs.getString("FATHER_NAME"));
                        employee.setGender(rs.getString("GENDER"));
                        employee.setIndentifyNumber(rs.getString("IDENTIFY_NUMBER"));
                        position.setPositionName(rs.getString("POSITION_NAME"));
                        branch.setBranchName(rs.getString("BRANCH_NAME"));
                        employee.setPosition(position);
                        employee.setBranc(branch);
                        employeeList.add(employee);
                    }
                }

            } else {
                System.out.println("Connection error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, rs);
        }
        return employeeList;
    }

    @Override
    public boolean addEmployee(Employee employee) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;
        String sql1
                = " INSERT INTO EMPLOYEE (ID,F_NAME,l_NAME,FATHER_NAME,GENDER,DOB, MARRIAGE_STATUS,IDENTIFY_NUMBER,CARD_NUMBER,NATIONALITY,BEGIN_TO_WORK,SALARY,BRANCH_ID,POSITION_ID,NOTE) VALUES(EMPLOYEE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sql2
                = " insert INTO EMP_ADDRESS(ID,COUNTRY,CITY,STREET,HOUSE_NUMBER,HOME_NUMBER,EMAIL,EMPLOYEE_ID) VALUES(EMP_ADDRESS_SEQ.NEXTVAL,?,?,?,?,?,?,EMPLOYEE_SEQ.CURRVAL)";
        String sql3
                = "  insert INTO EMP_PHONE(ID,PHONE_1,PHONE_2,HOME_PHONE,EMPLOYEE_ID) VALUES(EMP_PHONE_SEQ.NEXTVAL,?,?,?,EMPLOYEE_SEQ.CURRVAL)";
//        String sql4
//                = " insert  INTO EDUCATION(ID,UNIVERSITY,GRADUATE_DATE,DIPLOMA_NUMBER,CERTIF_NUMBER,EDU_DEGREE)VALUES(EDUCATION_SEQ.NEXTVAL,?,?,?,?,?)";
//
//        String sql5 = " insert into EMP_EDU_INFO(id,employee_id,education_id) values(EMP_EDU_INFO_seq.NEXTVAL,EMPLOYEE_SEQ.CURRVAL,EDUCATION_SEQ.CURRVAL)";
        try {
            c = DbHelper.getConnection();
            c.setAutoCommit(false);
            if (c != null) {
                pr = c.prepareStatement(sql1);
                pr.setString(1, employee.getFirstName());
                pr.setString(2, employee.getLastName());
                pr.setString(3, employee.getFatherName());
                pr.setString(4, employee.getGender());
                pr.setDate(5, new java.sql.Date(employee.getDob().getTime()));
                pr.setString(6, employee.getMaritalStatus());
                pr.setString(7, employee.getIndentifyNumber());
                pr.setString(8, employee.getCardNumber());
                pr.setString(9, employee.getNationality());
                pr.setDate(10, new java.sql.Date(employee.getBeginToWork().getTime()));
                pr.setFloat(11, employee.getSalary());
                pr.setLong(12, employee.getBranc().getId());
                pr.setLong(13, employee.getPosition().getId());
                pr.setString(14, employee.getNote());
                pr.addBatch();
                pr.executeBatch();
                pr = c.prepareStatement(sql2);
                pr.setString(1, employee.getCountry());
                pr.setString(2, employee.getCity());
                pr.setString(3, employee.getStreet());
                pr.setString(4, employee.getHouseNumber());
                pr.setString(5, employee.getHomeNumber());
                pr.setString(6, employee.geteMail());
                pr.addBatch();
                pr.executeBatch();
                pr = c.prepareStatement(sql3);
                pr.setString(1, employee.getPhone1());
                pr.setString(2, employee.getPhone2());
                pr.setString(3, employee.getHomeNumber());
                pr.addBatch();
                pr.executeBatch();
//                pr = c.prepareStatement(sql4);
//                pr.setString(1, employee.getUniversity());
//                pr.setDate(2, new java.sql.Date(employee.getGraduateDate().getTime()));
//                pr.setString(3, employee.getDiplomaNumber());
//                pr.setString(4, employee.getCertification());
//                pr.addBatch();
//                pr.executeBatch();
//                pr = c.prepareStatement(sql5);
//                pr.addBatch();
//                pr.executeBatch();
                result = true;
            } else {
                System.out.println("Connection Error!");
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
    public boolean updateEmployee(Long id, Employee employee) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;
        String sql1 = "update employee set F_NAME=?,l_NAME=?,FATHER_NAME=?,GENDER=?,DOB=?, MARRIAGE_STATUS=?,IDENTIFY_NUMBER=?,CARD_NUMBER=?,NATIONALITY=?,BEGIN_TO_WORK=?,SALARY=?,BRANCH_ID=?,POSITION_ID=? where id=?";
        String sql2 = "update emp_address set COUNTRY=?,CITY=?,STREET=?,HOUSE_NUMBER=?,HOME_NUMBER=?,EMAIL=? where employee_id=?";
        String sql3 = "update emp_phone set PHONE_1=?,PHONE_2=?,HOME_PHONE=? where EMPLOYEE_ID=?";
        String sql4 = "update EDUCATION set UNIVERSITY=?,GRADUATE_DATE=?,DIPLOMA_NUMBER=?, where EMPLOYEE_ID=?";
        String sql5 = "update EMP_EDU_INFO  set eeducation_id=? where employee_id=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql1);
                pr = c.prepareStatement(sql1);
                pr.setString(1, employee.getFirstName());
                pr.setString(2, employee.getLastName());
                pr.setString(3, employee.getFatherName());
                pr.setString(4, employee.getGender());
                pr.setDate(5, new java.sql.Date(employee.getDob().getTime()));
                pr.setString(6, employee.getMaritalStatus());
                pr.setString(7, employee.getIndentifyNumber());
                pr.setString(8, employee.getCardNumber());
                pr.setString(9, employee.getNationality());
                pr.setDate(10, new java.sql.Date(employee.getBeginToWork().getTime()));
                pr.setFloat(11, employee.getSalary());
                pr.setLong(12, employee.getBranc().getId());
                pr.setLong(13, employee.getPosition().getId());
                pr.setLong(14, id);
                pr.execute();
                pr = c.prepareStatement(sql2);
                pr.setString(1, employee.getCountry());
                pr.setString(2, employee.getCity());
                pr.setString(3, employee.getStreet());
                pr.setString(4, employee.getHouseNumber());
                pr.setString(5, employee.getHomeNumber());
                pr.setString(6, employee.geteMail());
                pr.setLong(7, id);
                pr.execute();
                pr = c.prepareStatement(sql3);
                pr.setString(1, employee.getPhone1());
                pr.setString(2, employee.getPhone2());
                pr.setString(3, employee.getHomeNumber());
                pr.setLong(4, id);
                pr.addBatch();
                pr.executeBatch();
                pr = c.prepareStatement(sql4);
                pr.setString(1, employee.getUniversity());
                pr.setDate(2, new java.sql.Date(employee.getGraduateDate().getTime()));
                pr.setString(3, employee.getDiplomaNumber());
                pr.setString(4, employee.getCertification());
                pr.addBatch();
                pr.executeBatch();
                pr = c.prepareStatement(sql5);
                pr.addBatch();
                pr.executeBatch();

                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.commit();
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, pr, null);
        }
        return result;
    }

    @Override
    public Employee getEmployeeById(Long id) throws Exception {
        Employee employee = new Employee();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "  SELECT E.ID,\n"
                + "         E.F_NAME,\n"
                + "         E.L_NAME,\n"
                + "         E.FATHER_NAME,\n"
                + "         E.GENDER,\n"
                + "         E.DOB,\n"
                + "         E.IDENTIFY_NUMBER,\n"
                + "         E.MARRIAGE_STATUS,\n"
                + "         E.NATIONALITY,\n"
                + "         E.CARD_NUMBER,\n"
                + "         E.SALARY,\n"
                + "         E.NOTE,\n"
                + "         E.BEGIN_TO_WORK,\n"
                + "         EI.SCHOOL,\n"
                + "         EI.COLLEGE,\n"
                + "         EI.UNIVERSITY_1,\n"
                + "         EI.UNIVERSITY_2,\n"
                + "         EI.UNIVERSITY_3,\n"
                + "         EI.COLLEGE_DIPLOMA,\n"
                + "         EI.COLLEGE_GRADUATION_DATE,\n"
                + "         EI.GRADUATE_DATE_S,\n"
                + "         EI.GRADUATE_DATE_U1,\n"
                + "         EI.GRADUATE_DATE_U2,\n"
                + "         EI.GRADUATE_DATE_U3,\n"
                + "         EI.CERTIFICATE_INFO,\n"
                + "         EI.COLLEGE,\n"
                + "         EI.DIPLOMA_NUMBER_1,\n"
                + "         EI.DIPLOMA_NUMBER_2,\n"
                + "         EI.DIPLOMA_NUMBER_3,\n"
                + "         EA.COUNTRY,\n"
                + "         EA.CITY,\n"
                + "         EA.STREET,\n"
                + "         EA.HOUSE_NUMBER,\n"
                + "         EA.HOME_NUMBER,\n"
                + "         EA.EMAIL,\n"
                + "         EP.PHONE_1,\n"
                + "         EP.PHONE_2,\n"
                + "         EP.HOME_PHONE,\n"
                + "         P.id as pid,\n"
                + "         P.POSITION_NAME,\n"
                + "         B.id bid,\n"
                + "         B.BRANCH_NAME\n"
                + "    FROM EMPLOYEE E\n"
                + "         LEFT JOIN EMP_INFO EI\n"
                + "            ON EI.EMPLOYEE_ID = E.ID\n"
                + "         LEFT JOIN EMP_ADDRESS EA\n"
                + "            ON E.ID = EA.EMPLOYEE_ID\n"
                + "         LEFT JOIN EMP_PHONE EP\n"
                + "            ON EP.EMPLOYEE_ID = E.ID\n"
                + "         LEFT JOIN EMP_EDUCATION_type EEt\n"
                + "            ON EET.EMPLOYEE_ID = E.ID\n"
                + "         LEFT JOIN POSITION P\n"
                + "            ON P.ID = E.POSITION_ID\n"
                + "         LEFT JOIN BRANCH b\n"
                + "            ON B.ID = E.BRANCH_ID\n"
                + "   WHERE E.ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                rs = ps.executeQuery();
                while (rs.next()) {
                    Branch branch = new Branch();
                    Position position = new Position();
                    employee.setId(rs.getLong("ID"));
                    employee.setFirstName(rs.getString("F_NAME"));
                    employee.setLastName(rs.getString("L_NAME"));
                    employee.setFatherName(rs.getString("FATHER_NAME"));
                    employee.setGender(rs.getString("GENDER"));
                    employee.setDob(rs.getDate("DOB"));
                    employee.setIndentifyNumber(rs.getString("IDENTIFY_NUMBER"));
                    employee.setMaritalStatus(rs.getString("MARRIAGE_STATUS"));
                    employee.setNationality(rs.getString("NATIONALITY"));
                    employee.setCardNumber(rs.getString("CARD_NUMBER"));
                    employee.setSalary(rs.getFloat("SALARY"));
                    employee.setNote(rs.getString("NOTE"));
                    employee.setBeginToWork(rs.getDate("BEGIN_TO_WORK"));
                    employee.setUniversity(rs.getString("UNIVERSITY"));
                    employee.setGraduateDate(rs.getDate("GRADUATE_DATE"));
                    employee.setCertification(rs.getString("CERTIF_NUMBER"));
                    employee.setDiplomaNumber(rs.getString("DIPLOMA_NUMBER"));
                    employee.setCountry(rs.getString("COUNTRY"));
                    employee.setCity(rs.getString("CITY"));
                    employee.setStreet(rs.getString("STREET"));
                    employee.setHouseNumber(rs.getString("HOUSE_NUMBER"));
                    employee.setHomeNumber(rs.getString("HOME_NUMBER"));
                    employee.seteMail(rs.getString("EMAIL"));
                    employee.setPhone1(rs.getString("Phone_1"));
                    employee.setPhone2(rs.getString("PHONE_2"));
                    employee.setHomePhone(rs.getString("HOME_PHONE"));
                    position.setId(rs.getLong("pid"));
                    position.setPositionName(rs.getString("POSITION_NAME"));
                    branch.setId(rs.getLong("bid"));
                    branch.setBranchName(rs.getString("BRANCH_NAME"));
                    employee.setPosition(position);
                    employee.setBranc(branch);

                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = " UPDATE EMPLOYEE SET ACTIVE=0 WHERE ID=?";
        String sql2 = "UPDATE EMP_ADDRESS  SET ACTIVE=0 WHERE EMPLOYEE_ID=?";
        String sql3 = "UPDATE EMP_PHONE SET  ACTIVE=0 WHERE EMPLOYEE_ID=?";
        String sql4 = "UPDATE EMP_INFO  SET ACTIVE =0 WHERE EMPLOYEE_ID=?";
        String sql5 = "UPDATE EMP_EDUCATION_TYPE SET ACTIVE=0 WHERE EMPLOYEE_ID=? ";
        try {
            c = DbHelper.getConnection();
            ps = c.prepareStatement(sql1);
            ps.setLong(1, id);
            ps.addBatch();
            ps.executeBatch();
            ps = c.prepareStatement(sql2);
            ps.setLong(1, id);
            ps.addBatch();
            ps.executeBatch();
            ps = c.prepareStatement(sql3);
            ps.setLong(1, id);
            ps.addBatch();
            ps.executeBatch();
            ps = c.prepareStatement(sql4);
            ps.setLong(1, id);
            ps.addBatch();
            ps.executeBatch();
            ps = c.prepareStatement(sql5);
            ps.setLong(1, id);
            ps.addBatch();
            ps.executeBatch();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, rs);
        }
        return result;

    }

    @Override
    public Float count(int choose, String chooseSql) throws Exception {
        Float result = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = "select  count(id) as dep_count from department where active=1";

        String sql2 = "SELECT d.department_name, COUNT (b.ID) AS branch_count\n"
                + "                   FROM branch b INNER JOIN department d ON D.ID = B.DEPARTENT_ID\n"
                + "                   WHERE b.active =1 and d.active=1\n"
                + "               GROUP BY d.department_name\n"
                + "                  HAVING d.department_name =?";

        String sql3 = "select count (b.id)  as branch_count from branch  b inner join department d on d.id=B.DEPARTENT_ID where b.active=1 and d.active=1";

        String sql4 = "select  count(id)  as emp_count from employee where active=1";
        String sql5 = "select  count(gender) as gender_emp_count from employee where gender=? and active=1";
        String sql6 = "select  count(marriage_Status) as marriage_emp_count from employee where marriage_Status=? and active=1";
        String sql7 = "select  d.id,  d. employee_count from department d where d.active=1 and D.DEPARTMENT_NAME=?";

        String sql8 = "select avg (salary)  as avg_salary from employee where active=1";
        String sql9 = "SELECT AVG (salary) AS dep_salary\n"
                + "    FROM employee e\n"
                + "         INNER JOIN branch b\n"
                + "            ON B.ID = E.BRANCH_ID\n"
                + "         INNER JOIN department d\n"
                + "            ON D.ID = B.DEPARTENT_ID  WHERE e.active = 1\n"
                + "GROUP BY D.DEPARTMENT_NAME\n"
                + "  HAVING D.DEPARTMENT_NAME=?";
        String sql10 = "select avg(months_between(sysdate,e.dob)/12) as all_emp_avg_age  from employee e  where e.active=1";
        String sql11 = "SELECT AVG (MONTHS_BETWEEN (SYSDATE, e.dob) / 12) AS avg_age_for_dep\n"
                + "FROM employee e\n"
                + "\n"
                + "         INNER JOIN branch b\n"
                + "            ON B.ID = E.BRANCH_ID\n"
                + "         INNER JOIN department d\n"
                + "            ON D.ID = B.DEPARTENT_ID  WHERE e.active = 1\n"
                + "GROUP BY D.DEPARTMENT_NAME\n"
                + "  HAVING D.DEPARTMENT_NAME= ?";
        String sql12 = "SELECT AVG (MONTHS_BETWEEN (SYSDATE, dob) / 12) AS gender_age_avg\n"
                + "    FROM employee\n"
                + "   WHERE active = 1\n"
                + "GROUP BY gender\n"
                + "  HAVING gender = ?";
        String sql13 = "SELECT COUNT (e.id) AS edu_degree_count\n"
                + "    FROM employee e\n"
                + "         INNER JOIN emp_education_type eet\n"
                + "            ON EET.EMPLOYEE_ID = E.ID\n"
                + "         INNER JOIN education_type et\n"
                + "            ON EET.EDUCATION_TYPE_ID = ET.ID  WHERE e.active = 1 and eet.active=1 \n"
                + "GROUP BY ET.id\n"
                + "  HAVING ET.id = ?";

        String sql14 = "select gender, avg(months_between(sysdate,dob)/12) as avg_age from employee where active=1 group by gender having gender=?";
        String sql15 = "SELECT COUNT (id)as position_count_all\n"
                + "  FROM position p\n"
                + " WHERE active = 1";
        String sql16 = "SELECT COUNT (BP.POSITION_ID) as position_for_branch\n"
                + "    FROM branch_position bp\n"
                + "   WHERE active = 1\n"
                + "GROUP BY BP.BRANCH_ID\n"
                + "  HAVING BP.BRANCH_ID = ?";
        String sql17 = "SELECT COUNT (position_id) as position_for_department\n"
                + "    FROM branch_position bp\n"
                + "         INNER JOIN branch b\n"
                + "            ON B.ID = BP.BRANCH_ID\n"
                + "         INNER JOIN department d\n"
                + "            ON D.ID = B.DEPARTENT_ID  WHERE b.active = 1  and bp.active=1\n"
                + "GROUP BY D.ID\n"
                + "  HAVING D.ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (choose == 1) {
                    ps = c.prepareStatement(sql1);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        result = rs.getFloat("dep_count");
                    }
                } else if (choose == 2) {
                    ps = c.prepareStatement(sql2);
                    ps.setString(1, chooseSql);
                    ps.execute();
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        Department dep = new Department();
                        dep.setDepartmentName(rs.getString("department_name"));
                        result = rs.getFloat("branch_count");
                    }
                } else if (choose == 3) {
                    ps = c.prepareStatement(sql3);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        result = rs.getFloat("branch_count");
                    }
                } else if (choose == 4) {
                    ps = c.prepareStatement(sql4);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        result = rs.getFloat("emp_count");
                    }
                } else if (choose == 5) {
                    ps = c.prepareStatement(sql5);
                    ps.setString(1, chooseSql);
                    ps.execute();
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        result = rs.getFloat("gender_emp_count");
                    }
                } else if (choose == 6) {
                    ps = c.prepareStatement(sql6);
                    ps.setString(1, chooseSql);
                    ps.execute();
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        result = rs.getFloat("marriage_emp_count");
                    }
                } else if (choose == 7) {
                    ps = c.prepareStatement(sql7);
                    ps.setString(1, chooseSql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Department department = new Department();
                        department.setId(rs.getLong("id"));
                        department.setEmployeeCount((rs.getInt("employee_count")));
                        result = rs.getFloat("employee_count");
                    }
                } else if (choose == 8) {
                    ps = c.prepareStatement(sql8);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        result = rs.getFloat("avg_salary");
                    }
                } else if (choose == 9) {
                    ps = c.prepareStatement(sql9);
                    ps.setString(1, chooseSql);
                    ps.execute();
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getFloat("dep_salary");
                    }
                } else if (choose == 10) {
                    ps = c.prepareStatement(sql10);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        result = rs.getFloat("all_emp_avg_age");
                    }
                } else if (choose == 11) {
                    ps = c.prepareStatement(sql11);
                    ps.setString(1, chooseSql);
                    ps.execute();
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getFloat("avg_age_for_dep");
                    }

                } else if (choose == 12) {
                    ps = c.prepareStatement(sql12);
                    ps.setString(1, chooseSql);
                    ps.execute();
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getFloat("gender_age_avg");
                    }
                } else if (choose == 13) {
                    ps = c.prepareStatement(sql13);
                    ps.setLong(1, Long.parseLong(chooseSql));
                    ps.execute();
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getFloat("edu_degree_count");
                    }
                } else if (choose == 14) {
                    ps = c.prepareStatement(sql14);
                    ps.setString(1, chooseSql);
                    ps.execute();
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getFloat("avg_age");
                    }
                } else if (choose == 15) {
                    ps = c.prepareStatement(sql15);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        result = rs.getFloat("position_count_all");
                    }
                } else if (choose == 16) {
                    ps = c.prepareStatement(sql16);
                    ps.setLong(1, Long.parseLong(chooseSql));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getFloat("position_for_branch");
                    }
                } else if (choose == 17) {
                    ps = c.prepareStatement(sql17);
                    ps.setLong(1, Long.valueOf(chooseSql));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getFloat("position_for_department");
                    }
                }
            } else {
                System.out.println("Connection error");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return result;
    }

    @Override
    public List<Employee> getEmployeeForOrder(Long id) throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT e.id, e.f_name, e.l_name\n"
                + "  FROM employee e INNER JOIN position p ON p.id = E.POSITION_ID\n"
                + " WHERE p.id = ? and e.active=1";
        try {
            c = DbHelper.getConnection();

            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getLong("id"));
                    employee.setFirstName(rs.getString("f_name"));
                    employee.setLastName(rs.getString("l_name"));
                    employeeList.add(employee);
                }
            } else {
                System.out.println("Connection error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return employeeList;

    }

    @Override
    public List<Employee> searchEmployee(String keyword) throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT ROW_NUMBER () OVER (ORDER BY e.id) AS r,\n"
                + "         E.ID,\n"
                + "         E.F_NAME,\n"
                + "         E.L_NAME,\n"
                + "         E.FATHER_NAME,\n"
                + "         E.GENDER,\n"
                + "         E.DOB,\n"
                + "         E.IDENTIFY_NUMBER,\n"
                + "         E.MARRIAGE_STATUS,\n"
                + "         E.NATIONALITY,\n"
                + "         E.CARD_NUMBER,\n"
                + "         E.SALARY,\n"
                + "         E.NOTE,\n"
                + "         E.BEGIN_TO_WORK,\n"
                + "         EI.SCHOOL,\n"
                + "         EI.COLLEGE,\n"
                + "         EI.UNIVERSITY_1,\n"
                + "         EI.UNIVERSITY_2,\n"
                + "         EI.UNIVERSITY_3,\n"
                + "         EI.COLLEGE_DIPLOMA,\n"
                + "         EI.COLLEGE_GRADUATION_DATE,\n"
                + "         EI.GRADUATE_DATE_S,\n"
                + "         EI.GRADUATE_DATE_U1,\n"
                + "         EI.graduate_date_u3,\n"
                + "         EI.GRADUATE_DATE_U2,\n"
                + "         EI.CERTIFICATE_INFO,\n"
                + "         EI.COLLEGE,\n"
                + "         EI.DIPLOMA_NUMBER_1,\n"
                + "         EI.DIPLOMA_NUMBER_2,\n"
                + "         EI.DIPLOMA_NUMBER_3,\n"
                + "         EA.COUNTRY,\n"
                + "         EA.CITY,\n"
                + "         EA.STREET,\n"
                + "         EA.HOUSE_NUMBER,\n"
                + "         EA.HOME_NUMBER,\n"
                + "         EA.EMAIL,\n"
                + "         EP.PHONE_1,\n"
                + "         EP.PHONE_2,\n"
                + "         EP.HOME_PHONE,\n"
                + "         LISTAGG (TO_CHAR (et.TYPE_NAME), ',')\n"
                + "            WITHIN GROUP (ORDER BY TO_CHAR (et.TYPE_NAME))\n"
                + "            AS education_Degree,\n"
                + "         P.POSITION_NAME,\n"
                + "         B.BRANCH_NAME,\n"
                + "         TT.TIME_TYPE_NAME\n"
                + "    FROM EMPLOYEE E\n"
                + "         LEFT JOIN EMP_INFO EI\n"
                + "            ON EI.EMPLOYEE_ID = E.ID\n"
                + "         LEFT JOIN EMP_ADDRESS EA\n"
                + "            ON E.ID = EA.EMPLOYEE_ID\n"
                + "         LEFT JOIN EMP_PHONE EP\n"
                + "            ON EP.EMPLOYEE_ID = E.ID\n"
                + "         LEFT JOIN emp_education_type eet\n"
                + "            ON EET.EMPLOYEE_ID = E.ID\n"
                + "         LEFT JOIN education_type et\n"
                + "            ON EET.EDUCATION_TYPE_ID = ET.ID\n"
                + "         LEFT JOIN position p\n"
                + "            ON P.ID = E.POSITION_ID\n"
                + "         LEFT JOIN branch_position bp\n"
                + "            ON BP.POSITION_ID = P.ID\n"
                + "         LEFT JOIN branch b\n"
                + "            ON B.ID = E.BRANCH_ID\n"
                + "         LEFT JOIN time_type tt\n"
                + "            ON TT.ID = P.P_TIME_TYPE_ID\n"
                + "   WHERE    e.active = 1  and eet.active=1 AND ((LOWER (E.F_NAME)) LIKE (LOWER (?))\n"
                + "         OR LOWER (E.L_NAME) LIKE (LOWER (?))\n"
                + "         OR (LOWER (E.FATHER_NAME)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (E.GENDER)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (E.MARRIAGE_STATUS)) LIKE LOWER (?)\n"
                + "         OR (LOWER (E.NATIONALITY)) LIKE (LOWER (?))\n"
                + "         OR E.SALARY LIKE ?\n"
                + "         OR TO_CHAR (E.DOB, 'mm/dd/yyyy') LIKE ?\n"
                + "         OR (LOWER (B.BRANCH_NAME)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (P.POSITION_NAME)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EI.SCHOOL)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EI.UNIVERSITY_1)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EI.UNIVERSITY_2)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EI.UNIVERSITY_3)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EI.COLLEGE)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EI.SCHOOL)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EI.DIPLOMA_NUMBER_1)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EI.DIPLOMA_NUMBER_2)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EI.DIPLOMA_NUMBER_3)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EA.COUNTRY)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EA.CITY)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EA.STREET)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EA.EMAIL)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EA.HOUSE_NUMBER)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EA.HOME_NUMBER)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EP.PHONE_2)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EP.PHONE_2)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (EP.HOME_PHONE)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (ET.TYPE_NAME)) LIKE (LOWER (?))\n"
                + "         OR (LOWER (TT.TIME_TYPE_NAME)) LIKE (LOWER (?)))\n"
                + "GROUP BY E.ID,\n"
                + "         E.F_NAME,\n"
                + "         E.L_NAME,\n"
                + "         E.FATHER_NAME,\n"
                + "         E.GENDER,\n"
                + "         E.DOB,\n"
                + "         E.IDENTIFY_NUMBER,\n"
                + "         E.MARRIAGE_STATUS,\n"
                + "         E.NATIONALITY,\n"
                + "         E.CARD_NUMBER,\n"
                + "         E.SALARY,\n"
                + "         E.NOTE,\n"
                + "         E.BEGIN_TO_WORK,\n"
                + "         EI.SCHOOL,\n"
                + "         EI.COLLEGE,\n"
                + "         EI.UNIVERSITY_1,\n"
                + "         EI.UNIVERSITY_2,\n"
                + "         EI.UNIVERSITY_3,\n"
                + "         EI.COLLEGE_DIPLOMA,\n"
                + "         EI.COLLEGE_GRADUATION_DATE,\n"
                + "         EI.GRADUATE_DATE_S,\n"
                + "         EI.GRADUATE_DATE_U1,\n"
                + "         EI.GRADUATE_DATE_U2,\n"
                + "         EI.graduate_date_u3,\n"
                + "         EI.CERTIFICATE_INFO,\n"
                + "         EI.COLLEGE,\n"
                + "         EI.DIPLOMA_NUMBER_1,\n"
                + "         EI.DIPLOMA_NUMBER_2,\n"
                + "         EI.DIPLOMA_NUMBER_3,\n"
                + "         EA.COUNTRY,\n"
                + "         EA.CITY,\n"
                + "         EA.STREET,\n"
                + "         EA.HOUSE_NUMBER,\n"
                + "         EA.HOME_NUMBER,\n"
                + "         EA.EMAIL,\n"
                + "         EP.PHONE_1,\n"
                + "         EP.PHONE_2,\n"
                + "         EP.HOME_PHONE,\n"
                + "         P.POSITION_NAME,\n"
                + "         B.BRANCH_NAME,\n"
                + "         TT.TIME_TYPE_NAME";
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
                pr.setString(8, "%" + keyword + "%");
                pr.setString(9, "%" + keyword + "%");
                pr.setString(10, "%" + keyword + "%");
                pr.setString(11, "%" + keyword + "%");
                pr.setString(12, "%" + keyword + "%");
                pr.setString(13, "%" + keyword + "%");
                pr.setString(14, "%" + keyword + "%");
                pr.setString(15, "%" + keyword + "%");
                pr.setString(16, "%" + keyword + "%");
                pr.setString(17, "%" + keyword + "%");
                pr.setString(18, "%" + keyword + "%");
                pr.setString(19, "%" + keyword + "%");
                pr.setString(20, "%" + keyword + "%");
                pr.setString(21, "%" + keyword + "%");
                pr.setString(22, "%" + keyword + "%");
                pr.setString(23, "%" + keyword + "%");
                pr.setString(24, "%" + keyword + "%");
                pr.setString(25, "%" + keyword + "%");
                pr.setString(26, "%" + keyword + "%");
                pr.setString(27, "%" + keyword + "%");
                pr.setString(28, "%" + keyword + "%");
                pr.setString(29, "%" + keyword + "%");
                pr.setString(30, "%" + keyword + "%");
                rs = pr.executeQuery();
                while (rs.next()) {
                    Employee employee = new Employee();
                    Branch branch = new Branch();
                    Position position = new Position();
                    EducationType educationType = new EducationType();
                    employee.setId(rs.getLong("ID"));
                    employee.setNumber(rs.getLong("r"));
                    employee.setFirstName(rs.getString("F_NAME"));
                    employee.setLastName(rs.getString("L_NAME"));
                    employee.setFatherName(rs.getString("FATHER_NAME"));
                    employee.setGender(rs.getString("GENDER"));
                    employee.setDob(rs.getDate("DOB"));
                    employee.setIndentifyNumber(rs.getString("IDENTIFY_NUMBER"));
                    employee.setMaritalStatus(rs.getString("MARRIAGE_STATUS"));
                    employee.setNationality(rs.getString("NATIONALITY"));
                    employee.setCardNumber(rs.getString("CARD_NUMBER"));
                    employee.setSalary(rs.getFloat("SALARY"));
                    employee.setNote(rs.getString("NOTE"));
                    employee.setBeginToWork(rs.getDate("BEGIN_TO_WORK"));
                    employee.setUniversity(rs.getString("UNIVERSITY"));
                    employee.setGraduateDate(rs.getDate("GRADUATE_DATE"));
                    employee.setCertification(rs.getString("CERTIF_NUMBER"));
                    employee.setDiplomaNumber(rs.getString("DIPLOMA_NUMBER"));
                    employee.setCountry(rs.getString("COUNTRY"));
                    employee.setCity(rs.getString("CITY"));
                    employee.setStreet(rs.getString("STREET"));
                    employee.setHouseNumber(rs.getString("HOUSE_NUMBER"));
                    employee.setHomeNumber(rs.getString("HOME_NUMBER"));
                    employee.seteMail(rs.getString("EMAIL"));
                    employee.setPhone1(rs.getString("Phone_1"));
                    employee.setPhone2(rs.getString("PHONE_2"));
                    employee.setHomePhone(rs.getString("HOME_PHONE"));
                    position.setPositionName(rs.getString("POSITION_NAME"));
                    branch.setBranchName(rs.getString("BRANCH_NAME"));
                    educationType.setDegreeName(rs.getString("education_Degree"));
                    employee.setEducationType(educationType);
                    employee.setPosition(position);
                    employee.setBranc(branch);
                    employeeList.add(employee);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeeWithoutPosition(Long positionId) throws Exception {
        List<Employee> employees = new ArrayList<>();
        Connection c = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "  SELECT ROWNUM r,\n"
                + "       E.ID,\n"
                + "       E.F_NAME,\n"
                + "       E.L_NAME,\n"
                + "       E.FATHER_NAME,\n"
                + "       E.GENDER,\n"
                + "       E.CARD_NUMBER,\n"
                + "       E.IDENTIFY_NUMBER,\n"
                + "       P.POSITION_NAME,\n"
                + "       B.BRANCH_NAME,\n"
                + "       D.DEPARTMENT_NAME\n"
                + "  FROM EMPLOYEE E\n"
                + "       LEFT JOIN POSITION P\n"
                + "          ON P.ID = E.POSITION_ID\n"
                + "       LEFT JOIN branch_position bp\n"
                + "          ON BP.POSITION_ID = p.id\n"
                + "       LEFT JOIN BRANCH B\n"
                + "          ON B.ID = BP.BRANCH_ID\n"
                + "       LEFT JOIN DEPARTMENT D\n"
                + "          ON D.ID = B.DEPARTENT_ID\n"
                + " WHERE E.ACTIVE = 1 AND P.ID = ?\n"
                + "ORDER BY E.F_NAME";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                pr = c.prepareStatement(sql);
                pr.setLong(1, positionId);
                rs = pr.executeQuery();
                while (rs.next()) {
                    Employee employee = new Employee();
                    Branch branch = new Branch();
                    Position position = new Position();
                    employee.setId(rs.getLong("ID"));
                    employee.setNumber(rs.getLong("r"));
                    employee.setFirstName(rs.getString("F_NAME"));
                    employee.setLastName(rs.getString("L_NAME"));
                    employee.setFatherName(rs.getString("FATHER_NAME"));
                    employee.setGender(rs.getString("GENDER"));
                    employee.setCardNumber(rs.getString("CARD_NUMBER"));
                    employee.setIndentifyNumber(rs.getString("IDENTIFY_NUMBER"));
                    position.setPositionName(rs.getString("POSITION_NAME"));
                    branch.setBranchName(rs.getString("BRANCH_NAME"));
                    Department department = new Department();
                    department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                    branch.setDepartment(department);
                    employee.setPosition(position);
                    employee.setBranc(branch);
                    employees.add(employee);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Long getCurrentId() throws Exception {
        Long id = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select  max(id) as maxid from   employee ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    id = rs.getLong("maxid");
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return id;

    }

    @Override
    public boolean addEducationDegree(Long eduTypeId, Long employeeId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO emp_education_type eep (id, employee_id, education_type_id)\n"
                + "     VALUES (emp_education_type_seq.NEXTVAL, ?, ?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (eduTypeId != null) {
                    ps = c.prepareStatement(sql);
                    ps.setLong(1, employeeId);
                    ps.setLong(2, eduTypeId);
                    ps.execute();
                    result = true;

                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return result;
    }

    @Override
    public List<EducationType> eduDegreForEdit(Long employeeId) throws Exception {
        List<EducationType> types = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ET.ID, ET.TYPE_NAME\n"
                + "  FROM EMPLOYEE E\n"
                + "       INNER JOIN EMP_EDUCATION_TYPE EET\n"
                + "          ON EET.EMPLOYEE_ID = E.ID\n"
                + "       INNER JOIN EDUCATION_TYPE ET\n"
                + "          ON ET.ID = EET.EDUCATION_TYPE_ID\n"
                + " WHERE E.ACTIVE = 1 and eet.active=1 AND E.ID = ? order by ET.ID asc ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, employeeId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    EducationType educationType = new EducationType();
                    educationType.setId(rs.getLong("id"));
                    educationType.setDegreeName(rs.getString("type_name"));
                    types.add(educationType);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return types;
    }

    @Override
    public boolean updateEduDegree(Long employeeId, Long eduId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update emp_education_type eet set education_type_id=? where employee_id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, eduId);
                ps.setLong(2, employeeId);
                ps.execute();
                result = true;

            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean deleteEducationDegree(Long employeeId, Long eduId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = "update   emp_education_type set   active=0 where   employee_id=?  and  education_type_id=? ";
        try {
            c = DbHelper.getConnection();
            ps = c.prepareStatement(sql1);
            ps.setLong(1, employeeId);
            ps.setLong(2, eduId);
            ps.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean addEmployee(Long employeeId, Employee employee) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement pr = null;

        String sql4
                = " insert  INTO EDUCATION(ID,UNIVERSITY,GRADUATE_DATE,DIPLOMA_NUMBER,CERTIF_NUMBER,EDU_DEGREE)VALUES(EDUCATION_SEQ.NEXTVAL,?,?,?,?,?)";

        String sql5 = " insert into EMP_EDU_INFO(id,employee_id,education_id) values(EMP_EDU_INFO_seq.NEXTVAL,?,EDUCATION_SEQ.CURRVAL)";
        try {
            c = DbHelper.getConnection();
            c.setAutoCommit(false);
            if (c != null) {
                pr = c.prepareStatement(sql4);
                pr.setString(1, employee.getUniversity());
                pr.setDate(2, new java.sql.Date(employee.getGraduateDate().getTime()));
                pr.setString(3, employee.getDiplomaNumber());
                pr.setString(4, employee.getCertification());
                pr.setLong(5, employee.getEducationType().getId());
                pr.addBatch();
                pr.executeBatch();
                pr = c.prepareStatement(sql5);
                pr.setLong(1, employeeId);
                pr.addBatch();
                pr.executeBatch();
                result = true;
            } else {
                System.out.println("Connection Error!");
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
}
