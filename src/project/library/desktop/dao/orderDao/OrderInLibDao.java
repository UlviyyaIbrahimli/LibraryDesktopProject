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
import project.library.desktop.dao.ReaderDao;
import project.library.desktop.dao.interfaces.IOrderInLib;
import project.library.desktop.model.Author;
import project.library.desktop.model.Book;
import project.library.desktop.model.BookRoom;
import project.library.desktop.model.GiveBackBook;
import project.library.desktop.model.Language;
import project.library.desktop.model.OrderInLib;
import project.library.desktop.model.ReadRoom;
import project.library.desktop.model.ReadTable;
import project.library.desktop.model.Reader;
import project.library.desktop.model.Subjects;
import project.library.desktop.model.employee.Employee;
import project.library.desktop.service.GiveBackBookService;
import project.library.desktop.service.ReaderService;

/**
 *
 * @author user
 */
public class OrderInLibDao implements IOrderInLib {

    @Override
    public boolean addOrder(Long employeeId, Long reader_id, Long bookId, Long roomId, Long tableId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO order_in_lib (id,\n"
                + " employee_id,\n"
                + " reader_id,\n"
                + " book_id,\n"
                + " read_room_table_id,\n"
                + "  read_room_id)       values(order_in_lib_seq.nextVal,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, employeeId);
                ps.setLong(2, reader_id);
                ps.setLong(3, bookId);
                ps.setLong(4, tableId);
                ps.setLong(5, roomId);
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
    public List<OrderInLib> getOrderListForAll() throws Exception {
        List<OrderInLib> getOrderList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT rowNum r, oil.id,\n"
                + "       E.F_NAME,\n"
                + "       E.L_NAME,\n"
                + "       R.F_NAME,\n"
                + "       R.L_NAME,\n"
                + "       R.CARD_NUMBER,\n"
                + "       B.ISBN,\n"
                + "       B.TITLE,\n"
                + "       A.F_NAME,\n"
                + "       A.L_NAME,\n"
                + "       RT.READ_TABLE_NUMBER,\n"
                + "       RT.with_computer,\n"
                + "       RR.LIB_FLOOR,\n"
                + "       RR.READ_ROOM_NUMBER\n"
                + "  FROM order_in_lib oil\n"
                + "       INNER JOIN employee e\n"
                + "          ON e.id = OIL.EMPLOYEE_ID\n"
                + "       LEFT JOIN reader r\n"
                + "          ON r.id = OIL.READER_ID\n"
                + "       LEFT JOIN read_room rr\n"
                + "          ON RR.ID = OIL.READ_ROOM_ID\n"
                + "       LEFT JOIN read_table rt\n"
                + "          ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                + "       LEFT JOIN book b\n"
                + "          ON b.id = OIL.BOOK_ID\n"
                + "       INNER JOIN book_author ba\n"
                + "          ON b.id = BA.BOOK_ID\n"
                + "       LEFT JOIN author a\n"
                + "          ON a.id = BA.AUTHOR_ID\n"
                + " WHERE oil.active = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderInLib inLib = new OrderInLib();
                    inLib.setNumber(rs.getLong("r"));
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
                    ReadRoom readRoom = new ReadRoom();
                    readRoom.setLibFloor(rs.getInt("lib_floor"));
                    readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                    ReadTable readTable = new ReadTable();
                    readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                    readTable.setWithComputer(rs.getInt("with_computer"));
                    inLib.setEmployee(employee);
                    inLib.setReader(reader);
                    inLib.setBook(book);
                    inLib.setId(rs.getLong("id"));
                    book.setAuthor(author);
                    inLib.setReadRoom(readRoom);
                    inLib.setReadTable(readTable);
                    getOrderList.add(inLib);
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
    public List<OrderInLib> getOrderForSpecifig(String choose) throws Exception {
        List<OrderInLib> getOrderList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT rowNum r, oil.id,\n"
                + "       E.F_NAME,\n"
                + "       E.L_NAME,\n"
                + "       R.F_NAME,\n"
                + "       R.L_NAME,\n"
                + "       R.CARD_NUMBER,\n"
                + "       B.ISBN,\n"
                + "       B.TITLE,\n"
                + "       A.F_NAME,\n"
                + "       A.L_NAME,\n"
                + "       RT.READ_TABLE_NUMBER,\n"
                + "       RT.with_computer,\n"
                + "       RR.LIB_FLOOR,\n"
                + "       RR.READ_ROOM_NUMBER\n"
                + "  FROM order_in_lib oil\n"
                + "       INNER JOIN employee e\n"
                + "          ON e.id = OIL.EMPLOYEE_ID\n"
                + "       LEFT JOIN reader r\n"
                + "          ON r.id = OIL.READER_ID\n"
                + "       LEFT JOIN read_room rr\n"
                + "          ON RR.ID = OIL.READ_ROOM_ID\n"
                + "       LEFT JOIN read_table rt\n"
                + "          ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                + "       LEFT JOIN book b\n"
                + "          ON b.id = OIL.BOOK_ID\n"
                + "       INNER JOIN book_author ba\n"
                + "          ON b.id = BA.BOOK_ID\n"
                + "       LEFT JOIN author a\n"
                + "          ON a.id = BA.AUTHOR_ID\n"
                + " WHERE oil.active = 1 and oil.data_date=to_char(to_date(?,'MM/dd/yyyy'))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, choose);
                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderInLib inLib = new OrderInLib();
                    inLib.setNumber(rs.getLong("r"));
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
                    ReadRoom readRoom = new ReadRoom();
                    readRoom.setLibFloor(rs.getInt("lib_floor"));
                    readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                    ReadTable readTable = new ReadTable();
                    readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                    readTable.setWithComputer(rs.getInt("with_computer"));
                    inLib.setEmployee(employee);
                    inLib.setReader(reader);
                    inLib.setBook(book);
                    inLib.setId(rs.getLong("id"));
                    book.setAuthor(author);
                    inLib.setReadRoom(readRoom);
                    inLib.setReadTable(readTable);
                    getOrderList.add(inLib);
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
    public List<OrderInLib> getOrderInfo(int choose, String sqlChoose1, String sqlChoose2) throws Exception {
        List<OrderInLib> getList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = "SELECT  rownum r,b.id, B.ISBN, B.TITLE, S.SUBJECT_NAME\n"
                + "  FROM order_in_lib oil\n"
                + "       INNER JOIN book b\n"
                + "          ON b.id = OIL.BOOK_ID\n"
                + "       LEFT JOIN book_subject bss\n"
                + "          ON BSS.BOOK_Id = b.id\n"
                + "       LEFT JOIN subjects s\n"
                + "          ON s.id = BSS.SUBJECT_ID\n"
                + " WHERE S.id = ? and oil.active=1 and oil.data_date=to_char(to_date(?,'MM/dd/yyyy'))";
        String sql2 = "SELECT  rownum r,b.id, B.ISBN, B.TITLE, S.SUBJECT_NAME\n"
                + "  FROM order_in_lib oil\n"
                + "       INNER JOIN book b\n"
                + "          ON b.id = OIL.BOOK_ID\n"
                + "       LEFT JOIN book_subject bss\n"
                + "          ON BSS.BOOK_Id = b.id\n"
                + "       LEFT JOIN subjects s\n"
                + "          ON s.id = BSS.SUBJECT_ID\n"
                + " WHERE S.id = ? ";
        String sql3 = "SELECT ROWNUM r,\n"
                + "       b.id,\n"
                + "       B.ISBN,\n"
                + "       b.title,\n"
                + "       B.ABSTRACT,\n"
                + "       B.PAGE,\n"
                + "       B.BOOK_STAR,\n"
                + "       B.B_EDITION,\n"
                + "       B.PUBLISHER,\n"
                + "       B.RELEASE_DATE,\n"
                + "       BL.LANGUAGE,\n"
                + "       A.F_NAME,\n"
                + "       A.L_NAME\n"
                + "  FROM    (  SELECT oil.book_id, oil.active\n"
                + "               FROM order_in_lib oil\n"
                + "           GROUP BY OIL.BOOK_ID,oil.active) bb\n"
                + "       INNER JOIN\n"
                + "                   book b\n"
                + "                LEFT JOIN\n"
                + "                   book_language bl\n"
                + "                ON BL.ID = B.LANGUAGE_ID\n"
                + "             INNER JOIN\n"
                + "                book_author ba\n"
                + "             ON BA.BOOK_ID = B.ID\n"
                + "          LEFT JOIN\n"
                + "             author a\n"
                + "          ON a.id = BA.AUTHOR_ID\n"
                + "       ON b.id = bb.BOOK_ID where bb.active=1";
        String sql4 = "SELECT ROWNUM r,\n"
                + "       b.id,\n"
                + "       B.ISBN,\n"
                + "       b.title,\n"
                + "       B.ABSTRACT,\n"
                + "       B.PAGE,\n"
                + "       B.BOOK_STAR,\n"
                + "       B.B_EDITION,\n"
                + "       B.PUBLISHER,\n"
                + "       B.RELEASE_DATE,\n"
                + "       BL.LANGUAGE,\n"
                + "       A.F_NAME,\n"
                + "       A.L_NAME\n"
                + "  FROM    (  SELECT oil.book_id, oil.data_date\n"
                + "               FROM order_in_lib oil where active=1\n"
                + "           GROUP BY OIL.BOOK_ID, oil.data_date) bb\n"
                + "       INNER JOIN\n"
                + "                   book b\n"
                + "                LEFT JOIN\n"
                + "                   book_language bl\n"
                + "                ON BL.ID = B.LANGUAGE_ID\n"
                + "             INNER JOIN\n"
                + "                book_author ba\n"
                + "             ON BA.BOOK_ID = B.ID\n"
                + "          LEFT JOIN\n"
                + "             author a\n"
                + "          ON a.id = BA.AUTHOR_ID\n"
                + "       ON b.id = bb.BOOK_ID\n"
                + " WHERE bb.data_date = TO_CHAR (TO_DATE (?, 'MM/dd/yyyy'))";
        String sql5 = "  select  rownum r, a.id, A.F_NAME,A.L_NAME,A.FATHER_NAME,A.GENDER,A.REWARD from\n"
                + " (select  book_id from order_in_lib  where active=1 group by book_id) oill\n"
                + "    inner join  book_author ba on OILl.BOOK_ID=BA.BOOK_ID\n"
                + " left join author a  on a.id=BA.AUTHOR_ID ";
        String sql6 = "select rownum r,a.id , A.F_NAME,A.L_NAME,A.FATHER_NAME,A.GENDER,A.REWARD from\n"
                + " (select  book_id from order_in_lib  where active=1 and  data_date=to_char(to_date(?,'MM/dd/yyyy')) group by book_id) oill\n"
                + "    inner join  book_author ba on OILl.BOOK_ID=BA.BOOK_ID\n"
                + " left join author a  on a.id=BA.AUTHOR_ID ";
        String sql7 = "SELECT rownum r,b.id,\n"
                + "       b.title,\n"
                + "       b.isbn,\n"
                + "      bl.id,\n"
                + "       BL.LANGUAGE\n"
                + "  FROM (  SELECT book_id\n"
                + "            FROM order_in_lib\n"
                + "           WHERE active = 1\n"
                + "        GROUP BY book_id) oo\n"
                + "       INNER JOIN book b\n"
                + "          ON b.id = oo.book_id\n"
                + "       INNER JOIN book_language bl\n"
                + "          ON BL.ID = B.LANGUAGE_ID";
        String sql8 = "SELECT rownum r,b.id,\n"
                + "       b.title,\n"
                + "       b.isbn,\n"
                + "      bl.id,\n"
                + "       BL.LANGUAGE\n"
                + "  FROM (  SELECT book_id\n"
                + "            FROM order_in_lib\n"
                + "           WHERE active = 1\n"
                + "        GROUP BY book_id) oo\n"
                + "       INNER JOIN book b\n"
                + "          ON b.id = oo.book_id\n"
                + "       INNER JOIN book_language bl\n"
                + "          ON BL.ID = B.LANGUAGE_ID where bl.id=?";
        String sql9 = "SELECT rownum r,b.id,\n"
                + "       b.title,\n"
                + "       b.isbn,\n"
                + "       BL.LANGUAGE\n"
                + "  FROM (  SELECT book_id\n"
                + "            FROM order_in_lib\n"
                + "           WHERE active = 1 and data_date=to_char(to_date(? ,'MM/dd/yyyy'))\n"
                + "        GROUP BY book_id) oo\n"
                + "       INNER JOIN book b\n"
                + "          ON b.id = oo.book_id\n"
                + "       INNER JOIN book_language bl\n"
                + "          ON BL.ID = B.LANGUAGE_ID where bl.id=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (choose == 1) {
                    ps = c.prepareStatement(sql1);
                    ps.setString(1, sqlChoose1);
                    ps.setString(2, sqlChoose2);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib orderInLib = new OrderInLib();
                        Book book = new Book();
                        Subjects subjects = new Subjects();
                        book.setId(rs.getLong("id"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        subjects.setSubjectName(rs.getString("subject_name"));
                        orderInLib.setNumber(rs.getLong("r"));
                        orderInLib.setBook(book);
                        orderInLib.setSubjects(subjects);
                        getList.add(orderInLib);
                    }
                } else if (choose == 2) {
                    ps = c.prepareStatement(sql2);
                    ps.setString(1, sqlChoose1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib orderInLib = new OrderInLib();
                        Book book = new Book();
                        Subjects subjects = new Subjects();
                        book.setId(rs.getLong("id"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        subjects.setSubjectName(rs.getString("subject_name"));
                        orderInLib.setNumber(rs.getLong("r"));
                        orderInLib.setBook(book);
                        orderInLib.setSubjects(subjects);
                        getList.add(orderInLib);
                    }
                } else if (choose == 3) {
                    ps = c.prepareStatement(sql3);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib orderInLib = new OrderInLib();
                        Book book = new Book();
                        book.setId(rs.getLong("id"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        book.setbAbstract(rs.getString("ABSTRACT"));
                        book.setPage(rs.getInt("Page"));
                        book.setStar(rs.getFloat("BOOK_STAR"));
                        book.setEdition(rs.getString("B_EDITION"));
                        book.setPublisher(rs.getString("PUBLISHER"));
                        book.setReleaseDate(rs.getDate("RELEASE_DATE"));
                        Language language = new Language();
                        language.setBookLanguage(rs.getString("LANGUAGE"));
                        book.setLanguage(language);
                        Author author = new Author();
                        author.setFirstName(rs.getString("F_NAME"));
                        author.setLastName(rs.getString("l_name"));
                        orderInLib.setAuthor(author);
                        orderInLib.setNumber(rs.getLong("r"));
                        orderInLib.setBook(book);
                        getList.add(orderInLib);
                    }
                } else if (choose == 4) {
                    ps = c.prepareStatement(sql4);
                    ps.setString(1, sqlChoose1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib orderInLib = new OrderInLib();
                        Book book = new Book();
                        book.setId(rs.getLong("id"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        book.setbAbstract(rs.getString("ABSTRACT"));
                        book.setPage(rs.getInt("Page"));
                        book.setStar(rs.getFloat("BOOK_STAR"));
                        book.setEdition(rs.getString("B_EDITION"));
                        book.setPublisher(rs.getString("PUBLISHER"));
                        book.setReleaseDate(rs.getDate("RELEASE_DATE"));
                        Language language = new Language();
                        language.setBookLanguage(rs.getString("LANGUAGE"));
                        book.setLanguage(language);
                        Author author = new Author();
                        author.setFirstName(rs.getString("F_NAME"));
                        author.setLastName(rs.getString("l_name"));
                        orderInLib.setAuthor(author);
                        orderInLib.setNumber(rs.getLong("r"));
                        orderInLib.setBook(book);
                        getList.add(orderInLib);
                    }
                } else if (choose == 5) {
                    ps = c.prepareStatement(sql5);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib orderInLib = new OrderInLib();
                        Author author = new Author();
                        author.setNumber(rs.getLong("r"));
                        author.setId(rs.getLong("id"));
                        author.setFirstName(rs.getString("f_name"));
                        author.setLastName(rs.getString("l_name"));
                        author.setFatherName(rs.getString("father_name"));
                        author.setGender(rs.getString("gender"));
                        author.setReward(rs.getString("reward"));
                        orderInLib.setAuthor(author);
                        getList.add(orderInLib);
                    }
                } else if (choose == 6) {
                    ps = c.prepareStatement(sql6);
                    ps.setString(1, sqlChoose1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib orderInLib = new OrderInLib();
                        Author author = new Author();
                        author.setNumber(rs.getLong("r"));
                        author.setId(rs.getLong("id"));
                        author.setFirstName(rs.getString("f_name"));
                        author.setLastName(rs.getString("l_name"));
                        author.setFatherName(rs.getString("father_name"));
                        author.setGender(rs.getString("gender"));
                        author.setReward(rs.getString("reward"));
                        orderInLib.setAuthor(author);
                        getList.add(orderInLib);
                    }
                } else if (choose == 7) {
                    ps = c.prepareStatement(sql7);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib orderInLib = new OrderInLib();
                        Book book = new Book();
                        book.setId(rs.getLong("id"));
                        book.setNumber(rs.getLong("r"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        Language language = new Language();
                        language.setId(rs.getLong("id"));
                        language.setBookLanguage(rs.getString("language"));
                        book.setLanguage(language);
                        orderInLib.setBook(book);
                        getList.add(orderInLib);
                    }
                } else if (choose == 8) {
                    ps = c.prepareStatement(sql8);
                    ps.setString(1, sqlChoose1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib orderInLib = new OrderInLib();
                        Book book = new Book();
                        book.setId(rs.getLong("id"));
                        book.setNumber(rs.getLong("r"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        Language language = new Language();
                        language.setId(rs.getLong("id"));
                        language.setBookLanguage(rs.getString("language"));
                        book.setLanguage(language);
                        orderInLib.setBook(book);
                        getList.add(orderInLib);
                    }
                } else if (choose == 9) {
                    ps = c.prepareStatement(sql9);
                    ps.setString(1, sqlChoose1);
                    ps.setString(2, sqlChoose2);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib orderInLib = new OrderInLib();
                        Book book = new Book();
                        book.setId(rs.getLong("id"));
                        book.setNumber(rs.getLong("r"));
                        book.setIsbn(rs.getLong("isbn"));
                        book.setTitle(rs.getString("title"));
                        Language language = new Language();
                        language.setBookLanguage(rs.getString("language"));
                        book.setLanguage(language);
                        orderInLib.setBook(book);
                        getList.add(orderInLib);
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
        return getList;

    }

    @Override
    public Integer getOrderInfoSpecifig(int choose, String sqlChoose1, String sqlChoose2) throws Exception {
        Integer result = null;
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = "SELECT SUM (COUNT (OIL.BOOK_ID)) as allOrderCount \n"
                + "    FROM order_in_lib oil\n"
                + "   WHERE oil.active = 1\n"
                + "GROUP BY OIL.BOOK_ID";
        String sql2 = "SELECT SUM (COUNT (s.id)) as subjectCount\n"
                + "    FROM order_in_lib oil\n"
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
                + "    FROM ORDER_IN_LIB OIL INNER JOIN BOOK B ON B.ID = OIL.BOOK_ID\n"
                + "   WHERE OIL.ACTIVE = 1\n"
                + "GROUP BY OIL.BOOK_ID\n"
                + "  HAVING OIL.BOOK_ID = ?";
        String sql4 = " SELECT SUM (COUNT (oil.book_id)) as booksOfAuthor\n"
                + "    FROM order_in_lib oil\n"
                + "         INNER JOIN book b\n"
                + "            ON b.id = OIL.BOOK_ID\n"
                + "         INNER JOIN book_author ba\n"
                + "            ON BA.BOOK_ID = b.id\n"
                + "         INNER JOIN author a\n"
                + "            ON a.id = BA.AUTHOR_ID\n"
                + "   WHERE oil.active = 1\n"
                + "GROUP BY a.id\n"
                + "  HAVING a.id = ?";
        String sql5 = " SELECT SUM (COUNT (OIL.BOOK_ID)) AS BOOKS\n"
                + "    FROM ORDER_IN_LIB OIL INNER JOIN BOOK B ON B.ID = OIL.BOOK_ID where oil.active=1\n"
                + "GROUP BY B.LANGUAGE_ID\n"
                + "  HAVING B.LANGUAGE_ID = ?";
//        String sql6 = "SELECT SUM (COUNT (DISTINCT OIL.BOOK_ID))  as bookNoRepeted\n"
//                + "    FROM order_in_lib oil\n"
//                + "   WHERE     oil.active = 1\n"
//                + "         AND OIL.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "', 'yyyy-MM-dd')\n"
//                + "GROUP BY OIL.BOOK_ID";
        String sql7 = "SELECT SUM (COUNT (s.id)) as subjectCount\n"
                + "    FROM order_in_lib oil\n"
                + "         INNER JOIN book b\n"
                + "            ON b.id = OIL.BOOK_ID\n"
                + "         INNER JOIN book_subject bs\n"
                + "            ON BS.BOOK_ID = b.id\n"
                + "         INNER JOIN subjects s\n"
                + "            ON s.id = BS.SUBJECT_ID\n"
                + "   WHERE oil.active = 1 and OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "', 'yyyy-MM-dd')\n"
                + "GROUP BY s.id\n"
                + "  HAVING s.id = ?";
        String sql8 = " SELECT SUM (COUNT (OIL.BOOK_ID)) AS BOOKcOUNT\n"
                + "    FROM ORDER_IN_LIB OIL INNER JOIN BOOK B ON B.ID = OIL.BOOK_ID\n"
                + "   WHERE OIL.ACTIVE = 1 and OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "','yyyy-MM-dd')\n"
                + "GROUP BY OIL.BOOK_ID \n"
                + "  HAVING OIL.BOOK_ID = ?";
        String sql9 = "SELECT SUM (COUNT (oil.book_id)) as booksOfAuthor\n"
                + "    FROM order_in_lib oil\n"
                + "         INNER JOIN book b\n"
                + "            ON b.id = OIL.BOOK_ID\n"
                + "         INNER JOIN book_author ba\n"
                + "            ON BA.BOOK_ID = b.id\n"
                + "         INNER JOIN author a\n"
                + "            ON a.id = BA.AUTHOR_ID\n"
                + "   WHERE oil.active = 1 and OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "','yyyy-MM-dd')\n"
                + "GROUP BY a.id\n"
                + "  HAVING a.id = ?";
        String sql10 = " SELECT SUM (COUNT (OIL.BOOK_ID)) AS BOOKS\n"
                + "    FROM ORDER_IN_LIB OIL INNER JOIN BOOK B ON B.ID = OIL.BOOK_ID where oil.active=1 and OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(sqlChoose1).getTime()) + "','yyyy-MM-dd')\n"
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
                    ps.setLong(1, Long.parseLong(sqlChoose1));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("subjectCount");
                    }
                } else if (choose == 3) {
                    ps = c.prepareStatement(sql3);
                    ps.setLong(1, Long.parseLong(sqlChoose1));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("BOOKCOUNT");
                    }
                } else if (choose == 4) {
                    ps = c.prepareStatement(sql4);
                    ps.setLong(1, Long.parseLong(sqlChoose1));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("booksOfAuthor");
                    }
                } else if (choose == 5) {
                    ps = c.prepareStatement(sql5);
                    ps.setLong(1, Long.parseLong(sqlChoose1));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("BOOKS");
                    }
//                } else if (choose == 6) {
//                    ps = c.prepareStatement(sql6);
//                    rs = ps.executeQuery();
//                    while (rs.next()) {
//                        result = rs.getInt("bookNoRepeted");
//                    }
                } else if (choose == 7) {
                    ps = c.prepareStatement(sql7);
                    ps.setLong(1, Long.parseLong(sqlChoose2));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("subjectCount");
                    }
                } else if (choose == 8) {
                    ps = c.prepareStatement(sql8);
                    ps.setLong(1, Long.parseLong(sqlChoose2));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("BOOKcOUNT");
                    }
                } else if (choose == 9) {
                    ps = c.prepareStatement(sql9);
                    ps.setLong(1, Long.parseLong(sqlChoose2));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        result = rs.getInt("booksOfAuthor");
                    }
                } else if (choose == 10) {
                    ps = c.prepareStatement(sql10);
                    ps.setLong(1, Long.parseLong(sqlChoose2));
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
    public boolean updateOrderActive(Long id, Long bookId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update order_in_lib set active=0 where reader_id=? and book_id=?";
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
    public Long getRoomId(Long readerId, Long bookId) throws Exception {
        Long result = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select read_room_id from order_in_lib oil where reader_id=? and  book_id=? and active=1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, readerId);
                ps.setLong(2, bookId);
                ps.execute();
                rs = ps.executeQuery();
                while (rs.next()) {
                    result = rs.getLong("read_room_id");
                }
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
    public Long getOrderId(Long readerId, Long bookId) throws Exception {
        Long result = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id from order_in_lib where reader_id=? and book_id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setFloat(1, readerId);
                ps.setLong(2, bookId);
                ps.execute();
                rs = ps.executeQuery();
                while (rs.next()) {
                    result = rs.getLong("id");
                }
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
    public List<OrderInLib> getOrderForCurrent(String Choose) throws Exception {
        List<OrderInLib> getOrderList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT rowNum r, oil.id,\n"
                + "                       E.F_NAME,\n"
                + "                       E.L_NAME,\n"
                + "                       R.F_NAME,\n"
                + "                       R.L_NAME,\n"
                + "                       R.CARD_NUMBER,\n"
                + "                       B.ISBN,\n"
                + "                       B.TITLE,\n"
                + "                       A.F_NAME,\n"
                + "                       A.L_NAME,\n"
                + "                       RT.READ_TABLE_NUMBER,\n"
                + "                       RT.with_computer,\n"
                + "                       RR.LIB_FLOOR,\n"
                + "                       RR.READ_ROOM_NUMBER\n"
                + "                  FROM order_in_lib oil\n"
                + "                       INNER JOIN employee e\n"
                + "                          ON e.id = OIL.EMPLOYEE_ID\n"
                + "                       LEFT JOIN reader r\n"
                + "                          ON r.id = OIL.READER_ID\n"
                + "                       LEFT JOIN read_room rr\n"
                + "                          ON RR.ID = OIL.READ_ROOM_ID\n"
                + "                       LEFT JOIN read_table rt\n"
                + "                          ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                + "                       LEFT JOIN book b\n"
                + "                          ON b.id = OIL.BOOK_ID\n"
                + "                       INNER JOIN book_author ba\n"
                + "                          ON b.id = BA.BOOK_ID\n"
                + "                       LEFT JOIN author a\n"
                + "                          ON a.id = BA.AUTHOR_ID\n"
                + "                 WHERE oil.active = 1 and EXTRACT(DAY FROM TRUNC(oil.data_date))=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, Choose);
                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderInLib inLib = new OrderInLib();
                    inLib.setNumber(rs.getLong("r"));
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
                    ReadRoom readRoom = new ReadRoom();
                    readRoom.setLibFloor(rs.getInt("lib_floor"));
                    readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                    ReadTable readTable = new ReadTable();
                    readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                    readTable.setWithComputer(rs.getInt("with_computer"));
                    inLib.setEmployee(employee);
                    inLib.setReader(reader);
                    inLib.setBook(book);
                    inLib.setId(rs.getLong("id"));
                    book.setAuthor(author);
                    inLib.setReadRoom(readRoom);
                    inLib.setReadTable(readTable);
                    getOrderList.add(inLib);
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
    public List<OrderInLib> getOrderWarning() throws Exception {
        List<OrderInLib> getOrderList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT rowNum r, oil.id, \n"
                + "                       E.F_NAME, \n"
                + "                       E.L_NAME, \n"
                + "                       R.F_NAME, \n"
                + "                       R.L_NAME, \n"
                + "                       R.CARD_NUMBER, \n"
                + "                       B.ISBN, \n"
                + "                       B.TITLE, \n"
                + "                       A.F_NAME, \n"
                + "                       A.L_NAME, \n"
                + "                       RT.READ_TABLE_NUMBER, \n"
                + "                       RT.with_computer, \n"
                + "                       RR.LIB_FLOOR, \n"
                + "                       RR.READ_ROOM_NUMBER \n"
                + "                  FROM order_in_lib oil \n"
                + "                       INNER JOIN employee e \n"
                + "                          ON e.id = OIL.EMPLOYEE_ID \n"
                + "                       LEFT JOIN reader r \n"
                + "                          ON r.id = OIL.READER_ID \n"
                + "                       LEFT JOIN read_room rr \n"
                + "                          ON RR.ID = OIL.READ_ROOM_ID \n"
                + "                       LEFT JOIN read_table rt \n"
                + "                          ON rt.id = OIL.READ_ROOM_TABLE_ID \n"
                + "                       LEFT JOIN book b \n"
                + "                          ON b.id = OIL.BOOK_ID \n"
                + "                       INNER JOIN book_author ba \n"
                + "                          ON b.id = BA.BOOK_ID \n"
                + "                       LEFT JOIN author a \n"
                + "                          ON a.id = BA.AUTHOR_ID \n"
                + "                 WHERE oil.active = 1 and B.LIMIT_TIMe<(sysdate-oil.data_date)*60*24+15";//15 deq. elave
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderInLib inLib = new OrderInLib();
                    inLib.setNumber(rs.getLong("r"));
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
                    ReadRoom readRoom = new ReadRoom();
                    readRoom.setLibFloor(rs.getInt("lib_floor"));
                    readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                    ReadTable readTable = new ReadTable();
                    readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                    readTable.setWithComputer(rs.getInt("with_computer"));
                    inLib.setEmployee(employee);
                    inLib.setReader(reader);
                    inLib.setBook(book);
                    inLib.setId(rs.getLong("id"));
                    book.setAuthor(author);
                    inLib.setReadRoom(readRoom);
                    inLib.setReadTable(readTable);
                    getOrderList.add(inLib);
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
    public Float getTimeLimite(Long id) throws Exception {
        Float result = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "     select (sysdate-oil.data_date)*60*24 as limit_time from order_in_lib oil  inner join book b on b.id=book_id where OIL.active=1 and b.id=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                rs = ps.executeQuery();
                while (rs.next()) {
                    result = rs.getFloat("limit_time");
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
    public Integer getActive(Long readerId, Long bookId) throws Exception {
        Integer active = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT OIL.ACTIVE\n"
                + "  FROM order_in_lib oil\n"
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
    public OrderInLib getReaderCurrentRoomAndTable(Long readerId) throws Exception {
        OrderInLib inLib = new OrderInLib();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT OIL.READ_ROOM_ID, OIL.READ_ROOM_TABLE_ID\n"
                + "  FROM order_in_lib oil\n"
                + " WHERE OIL.READER_ID = ? AND active = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, readerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ReadRoom readRoom = new ReadRoom();
                    readRoom.setId(rs.getLong("READ_ROOM_ID"));
                    ReadTable readTable = new ReadTable();
                    readTable.setId(rs.getLong("READ_ROOM_TABLE_ID"));
                    inLib.setReadTable(readTable);
                    inLib.setReadRoom(readRoom);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return inLib;
    }

    @Override
    public List<OrderInLib> getOrdersForTable(int choose, Long readerId, Long bookId) throws Exception {
        List<OrderInLib> orders = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql1 = "SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                + "         oil.id,\n"
                + "         b.id,\n"
                + "         b.isbn,\n"
                + "         b.title,\n"
                + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                + "            WITHIN GROUP (ORDER BY (a.id))\n"
                + "            AS authors,\n"
                + "         R.F_NAME as rf ,R.L_NAME as rl ,\n"
                + "         E.F_NAME , E.L_NAME ,\n"
                + "         RR.LIB_FLOOR  ,\n"
                + "         RR.READ_ROOM_NUMBER ,\n"
                + "         RT.READ_TABLE_NUMBER,\n"
                + "         RT.WITH_COMPUTER\n"
                + "    FROM order_in_lib oil\n"
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
                + "         INNER JOIN read_room rr\n"
                + "            ON rr.id = OIL.READ_ROOM_ID\n"
                + "         INNER JOIN read_table rt\n"
                + "            ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                + "   WHERE oil.active = 1\n"
                + "GROUP BY oil.id,\n"
                + "         b.id,\n"
                + "         b.isbn,\n"
                + "         b.title,\n"
                + "         R.F_NAME , R.L_NAME,\n"
                + "         E.F_NAME , E.L_NAME,\n"
                + "         rR.LIB_FLOOR,\n"
                + "         rR.READ_ROOM_NUMBER,\n"
                + "         RT.READ_TABLE_NUMBER,\n"
                + "         RT.WITH_COMPUTER";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql1);
                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderInLib lib = new OrderInLib();
                    Book b = new Book();
                    b.setId(rs.getLong("id"));
                    b.setIsbn(rs.getLong("isbn"));
                    b.setTitle(rs.getString("title"));
                    lib.setNumber(rs.getLong("r"));
                    ReadRoom readRoom = new ReadRoom();
                    readRoom.setLibFloor(rs.getInt("LIB_FLOOR"));
                    readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                    lib.setReadRoom(readRoom);
                    lib.setBook(b);
                    ReadTable readTable = new ReadTable();
                    readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                    readTable.setWithComputer(rs.getInt("WITH_COMPUTER"));
                    lib.setReadTable(readTable);
                    Author author = new Author();
                    author.setFirstName(rs.getString("authors"));
                    lib.setAuthor(author);
                    Reader reader = new Reader();
                    reader.setFirstName(rs.getString("rf"));
                    reader.setLastName(rs.getString("rl"));
                    lib.setReader(reader);
                    Employee employee = new Employee();
                    employee.setFirstName(rs.getString("f_name"));
                    employee.setLastName(rs.getString("l_name"));
                    lib.setEmployee(employee);
                    orders.add(lib);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return orders;
    }

    @Override
    public List<OrderInLib> getResultWithTimeArround(int choose, Long id, String time1, String time2) throws Exception {
        List<OrderInLib> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        String sql = "SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                + "         oil.id,\n"
                + "         oil.data_date,\n"
                + "         b.id,\n"
                + "         b.isbn,\n"
                + "         b.title,\n"
                + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                + "            WITHIN GROUP (ORDER BY (a.id))\n"
                + "            AS authors,\n"
                + "         R.F_NAME as rf ,R.L_NAME as rl ,\n"
                + "         E.F_NAME , E.L_NAME ,\n"
                + "         RR.LIB_FLOOR  ,\n"
                + "         RR.READ_ROOM_NUMBER ,\n"
                + "         RT.READ_TABLE_NUMBER,\n"
                + "         RT.WITH_COMPUTER\n"
                + "    FROM order_in_lib oil\n"
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
                + "         INNER JOIN read_room rr\n"
                + "            ON rr.id = OIL.READ_ROOM_ID\n"
                + "         INNER JOIN read_table rt\n"
                + "            ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                + "   WHERE oil.active = 1  and  OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(time1).getTime()) + "','yyyy-MM-dd')  and \n"
                + "  OIL.DATA_DATE<to_date('" + new java.sql.Date(df.parse(time2).getTime()) + "','yyyy-MM-dd')\n"
                + "GROUP BY oil.id,\n"
                + "         b.id,\n"
                + "         b.isbn,\n"
                + "         b.title,\n"
                + "         R.F_NAME , R.L_NAME,\n"
                + "         E.F_NAME , E.L_NAME,\n"
                + "         rR.LIB_FLOOR,\n"
                + "         rR.READ_ROOM_NUMBER,\n"
                + "         RT.READ_TABLE_NUMBER,\n"
                + "         RT.WITH_COMPUTER,"
                + "           oil.data_date";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (choose == 1) {
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib lib = new OrderInLib();
                        Book b = new Book();
                        b.setId(rs.getLong("id"));
                        lib.setNumber(rs.getLong("r"));
                        b.setIsbn(rs.getLong("isbn"));
                        b.setTitle(rs.getString("title"));
                        lib.setData_date(rs.getDate("data_date"));
                        ReadRoom readRoom = new ReadRoom();
                        readRoom.setLibFloor(rs.getInt("LIB_FLOOR"));
                        readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                        lib.setReadRoom(readRoom);
                        lib.setBook(b);
                        ReadTable readTable = new ReadTable();
                        readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                        readTable.setWithComputer(rs.getInt("WITH_COMPUTER"));
                        lib.setReadTable(readTable);
                        Author author = new Author();
                        author.setFirstName(rs.getString("authors"));
                        lib.setAuthor(author);
                        Reader reader = new Reader();
                        reader.setFirstName(rs.getString("rf"));
                        reader.setLastName(rs.getString("rl"));
                        lib.setReader(reader);
                        Employee employee = new Employee();
                        employee.setFirstName(rs.getString("f_name"));
                        employee.setLastName(rs.getString("l_name"));
                        lib.setEmployee(employee);
                        result.add(lib);
                    }
                } else if (choose == 2) {
                    String sql1 = "SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.id,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME as rf ,R.L_NAME as rl ,\n"
                            + "         E.F_NAME , E.L_NAME ,\n"
                            + "         RR.LIB_FLOOR  ,\n"
                            + "         RR.READ_ROOM_NUMBER ,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER\n"
                            + "    FROM order_in_lib oil\n"
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
                            + "         INNER JOIN read_room rr\n"
                            + "            ON rr.id = OIL.READ_ROOM_ID\n"
                            + "         INNER JOIN read_table rt\n"
                            + "            ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                            + "   WHERE oil.active = 1  and  OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(time1).getTime()) + "','yyyy-MM-dd')   \n"
                            + "GROUP BY oil.id,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME , R.L_NAME,\n"
                            + "         E.F_NAME , E.L_NAME,\n"
                            + "         rR.LIB_FLOOR,\n"
                            + "         rR.READ_ROOM_NUMBER,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER,"
                            + "           oil.data_date";
                    ps = c.prepareStatement(sql1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib lib = new OrderInLib();
                        Book b = new Book();
                        b.setId(rs.getLong("id"));
                        lib.setNumber(rs.getLong("r"));
                        b.setIsbn(rs.getLong("isbn"));
                        b.setTitle(rs.getString("title"));
                        lib.setData_date(rs.getDate("data_date"));
                        ReadRoom readRoom = new ReadRoom();
                        readRoom.setLibFloor(rs.getInt("LIB_FLOOR"));
                        readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                        lib.setReadRoom(readRoom);
                        lib.setBook(b);
                        ReadTable readTable = new ReadTable();
                        readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                        readTable.setWithComputer(rs.getInt("WITH_COMPUTER"));
                        lib.setReadTable(readTable);
                        Author author = new Author();
                        author.setFirstName(rs.getString("authors"));
                        lib.setAuthor(author);
                        Reader reader = new Reader();
                        reader.setFirstName(rs.getString("rf"));
                        reader.setLastName(rs.getString("rl"));
                        lib.setReader(reader);
                        Employee employee = new Employee();
                        employee.setFirstName(rs.getString("f_name"));
                        employee.setLastName(rs.getString("l_name"));
                        lib.setEmployee(employee);
                        result.add(lib);
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
    public List<OrderInLib> getResultSysdate(int choose, Long id, String time1) throws Exception {
        List<OrderInLib> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (choose == 1) {
                    String sql1 = "SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.id,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME as rf ,R.L_NAME as rl ,\n"
                            + "         E.F_NAME , E.L_NAME ,\n"
                            + "         RR.LIB_FLOOR  ,\n"
                            + "         RR.READ_ROOM_NUMBER ,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER\n"
                            + "    FROM order_in_lib oil\n"
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
                            + "         INNER JOIN read_room rr\n"
                            + "            ON rr.id = OIL.READ_ROOM_ID\n"
                            + "         INNER JOIN read_table rt\n"
                            + "            ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                            + "   WHERE oil.active = 1  and  OIL.DATA_DATE>=to_date('" + new java.sql.Date(df.parse(time1).getTime()) + "','yyyy-MM-dd')   \n"
                            + "GROUP BY oil.id,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME , R.L_NAME,\n"
                            + "         E.F_NAME , E.L_NAME,\n"
                            + "         rR.LIB_FLOOR,\n"
                            + "         rR.READ_ROOM_NUMBER,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER,"
                            + "           oil.data_date";
                    ps = c.prepareStatement(sql1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib lib = new OrderInLib();
                        Book b = new Book();
                        b.setId(rs.getLong("id"));
                        lib.setNumber(rs.getLong("r"));
                        b.setIsbn(rs.getLong("isbn"));
                        b.setTitle(rs.getString("title"));
                        lib.setData_date(rs.getDate("data_date"));
                        ReadRoom readRoom = new ReadRoom();
                        readRoom.setLibFloor(rs.getInt("LIB_FLOOR"));
                        readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                        lib.setReadRoom(readRoom);
                        lib.setBook(b);
                        ReadTable readTable = new ReadTable();
                        readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                        readTable.setWithComputer(rs.getInt("WITH_COMPUTER"));
                        lib.setReadTable(readTable);
                        Author author = new Author();
                        author.setFirstName(rs.getString("authors"));
                        lib.setAuthor(author);
                        Reader reader = new Reader();
                        reader.setFirstName(rs.getString("rf"));
                        reader.setLastName(rs.getString("rl"));
                        lib.setReader(reader);
                        Employee employee = new Employee();
                        employee.setFirstName(rs.getString("f_name"));
                        employee.setLastName(rs.getString("l_name"));
                        lib.setEmployee(employee);
                        result.add(lib);
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
//yeniler

    @Override
    public List<OrderInLib> getBooksForTime(Long bookId, String time1, String time2) throws Exception {
        List<OrderInLib> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                String sql1 = " SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                        + "         oil.data_date,\n"
                        + "         b.id,\n"
                        + "         b.isbn,\n"
                        + "         b.title,\n"
                        + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                        + "            WITHIN GROUP (ORDER BY (a.id))\n"
                        + "            AS authors,\n"
                        + "         R.F_NAME AS rf,\n"
                        + "         R.L_NAME AS rl,\n"
                        + "         R.card_number,\n"
                        + "         E.F_NAME,\n"
                        + "         E.card_number as c,\n"
                        + "         E.L_NAME,\n"
                        + "         RR.LIB_FLOOR,\n"
                        + "         RR.READ_ROOM_NUMBER,\n"
                        + "         RT.READ_TABLE_NUMBER,\n"
                        + "         RT.WITH_COMPUTER\n"
                        + "    FROM order_in_lib oil\n"
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
                        + "         INNER JOIN read_room rr\n"
                        + "            ON rr.id = OIL.READ_ROOM_ID\n"
                        + "         INNER JOIN read_table rt\n"
                        + "            ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                        + "   WHERE     1=1 \n"
                        + "         AND OIL.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-MM-dd')\n"
                        + "         AND OIL.DATA_DATE < TO_DATE ('" + new java.sql.Date(df.parse(time2).getTime()) + "', 'yyyy-MM-dd')\n"
                        + "GROUP BY b.id,\n"
                        + "         b.isbn,\n"
                        + "         b.title,\n"
                        + "         R.F_NAME,\n"
                        + "         R.L_NAME,\n"
                        + "         E.F_NAME,\n"
                        + "         E.L_NAME,\n"
                        + "         rR.LIB_FLOOR,\n"
                        + "         rR.READ_ROOM_NUMBER,\n"
                        + "         RT.READ_TABLE_NUMBER,\n"
                        + "         RT.WITH_COMPUTER,\n"
                        + "         R.card_number,\n"
                        + "         e.card_number,\n"
                        + "         oil.data_date";

                ps = c.prepareStatement(sql1);
                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderInLib lib = new OrderInLib();
                    Book b = new Book();
                    b.setId(rs.getLong("id"));
                    lib.setNumber(rs.getLong("r"));
                    b.setIsbn(rs.getLong("isbn"));
                    b.setTitle(rs.getString("title"));
                    lib.setData_date(rs.getDate("data_date"));
                    ReadRoom readRoom = new ReadRoom();
                    readRoom.setLibFloor(rs.getInt("LIB_FLOOR"));
                    readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                    lib.setReadRoom(readRoom);
                    lib.setBook(b);
                    ReadTable readTable = new ReadTable();
                    readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                    readTable.setWithComputer(rs.getInt("WITH_COMPUTER"));
                    lib.setReadTable(readTable);
                    Author author = new Author();
                    author.setFirstName(rs.getString("authors"));
                    lib.setAuthor(author);
                    Reader reader = new Reader();
                    reader.setFirstName(rs.getString("rf"));
                    reader.setLastName(rs.getString("rl"));
                    reader.setCardNumber(rs.getString("card_number"));
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
    public List<OrderInLib> getCountForSearch(int choose, Long id, String time1, String time2) throws Exception {
        List<OrderInLib> result = new ArrayList<>();
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
                            + "         R.card_number,\n"
                            + "         R.L_NAME AS rl,\n"
                            + "         E.F_NAME,\n"
                            + "         E.card_number as c,\n"
                            + "         E.L_NAME,\n"
                            + "         RR.LIB_FLOOR,\n"
                            + "         RR.READ_ROOM_NUMBER,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER\n"
                            + "    FROM order_in_lib oil\n"
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
                            + "         INNER JOIN read_room rr\n"
                            + "            ON rr.id = OIL.READ_ROOM_ID\n"
                            + "         INNER JOIN read_table rt\n"
                            + "            ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                            + "   WHERE     1 = 1\n"
                            + "         AND OIL.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-MM-dd')\n"
                            + "         AND OIL.DATA_DATE < TO_DATE ('" + new java.sql.Date(df.parse(time2).getTime()) + "', 'yyyy-MM-dd')\n"
                            + "GROUP BY b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         rR.LIB_FLOOR,\n"
                            + "         rR.READ_ROOM_NUMBER,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER,\n"
                            + "         R.card_number,\n"
                            + "         e.card_number,\n"
                            + "         oil.data_date";
                    ps = c.prepareStatement(sql1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib lib = new OrderInLib();
                        Book b = new Book();
                        b.setId(rs.getLong("id"));
                        lib.setNumber(rs.getLong("r"));
                        b.setIsbn(rs.getLong("isbn"));
                        b.setTitle(rs.getString("title"));
                        lib.setData_date(rs.getDate("data_date"));
                        ReadRoom readRoom = new ReadRoom();
                        readRoom.setLibFloor(rs.getInt("LIB_FLOOR"));
                        readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                        lib.setReadRoom(readRoom);
                        lib.setBook(b);
                        ReadTable readTable = new ReadTable();
                        readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                        readTable.setWithComputer(rs.getInt("WITH_COMPUTER"));
                        lib.setReadTable(readTable);
                        Author author = new Author();
                        author.setFirstName(rs.getString("authors"));
                        lib.setAuthor(author);
                        Reader reader = new Reader();
                        reader.setFirstName(rs.getString("rf"));
                        reader.setLastName(rs.getString("rl"));
                        reader.setCardNumber(rs.getString("card_number"));
                        lib.setReader(reader);
                        Employee employee = new Employee();
                        employee.setFirstName(rs.getString("f_name"));
                        employee.setLastName(rs.getString("l_name"));
                        employee.setCardNumber(rs.getString("c"));
                        lib.setEmployee(employee);
                        result.add(lib);
                    }
                } else if (choose == 2) {
                    String sql2 = " SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME AS rf,\n"
                            + "         R.L_NAME AS rl,\n"
                            + "         R.card_number,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         E.card_number as c,\n"
                            + "         RR.LIB_FLOOR,\n"
                            + "         RR.READ_ROOM_NUMBER,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER\n"
                            + "    FROM order_in_lib oil\n"
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
                            + "         INNER JOIN read_room rr\n"
                            + "            ON rr.id = OIL.READ_ROOM_ID\n"
                            + "         INNER JOIN read_table rt\n"
                            + "            ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                            + "   WHERE     1 = 1\n"
                            + "         AND OIL.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-MM-dd')\n"
                            + "GROUP BY b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         rR.LIB_FLOOR,\n"
                            + "         rR.READ_ROOM_NUMBER,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER,\n"
                            + "         R.card_number,\n"
                            + "         e.card_number,\n"
                            + "         oil.data_date";

                    ps = c.prepareStatement(sql2);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib lib = new OrderInLib();
                        Book b = new Book();
                        b.setId(rs.getLong("id"));
                        lib.setNumber(rs.getLong("r"));
                        b.setIsbn(rs.getLong("isbn"));
                        b.setTitle(rs.getString("title"));
                        lib.setData_date(rs.getDate("data_date"));
                        ReadRoom readRoom = new ReadRoom();
                        readRoom.setLibFloor(rs.getInt("LIB_FLOOR"));
                        readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                        lib.setReadRoom(readRoom);
                        lib.setBook(b);
                        ReadTable readTable = new ReadTable();
                        readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                        readTable.setWithComputer(rs.getInt("WITH_COMPUTER"));
                        lib.setReadTable(readTable);
                        Author author = new Author();
                        author.setFirstName(rs.getString("authors"));
                        lib.setAuthor(author);
                        Reader reader = new Reader();
                        reader.setFirstName(rs.getString("rf"));
                        reader.setLastName(rs.getString("rl"));
                        reader.setCardNumber(rs.getString("card_number"));
                        lib.setReader(reader);
                        Employee employee = new Employee();
                        employee.setFirstName(rs.getString("f_name"));
                        employee.setLastName(rs.getString("l_name"));
                        employee.setCardNumber(rs.getString("c"));
                        lib.setEmployee(employee);
                        result.add(lib);
                    }
                } else if (choose == 3) {
                    String sql3 = " SELECT ROW_NUMBER () OVER (ORDER BY b.id) AS r,\n"
                            + "         oil.data_date,\n"
                            + "         b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         LISTAGG (TO_CHAR (A.F_NAME || '  ' || A.L_NAME), ',')\n"
                            + "            WITHIN GROUP (ORDER BY (a.id))\n"
                            + "            AS authors,\n"
                            + "         R.F_NAME AS rf,\n"
                            + "         R.L_NAME AS rl,\n"
                            + "         R.card_number,\n"
                            + "         E.F_NAME,\n"
                            + "         E.card_number as c,\n"
                            + "         E.L_NAME,\n"
                            + "         RR.LIB_FLOOR,\n"
                            + "         RR.READ_ROOM_NUMBER,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER\n"
                            + "    FROM order_in_lib oil\n"
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
                            + "         INNER JOIN read_room rr\n"
                            + "            ON rr.id = OIL.READ_ROOM_ID\n"
                            + "         INNER JOIN read_table rt\n"
                            + "            ON rt.id = OIL.READ_ROOM_TABLE_ID\n"
                            + "   WHERE     1 = 1\n"
                            + "         AND OIL.DATA_DATE < TO_DATE ('" + new java.sql.Date(df.parse(time2).getTime()) + "', 'yyyy-MM-dd')\n"
                            + "GROUP BY b.id,\n"
                            + "         b.isbn,\n"
                            + "         b.title,\n"
                            + "         R.F_NAME,\n"
                            + "         R.L_NAME,\n"
                            + "         E.F_NAME,\n"
                            + "         E.L_NAME,\n"
                            + "         rR.LIB_FLOOR,\n"
                            + "         rR.READ_ROOM_NUMBER,\n"
                            + "         RT.READ_TABLE_NUMBER,\n"
                            + "         RT.WITH_COMPUTER,\n"
                              + "         R.card_number,\n"
                            + "         e.card_number,\n"
                            + "         oil.data_date";
                    ps = c.prepareStatement(sql3);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        OrderInLib lib = new OrderInLib();
                        Book b = new Book();
                        b.setId(rs.getLong("id"));
                        lib.setNumber(rs.getLong("r"));
                        b.setIsbn(rs.getLong("isbn"));
                        b.setTitle(rs.getString("title"));
                        lib.setData_date(rs.getDate("data_date"));
                        ReadRoom readRoom = new ReadRoom();
                        readRoom.setLibFloor(rs.getInt("LIB_FLOOR"));
                        readRoom.setReadRoomNumber(rs.getString("READ_ROOM_NUMBER"));
                        lib.setReadRoom(readRoom);
                        lib.setBook(b);
                        ReadTable readTable = new ReadTable();
                        readTable.setTableNumber(rs.getString("READ_TABLE_NUMBER"));
                        readTable.setWithComputer(rs.getInt("WITH_COMPUTER"));
                        lib.setReadTable(readTable);
                        Author author = new Author();
                        author.setFirstName(rs.getString("authors"));
                        lib.setAuthor(author);
                        Reader reader = new Reader();
                        reader.setFirstName(rs.getString("rf"));
                        reader.setLastName(rs.getString("rl"));
                        reader.setCardNumber(rs.getString("card_number"));
                        lib.setReader(reader);
                        Employee employee = new Employee();
                        employee.setFirstName(rs.getString("f_name"));
                        employee.setLastName(rs.getString("l_name"));
                        employee.setCardNumber(rs.getString("c"));
                        lib.setEmployee(employee);
                        result.add(lib);
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
    public List<GiveBackBook> getGiveBackBook(int choose, String time1, String time2) throws Exception {
        List<GiveBackBook> gives = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet rs = null;
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (choose == 1) {
                    String sql = "SELECT  ROWNUM R,E.F_NAME as e_l,\n"
                            + "       E.L_NAME as e_L,\n"
                            + "       E.card_number as E_card_number,\n"
                            + "       R.F_NAME ,\n"
                            + "       R.L_NAME,\n"
                            + "       R.CARD_NUMBER ,\n"
                            + "       B.ISBN,\n"
                            + "       B.TITLE,\n"
                            + "       GBB.DATA_DATE\n"
                            + "  FROM GIVE_BACK_BOOK GBB\n"
                            + "       INNER JOIN EMPLOYEE E\n"
                            + "          ON E.ID = GBB.EMPLOYEE_ID\n"
                            + "       INNER JOIN READER R\n"
                            + "          ON R.ID = GBB.READER_ID\n"
                            + "       INNER JOIN BOOK B\n"
                            + "          ON B.ID = GBB.BOOK_ID\n"
                            + " WHERE     GBB.ACTIVE = 1\n"
                            + "       AND GBB.DATA_DATE >= TO_DATE ('" + new java.sql.Date(df.parse(time1).getTime()) + "', 'yyyy-MM-dd')\n"
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
                        employee.setFirstName(rs.getString("e_l"));
                        employee.setLastName(rs.getString("e_L"));
                        employee.setCardNumber(rs.getString("E_card_number"));
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
                            + "  FROM GIVE_BACK_BOOK GBB\n"
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
                            + "       E.L_NAME as l,\n"
                            + "       E.card_number as c,\n"
                            + "       R.F_NAME,\n"
                            + "       R.L_NAME,\n"
                            + "       R.CARD_NUMBER,\n"
                            + "       B.ISBN,\n"
                            + "       B.TITLE,\n"
                            + "       GBB.DATA_DATE\n"
                            + "  FROM GIVE_BACK_BOOK GBB\n"
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

}
