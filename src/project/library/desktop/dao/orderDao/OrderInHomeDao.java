/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.dao.orderDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.IOrderInHome;
import project.library.desktop.model.Author;
import project.library.desktop.model.Book;
import project.library.desktop.model.GiveBackBook;
import project.library.desktop.model.OrderInHome;
import project.library.desktop.model.OrderInLib;
import project.library.desktop.model.ReadRoom;
import project.library.desktop.model.ReadTable;
import project.library.desktop.model.Reader;
import project.library.desktop.model.employee.Employee;

/**
 *
 * @author user
 */
public class OrderInHomeDao implements IOrderInHome {

    @Override
    public boolean addOrderInHome(Long employeeId, Long readerId, Long bookId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "Insert into order_in_home (id,employee_id,reader_id,book_id) values(order_in_home_seq.nextval,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, employeeId);
                ps.setLong(2, readerId);
                ps.setLong(3, bookId);
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
    public boolean updateOrderActive(Long id, Long bookId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update order_in_home set active=0 where reader_id=? and book_id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setFloat(1, id);
                ps.setLong(2, bookId);
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
    public List<OrderInHome> orderInHomeCurrent(String choose) throws Exception {
        List<OrderInHome> getOrderList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,\n"
                + "       oil.id,\n"
                + "       E.F_NAME,\n"
                + "       E.L_NAME,\n"
                + "       R.F_NAME,\n"
                + "       R.L_NAME,\n"
                + "       R.CARD_NUMBER,\n"
                + "       B.ISBN,\n"
                + "       B.TITLE,\n"
                + "       A.F_NAME,\n"
                + "       A.L_NAME\n"
                + "  FROM order_in_home oil\n"
                + "       INNER JOIN employee e\n"
                + "          ON e.id = OIL.EMPLOYEE_ID\n"
                + "       LEFT JOIN reader r\n"
                + "          ON r.id = OIL.READER_ID\n"
                + "       LEFT JOIN book b\n"
                + "          ON b.id = OIL.BOOK_ID\n"
                + "       INNER JOIN book_author ba\n"
                + "          ON b.id = BA.BOOK_ID\n"
                + "       LEFT JOIN author a\n"
                + "          ON a.id = BA.AUTHOR_ID\n"
                + " WHERE oil.active = 1 AND EXTRACT (DAY FROM TRUNC (oil.data_date)) = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, choose);
                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderInHome inHome = new OrderInHome();
                    inHome.setNumber(rs.getLong("r"));
                    Employee employee = new Employee();
                    employee.setFirstName(rs.getString("f_name"));
                    employee.setLastName(rs.getString("l_name"));
                    Reader reader = new Reader();
                    reader.setFirstName(rs.getString("f_name"));
                    reader.setLastName(rs.getString("l_name"));
                    reader.setCardNumber(rs.getString("card_number"));
                    Book book = new Book();
                    book.setIsbn(rs.getLong("isbn"));
                    book.setTitle(rs.getString("title"));
                    Author author = new Author();
                    author.setFirstName(rs.getString("f_name"));
                    author.setLastName(rs.getString("l_name"));
                    inHome.setEmployee(employee);
                    inHome.setReader(reader);
                    inHome.setBook(book);
                    inHome.setId(rs.getLong("id"));
                    book.setAuthor(author);
                    getOrderList.add(inHome);
                }
            } else {
                System.out.println("Connectio error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return getOrderList;
    }

    @Override
    public Integer getActiveOrderInHome(Long readerId, Long bookId) throws Exception {
        Integer active = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT OIL.ACTIVE\n"
                + "  FROM order_in_home oil\n"
                + " WHERE OIL.BOOK_ID = ? AND OIL.READER_ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, bookId);
                ps.setLong(2, readerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    active = rs.getInt("ACTIVE");
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return active;
    }

    @Override
    public Integer getBooksCountSpecifig(int choose, Long id, String sqlChoose1) throws Exception {
        Integer result = null;
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = "SELECT SUM (COUNT (OIL.BOOK_ID)) as allOrderCount \n"
                + "    FROM order_in_home oil\n"
                + "   WHERE oil.active = 1\n"
                + "GROUP BY OIL.BOOK_ID";
        String sql2 = "SELECT SUM (COUNT (s.id)) as subjectCount\n"
                + "    FROM order_in_home oil\n"
                + "         INNER JOIN book b\n"
                + "            ON b.id = OIL.BOOK_ID\n"
                + "         INNER JOIN book_subject bs\n"
                + "            ON BS.BOOK_ID = b.id\n"
                + "         INNER JOIN subjects s\n"
                + "            ON s.id = BS.SUBJECT_ID\n"
                + "   WHERE oil.active = 1\n"
                + "GROUP BY s.id\n"
                + "  HAVING s.id = ?";
        String sql3 = "SELECT SUM (COUNT (OIL.BOOK_ID)) AS BOOKCOUNT\n"
                + "    FROM ORDER_IN_home OIL INNER JOIN BOOK B ON B.ID = OIL.BOOK_ID\n"
                + "   WHERE OIL.ACTIVE = 1\n"
                + "GROUP BY OIL.BOOK_ID\n"
                + "  HAVING OIL.BOOK_ID = ?";
        String sql4 = " SELECT SUM (COUNT (oil.book_id)) as booksOfAuthor\n"
                + "    FROM order_in_home oil\n"
                + "         INNER JOIN book b\n"
                + "            ON b.id = OIL.BOOK_ID\n"
                + "         INNER JOIN book_author ba\n"
                + "            ON BA.BOOK_ID = b.id\n"
                + "         INNER JOIN author a\n"
                + "            ON a.id = BA.AUTHOR_ID\n"
                + "   WHERE oil.active = 1\n"
                + "GROUP BY a.id\n"
                + "  HAVING a.id = ?";
        String sql5 = "  SELECT SUM (COUNT (OIL.BOOK_ID)) AS BOOKS\n"
                + "    FROM ORDER_IN_home OIL INNER JOIN BOOK B ON B.ID = OIL.BOOK_ID\n"
                + "GROUP BY B.LANGUAGE_ID\n"
                + "  HAVING B.LANGUAGE_ID = ?";
        String sql6 = "SELECT SUM (COUNT (DISTINCT OIL.BOOK_ID))  as bookNoRepeted\n"
                + "    FROM order_in_home oil\n"
                + "   WHERE     oil.active = 1\n"
                + "         AND OIL.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "', 'YYYY-MM-dd')\n"
                + "GROUP BY OIL.BOOK_ID";
        String sql7 = "SELECT SUM (COUNT (s.id)) as subjectCount\n"
                + "    FROM order_in_home oil\n"
                + "         INNER JOIN book b\n"
                + "            ON b.id = OIL.BOOK_ID\n"
                + "         INNER JOIN book_subject bs\n"
                + "            ON BS.BOOK_ID = b.id\n"
                + "         INNER JOIN subjects s\n"
                + "            ON s.id = BS.SUBJECT_ID\n"
                + "   WHERE oil.active = 1 and OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "', 'YYYY-MM-dd')\n"
                + "GROUP BY s.id\n"
                + "  HAVING s.id = ?";
        String sql8 = " SELECT SUM (COUNT (OIL.BOOK_ID)) AS BOOKcOUNT\n"
                + "    FROM order_in_home OIL INNER JOIN BOOK B ON B.ID = OIL.BOOK_ID\n"
                + "   WHERE OIL.ACTIVE = 1 and OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "','YYYY-MM-dd')\n"
                + "GROUP BY OIL.BOOK_ID \n"
                + "  HAVING OIL.BOOK_ID = ?";
        String sql9 = "SELECT SUM (COUNT (oil.book_id)) as booksOfAuthor\n"
                + "    FROM order_in_home oil\n"
                + "         INNER JOIN book b\n"
                + "            ON b.id = OIL.BOOK_ID\n"
                + "         INNER JOIN book_author ba\n"
                + "            ON BA.BOOK_ID = b.id\n"
                + "         INNER JOIN author a\n"
                + "            ON a.id = BA.AUTHOR_ID\n"
                + "   WHERE oil.active = 1 and OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "','YYYY-MM-dd')\n"
                + "GROUP BY a.id\n"
                + "  HAVING a.id = ?";
        String sql10 = " SELECT SUM (COUNT (OIL.BOOK_ID)) AS BOOKS\n"
                + "    FROM order_in_home OIL INNER JOIN BOOK B ON B.ID = OIL.BOOK_ID where oil.active=1 and OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "','YYYY-MM-dd')\n"
                + "GROUP BY B.LANGUAGE_ID\n"
                + "  HAVING B.LANGUAGE_ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (choose == 1) {
                    ps = c.prepareStatement(sql1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("allOrderCount");
                    }
                } else if (choose == 2) {
                    ps = c.prepareStatement(sql2);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("subjectCount");
                    }
                } else if (choose == 3) {
                    ps = c.prepareStatement(sql3);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("BOOKCOUNT");
                    }
                } else if (choose == 4) {
                    ps = c.prepareStatement(sql4);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("booksOfAuthor");
                    }
                } else if (choose == 5) {
                    ps = c.prepareStatement(sql5);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("BOOKS");
                    }
                } else if (choose == 6) {
                    ps = c.prepareStatement(sql6);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("bookNoRepeted");
                    }
                } else if (choose == 7) {
                    ps = c.prepareStatement(sql7);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("subjectCount");
                    }
                } else if (choose == 8) {
                    ps = c.prepareStatement(sql8);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("BOOKcOUNT");
                    }
                } else if (choose == 9) {
                    ps = c.prepareStatement(sql9);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("booksOfAuthor");
                    }
                } else if (choose == 10) {
                    ps = c.prepareStatement(sql10);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("BOOKS");
                    }
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
    public List<OrderInHome> getBooksForTime(int bookId, String time1, String time2) throws Exception {
        List<OrderInHome> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = "";
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (bookId == 1) {
                    sql1 = " SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME AS rf,\n"
                            + "         R.card_number ,\n"
                            + "         R.L_NAME AS rl,\n"
                            + "         E.F_NAME,\n"
                            + "         E.card_number as c,\n"
                            + "         E.L_NAME\n"
                            + "    FROM order_in_home oil\n"
                            + "         INNER JOIN book b\n"
                            + "            ON b.id = OIL.BOOK_ID\n"
                            + "         LEFT JOIN book_author ba\n"
                            + "            ON BA.BOOK_ID = b.id\n"
                            + "         LEFT JOIN author a\n"
                            + "            ON a.id = BA.AUTHOR_ID\n"
                            + "         INNER JOIN reader r\n"
                            + "            ON r.id = OIL.READER_ID\n"
                            + "         INNER JOIN employee e\n"
                            + "            ON e.id = OIL.EMPLOYEE_ID\n"
                            + "   WHERE     1 = 1\n"
                            + "         AND OIL.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-mm-dd')\n"
                            + "         AND OIL.DATA_DATE < TO_DATE ('" + new java.sql.Date(df.parse(time2).getTime()) + "', 'yyyy-mm-dd')\n"
                            + "GROUP BY b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         E.card_number,\n"
                            + "         R.card_number,\n"
                            + "         oil.data_date";

                } else if (bookId == 2) {
                    sql1 = " SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME AS rf,\n"
                            + "         R.L_NAME AS rl,\n"
                            + "         R.card_number ,\n"
                            + "         E.F_NAME,\n"
                            + "         E.card_number as c,\n"
                            + "         E.L_NAME\n"
                            + "    FROM order_in_home oil\n"
                            + "         INNER JOIN book b\n"
                            + "            ON b.id = OIL.BOOK_ID\n"
                            + "         LEFT JOIN book_author ba\n"
                            + "            ON BA.BOOK_ID = b.id\n"
                            + "         LEFT JOIN author a\n"
                            + "            ON a.id = BA.AUTHOR_ID\n"
                            + "         INNER JOIN reader r\n"
                            + "            ON r.id = OIL.READER_ID\n"
                            + "         INNER JOIN employee e\n"
                            + "            ON e.id = OIL.EMPLOYEE_ID\n"
                            + "   WHERE     1= 1\n"
                            + "         AND OIL.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-mm-dd')\n"
                            + "GROUP BY b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         E.card_number,\n"
                            + "         R.card_number,\n"
                            + "         oil.data_date";
                } else if (bookId == 3) {
                    sql1 = " SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME AS rf,\n"
                            + "         R.L_NAME AS rl,\n"
                            + "         R.card_number ,\n"
                            + "         E.F_NAME,\n"
                            + "         R.card_number,\n"
                            + "         E.L_NAME\n"
                            + "    FROM order_in_home oil\n"
                            + "         INNER JOIN book b\n"
                            + "            ON b.id = OIL.BOOK_ID\n"
                            + "         LEFT JOIN book_author ba\n"
                            + "            ON BA.BOOK_ID = b.id\n"
                            + "         LEFT JOIN author a\n"
                            + "            ON a.id = BA.AUTHOR_ID\n"
                            + "         INNER JOIN reader r\n"
                            + "            ON r.id = OIL.READER_ID\n"
                            + "         INNER JOIN employee e\n"
                            + "            ON e.id = OIL.EMPLOYEE_ID\n"
                            + "   WHERE     1 = 1\n"
                            + "         AND OIL.DATA_DATE < TO_DATE ('" + new java.sql.Date(df.parse(time2).getTime()) + "', 'yyyy-mm-dd')\n"
                            + "GROUP BY b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         oil.data_date";
                }
                ps = c.prepareStatement(sql1);

                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderInHome lib = new OrderInHome();
                    Book b = new Book();
                    b.setId(rs.getLong("id"));
                    lib.setNumber(rs.getLong("r"));
                    b.setIsbn(rs.getLong("isbn"));
                    b.setTitle(rs.getString("title"));
                    lib.setData_date(rs.getDate("data_date"));
                    lib.setBook(b);
                    Author author = new Author();
                    author.setFirstName(rs.getString("authors"));
                    lib.setAuthor(author);
                    Reader reader = new Reader();
                    reader.setFirstName(rs.getString("rf"));
                    reader.setLastName(rs.getString("rl"));
                    reader.setCardNumber(rs.getString("c"));
                    lib.setReader(reader);
                    Employee employee = new Employee();
                    employee.setFirstName(rs.getString("f_name"));
                    employee.setLastName(rs.getString("l_name"));
                    employee.setCardNumber(rs.getString("c"));
                    lib.setEmployee(employee);
                    result.add(lib);
                }

            } else {
                System.out.println("Conection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return result;

    }

    @Override
    public List<OrderInHome> getCountForSearch(int choose, Long id, String time1, String time2) throws Exception {
        List<OrderInHome> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (choose == 1) {
                    String sql1 = " SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME AS rf,\n"
                            + "         R.card_number ,\n"
                            + "         R.L_NAME AS rl,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         E.card_number as c\n"
                            + "    FROM order_in_home oil\n"
                            + "         INNER JOIN book b\n"
                            + "            ON b.id = OIL.BOOK_ID\n"
                            + "         LEFT JOIN book_author ba\n"
                            + "            ON BA.BOOK_ID = b.id\n"
                            + "         LEFT JOIN author a\n"
                            + "            ON a.id = BA.AUTHOR_ID\n"
                            + "         INNER JOIN reader r\n"
                            + "            ON r.id = OIL.READER_ID\n"
                            + "         INNER JOIN employee e\n"
                            + "            ON e.id = OIL.EMPLOYEE_ID\n"
                            + "   WHERE     1 = 1\n"
                            + "         AND OIL.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-mm-dd')\n"
                            + "         AND OIL.DATA_DATE < TO_DATE ('" + new java.sql.Date(df.parse(time2).getTime()) + "', 'yyyy-mm-dd')\n"
                            + "GROUP BY b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                               + "         E.card_number,\n"
                               + "        R.card_number,\n"
                            + "         oil.data_date ";
                         
                    ps = c.prepareStatement(sql1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInHome home = new OrderInHome();
                        Book b = new Book();
                        b.setId(rs.getLong("id"));
                        home.setNumber(rs.getLong("r"));
                        b.setIsbn(rs.getLong("isbn"));
                        b.setTitle(rs.getString("title"));
                        home.setData_date(rs.getDate("data_date"));
                        home.setBook(b);
                        Author author = new Author();
                        author.setFirstName(rs.getString("authors"));
                        home.setAuthor(author);
                        Reader reader = new Reader();
                        reader.setFirstName(rs.getString("rf"));
                        reader.setLastName(rs.getString("rl"));
                        reader.setCardNumber(rs.getString("card_number"));
                        home.setReader(reader);
                        Employee employee = new Employee();
                        employee.setFirstName(rs.getString("f_name"));
                        employee.setLastName(rs.getString("l_name"));
                        employee.setCardNumber(rs.getString("c"));
                        home.setEmployee(employee);
                        result.add(home);
                    }
                } else if (choose == 2) {
                    String sql2 = "  SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME AS rf,\n"
                            + "         R.card_number ,\n"
                            + "         R.L_NAME AS rl,\n"
                            + "         E.F_NAME,\n"
                            + "         E.card_number as c,\n"
                            + "         E.L_NAME\n"
                            + "    FROM order_in_home oil\n"
                            + "         INNER JOIN book b\n"
                            + "            ON b.id = OIL.BOOK_ID\n"
                            + "         LEFT JOIN book_author ba\n"
                            + "            ON BA.BOOK_ID = b.id\n"
                            + "         LEFT JOIN author a\n"
                            + "            ON a.id = BA.AUTHOR_ID\n"
                            + "         INNER JOIN reader r\n"
                            + "            ON r.id = OIL.READER_ID\n"
                            + "         INNER JOIN employee e\n"
                            + "            ON e.id = OIL.EMPLOYEE_ID\n"
                            + "   WHERE    1 = 1\n"
                            + "         AND OIL.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-mm-dd')\n"
                            + "GROUP BY b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         E.F_NAME,\n"
                              + "         E.card_number,\n"
                              + "         R.card_number,\n"
                            + "         E.L_NAME,\n"
                            + "         oil.data_date";
                    ps = c.prepareStatement(sql2);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInHome home = new OrderInHome();
                        Book b = new Book();
                        b.setId(rs.getLong("id"));
                        home.setNumber(rs.getLong("r"));
                        b.setIsbn(rs.getLong("isbn"));
                        b.setTitle(rs.getString("title"));
                        home.setData_date(rs.getDate("data_date"));
                        home.setBook(b);
                        Author author = new Author();
                        author.setFirstName(rs.getString("authors"));
                        home.setAuthor(author);
                        Reader reader = new Reader();
                        reader.setFirstName(rs.getString("rf"));
                        reader.setCardNumber(rs.getString("card_number"));
                        reader.setLastName(rs.getString("rl"));
                        home.setReader(reader);
                        Employee employee = new Employee();
                        employee.setFirstName(rs.getString("f_name"));
                        employee.setLastName(rs.getString("l_name"));
                        employee.setCardNumber(rs.getString("c"));
                        home.setEmployee(employee);
                        result.add(home);
                    }
                } else if (choose == 3) {
                    String sql3 = "  SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME AS rf,\n"
                            + "         R.card_number,\n"
                            + "         R.L_NAME AS rl,\n"
                            + "         E.F_NAME,\n"
                            + "         E.card_number as c,\n"
                            + "         E.L_NAME\n"
                            + "    FROM order_in_home oil\n"
                            + "         INNER JOIN book b\n"
                            + "            ON b.id = OIL.BOOK_ID\n"
                            + "         LEFT JOIN book_author ba\n"
                            + "            ON BA.BOOK_ID = b.id\n"
                            + "         LEFT JOIN author a\n"
                            + "            ON a.id = BA.AUTHOR_ID\n"
                            + "         INNER JOIN reader r\n"
                            + "            ON r.id = OIL.READER_ID\n"
                            + "         INNER JOIN employee e\n"
                            + "            ON e.id = OIL.EMPLOYEE_ID\n"
                            + "   WHERE    1 = 1\n"
                            + "         AND OIL.DATA_DATE < TO_DATE ('" + new java.sql.Date(df.parse(time2).getTime()) + "', 'yyyy-mm-dd')\n"
                            + "GROUP BY b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                                 + "         E.card_number,\n"
                                 + "         R.card_number,\n"
                            + "         oil.data_date";
                    ps = c.prepareStatement(sql3);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInHome home = new OrderInHome();
                        Book b = new Book();
                        b.setId(rs.getLong("id"));
                        home.setNumber(rs.getLong("r"));
                        b.setIsbn(rs.getLong("isbn"));
                        b.setTitle(rs.getString("title"));
                        home.setData_date(rs.getDate("data_date"));
                        home.setBook(b);
                        Author author = new Author();
                        author.setFirstName(rs.getString("authors"));
                        home.setAuthor(author);
                        Reader reader = new Reader();
                        reader.setFirstName(rs.getString("rf"));
                        reader.setLastName(rs.getString("rl"));
                        reader.setCardNumber(rs.getString("card_number"));
                        home.setReader(reader);
                        Employee employee = new Employee();
                        employee.setFirstName(rs.getString("f_name"));
                        employee.setLastName(rs.getString("l_name"));
                        employee.setCardNumber(rs.getString("c"));
                        home.setEmployee(employee);
                        result.add(home);
                    }
                } 

             
            } else {
                System.out.println("Conection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return result;

    }

    @Override
    public Integer getOrderActive(Long readerId, Long bookId) throws Exception {
        Integer active = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT active\n"
                + "  FROM order_in_home\n"
                + " WHERE reader_id = ? AND book_id = ? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, readerId);
                ps.setLong(2, bookId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    active = rs.getInt("active");
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return active;

    }

    @Override
    public List<GiveBackBook> getGives(int choose, String time1, String time2) throws Exception {
        List<GiveBackBook> gives = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet rs = null;
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (choose == 1) {
                    String sql = "  SELECT ROWNUM R,\n"
                            + "         E.F_NAME as f,\n"
                            + "         E.L_NAME as l,\n"
                            + "         E.card_number as c,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         R.CARD_NUMBER,\n"
                            + "         B.ISBN,\n"
                            + "         B.TITLE,\n"
                            + "         GBB.DATA_DATE\n"
                            + "    FROM give_back_book_from_home GBB\n"
                            + "         INNER JOIN EMPLOYEE E\n"
                            + "            ON E.ID = GBB.EMPLOYEE_ID\n"
                            + "         INNER JOIN READER R\n"
                            + "            ON R.ID = GBB.READER_ID\n"
                            + "         INNER JOIN BOOK B\n"
                            + "            ON B.ID = GBB.BOOK_ID\n"
                            + "   WHERE     GBB.ACTIVE = 1\n"
                            + "         AND GBB.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-MM-dd')\n"
                            + "         AND GBB.DATA_DATE < TO_DATE ('" + new java.sql.Date(df.parse(time2).getTime()) + "', 'yyyy-MM-dd')\n"
                            + "ORDER BY GBB.DATA_DATE ASC ";
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        GiveBackBook giveBackBook = new GiveBackBook();
                        Book book = new Book();
                        Employee employee = new Employee();
                        Reader reader = new Reader();
                        giveBackBook.setNumber(rs.getLong("r"));
                        giveBackBook.setData_date(rs.getDate("data_date"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        reader.setFirstName(rs.getString("f_name"));
                        reader.setLastName(rs.getString("l_name"));
                        reader.setCardNumber(rs.getString("card_number"));
                        employee.setFirstName(rs.getString("f"));
                        employee.setLastName(rs.getString("l"));
                        employee.setCardNumber(rs.getString("c"));
                        giveBackBook.setEmployee(employee);
                        giveBackBook.setReader(reader);
                        giveBackBook.setBook(book);
                        gives.add(giveBackBook);
                    }

                } else if (choose == 2) {
                    String sql = "SELECT  ROWNUM R,E.F_NAME as f,\n"
                            + "       E.L_NAME as l,\n"
                            + "       E.card_number as c,\n"
                            + "       R.F_NAME,\n"
                            + "       R.L_NAME,\n"
                            + "       R.CARD_NUMBER,\n"
                            + "       B.ISBN,\n"
                            + "       B.TITLE,\n"
                            + "       GBB.DATA_DATE\n"
                            + "  FROM give_back_book_from_home GBB\n"
                            + "       INNER JOIN EMPLOYEE E\n"
                            + "          ON E.ID = GBB.EMPLOYEE_ID\n"
                            + "       INNER JOIN READER R\n"
                            + "          ON R.ID = GBB.READER_ID\n"
                            + "       INNER JOIN BOOK B\n"
                            + "          ON B.ID = GBB.BOOK_ID\n"
                            + " WHERE     GBB.ACTIVE = 1\n"
                            + "       AND GBB.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-MM-dd')\n"
                            + "order by GBB.DATA_DATE asc  ";
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        GiveBackBook giveBackBook = new GiveBackBook();
                        Book book = new Book();
                        Employee employee = new Employee();
                        Reader reader = new Reader();
                        giveBackBook.setNumber(rs.getLong("r"));
                        giveBackBook.setData_date(rs.getDate("data_date"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        reader.setFirstName(rs.getString("f_name"));
                        reader.setLastName(rs.getString("l_name"));
                        reader.setCardNumber(rs.getString("card_number"));
                        employee.setFirstName(rs.getString("f"));
                        employee.setLastName(rs.getString("l"));
                        employee.setCardNumber(rs.getString("c"));
                        giveBackBook.setEmployee(employee);
                        giveBackBook.setReader(reader);
                        giveBackBook.setBook(book);
                        gives.add(giveBackBook);
                    }
                } else if (choose == 3) {

                    String sql = "SELECT  ROWNUM R,E.F_NAME as f,\n"
                            + "       E.L_NAME as l ,\n"
                            + "       E.card_number as c ,\n"
                            + "       R.F_NAME,\n"
                            + "       R.L_NAME,\n"
                            + "       R.CARD_NUMBER,\n"
                            + "       B.ISBN,\n"
                            + "       B.TITLE,\n"
                            + "       GBB.DATA_DATE\n"
                            + "  FROM give_back_book_from_home GBB\n"
                            + "       INNER JOIN EMPLOYEE E\n"
                            + "          ON E.ID = GBB.EMPLOYEE_ID\n"
                            + "       INNER JOIN READER R\n"
                            + "          ON R.ID = GBB.READER_ID\n"
                            + "       INNER JOIN BOOK B\n"
                            + "          ON B.ID = GBB.BOOK_ID\n"
                            + " WHERE     GBB.ACTIVE = 1\n"
                            + "       AND GBB.DATA_DATE < TO_DATE ('" + new java.sql.Date(df.parse(time2).getTime()) + "', 'yyyy-MM-dd')"
                            + "order by GBB.DATA_DATE asc  ";
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        GiveBackBook giveBackBook = new GiveBackBook();
                        Book book = new Book();
                        Employee employee = new Employee();
                        Reader reader = new Reader();
                        giveBackBook.setNumber(rs.getLong("r"));
                        giveBackBook.setData_date(rs.getDate("data_date"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        reader.setFirstName(rs.getString("f_name"));
                        reader.setLastName(rs.getString("l_name"));
                        reader.setCardNumber(rs.getString("card_number"));
                        employee.setFirstName(rs.getString("f"));
                        employee.setLastName(rs.getString("l"));
                        employee.setCardNumber(rs.getString("c"));
                        giveBackBook.setEmployee(employee);
                        giveBackBook.setReader(reader);
                        giveBackBook.setBook(book);
                        gives.add(giveBackBook);
                    }
                }
            } else {
                System.out.println("Connectiion error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return gives;
    }

    @Override
    public boolean updateGiveFromHome(Long readerId, Long bookId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
