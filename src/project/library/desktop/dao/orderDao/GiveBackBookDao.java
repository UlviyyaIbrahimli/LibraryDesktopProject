/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.dao.orderDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.DbHelper;
import project.library.desktop.dao.interfaces.IGiveBackBook;
import project.library.desktop.model.Book;
import project.library.desktop.model.Reader;

/**
 *
 * @author user
 */
public class GiveBackBookDao implements IGiveBackBook {

    @Override
    public List<Reader> inLibReader() throws Exception {
        List<Reader> readerList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT r.id,\n"
                + "       R.CARD_NUMBER,\n"
                + "       R.IDENTIFY_NUMBER,\n"
                + "       R.F_NAME,\n"
                + "       R.L_NAME,\n"
                + "       R.FATHER_NAME\n"
                + "  FROM    (  SELECT reader_id,active\n"
                + "               FROM order_in_lib\n"
                + "           GROUP BY reader_id,active) aa\n"
                + "       INNER JOIN\n"
                + "          reader r\n"
                + "       ON r.id = aa.reader_id where aa.active=1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Reader reader = new Reader();
                    reader.setId(rs.getLong("id"));
                    reader.setFirstName(rs.getString("f_name"));
                    reader.setLastName(rs.getString("l_name"));
                    reader.setFatherName(rs.getString("FATHER_NAME"));
                    reader.setCardNumber(rs.getString("card_number"));
                    reader.setIdentifyNumber(rs.getString("identify_number"));
                    readerList.add(reader);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return readerList;

    }

    @Override
    public List<Reader> inHomeReader() throws Exception {
        List<Reader> readerList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT r.id,\n"
                + "       R.CARD_NUMBER,\n"
                + "       R.IDENTIFY_NUMBER,\n"
                + "       R.F_NAME,\n"
                + "       R.L_NAME,\n"
                + "       R.FATHER_NAME\n"
                + "  FROM    (  SELECT reader_id, active\n"
                + "               FROM order_in_home\n"
                + "           GROUP BY reader_id, active) aa\n"
                + "       INNER JOIN\n"
                + "          reader r\n"
                + "       ON r.id = aa.reader_id\n"
                + " WHERE aa.active = 1";

        //  Or
        // String sql="SELECT DISTINCT r.id,
//                R.CARD_NUMBER,
//                R.IDENTIFY_NUMBER,
//                R.F_NAME,
//                R.L_NAME,
//                R.FATHER_NAME
//  FROM order_in_home oih INNER JOIN reader r ON r.id = OIH.READER_ID
// WHERE oih.active = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Reader reader = new Reader();
                    reader.setId(rs.getLong("id"));
                    reader.setFirstName(rs.getString("f_name"));
                    reader.setLastName(rs.getString("l_name"));
                    reader.setFatherName(rs.getString("FATHER_NAME"));
                    reader.setCardNumber(rs.getString("card_number"));
                    reader.setIdentifyNumber(rs.getString("identify_number"));
                    readerList.add(reader);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return readerList;
    }

    @Override
    public List<Reader> readerGetBook() throws Exception {
        List<Reader> readerList = new ArrayList<>();
        List<Reader> readers1 = inHomeReader();
        List<Reader> readers2 = inLibReader();

        readerList.addAll(readers1);
        readerList.addAll(readers2);
        return readerList;

    }

    @Override
    public List<Book> bookInLib(Long readerId) throws Exception {
        List<Book> bookList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "  SELECT b.id, b.title, b.isbn\n"
                + "                  FROM order_in_lib oil\n"
                + "                       INNER JOIN book b\n"
                + "                          ON b.id = oil.book_id\n"
                + "                       INNER JOIN reader r\n"
                + "                          ON r.id = oil.reader_id\n"
                + "                WHERE oil.reader_id = ?  and oil.active=1";

        //  or just one sql command -->select  b.title   from  order_in_lib oil  full join order_in_home oih on OIL.READER_ID=OIH.READER_ID
//full join book b on b.id=OIL.BOOK_ID full join reader  r on r.id=OIL.READER_ID  where r.id=1 ; 
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, readerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getLong("id"));
                    book.setTitle(rs.getString("title"));
                    book.setIsbn(rs.getLong("isbn"));
                    bookList.add(book);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return bookList;
    }

    @Override
    public List<Book> bookInHome(Long readerId) throws Exception {
        List<Book> bookList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT b.id, b.title, b.isbn\n"
                + "  FROM order_in_home oil\n"
                + "       INNER JOIN book b\n"
                + "          ON b.id = oil.book_id\n"
                + "       INNER JOIN reader r\n"
                + "          ON r.id = oil.reader_id\n"
                + " WHERE oil.reader_id = ? and OIL.ACTIVE=1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, readerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getLong("id"));
                    book.setTitle(rs.getString("title"));
                    book.setIsbn(rs.getLong("isbn"));
                    bookList.add(book);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return bookList;
    }

    @Override
    public boolean addGiveBackBook(Long employeeId, Long readerId, Long bookId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "insert into give_back_book (id,employee_id,reader_id,book_id) values(give_back_book_seq.nextval,?,?,?)";
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
    public boolean addGiveBackBookFromHome(Long employeeId, Long readerId, Long bookId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "insert into give_back_book_from_home (id,employee_id,reader_id,book_id) values(give_back_book_seq.nextval,?,?,?)";
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

}
