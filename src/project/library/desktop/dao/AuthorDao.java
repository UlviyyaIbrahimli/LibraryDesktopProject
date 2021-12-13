package project.library.desktop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.library.desktop.Util;
import project.library.desktop.dao.interfaces.IAuthor;
import project.library.desktop.model.Author;
import project.library.desktop.model.Book;
import project.library.desktop.model.Subjects;

/**
 *
 * @ Ulviyye Ibrahimli
 */
public class AuthorDao implements IAuthor {

    @Override
    public List<Author> getAuthorList() throws Exception {
        List<Author> authorList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROW_NUMBER() OVER (ORDER BY A.f_NAME ASC) AS r,  A.ID,\n"
                + "         A.F_NAME,\n"
                + "         A.L_NAME,\n"
                + "         A.FATHER_NAME,\n"
                + "         A.DOB,\n"
                + "         A.DEAD_DATE,\n"
                + "         A.GENDER,\n"
                + "         A.NATIONALITY,\n"
                + "         A.AUTHOR_INFO,\n"
                + "         A.REWARD,\n"
                + "         LISTAGG (TO_CHAR (S.SUBJECT_NAME), ', ')\n"
                + "            WITHIN GROUP (ORDER BY TO_CHAR (S.SUBJECT_NAME))\n"
                + "            AS SUBJECT_NAME,\n"
                + "         LISTAGG (TO_CHAR (B.TITLE), ', ')\n"
                + "            WITHIN GROUP (ORDER BY TO_CHAR (b.title))\n"
                + "            AS book\n"
                + "    FROM book_author ba\n"
                + "         right JOIN author a\n"
                + "            ON A.ID = BA.AUTHOR_ID\n"
                + "         LEFT JOIN book b\n"
                + "            ON B.ID = BA.BOOK_ID\n"
                + "         LEFT JOIN author_subject ass\n"
                + "            ON a.ID = ass.author_id\n"
                + "         LEFT JOIN subjects s\n"
                + "            ON s.id = ass.subject_id\n"
                + "   WHERE A.ACTIVE = 1 \n"
                + "GROUP BY A.ID,\n"
                + "         A.F_NAME,\n"
                + "         A.L_NAME,\n"
                + "         A.FATHER_NAME,\n"
                + "         A.DOB,\n"
                + "         A.DEAD_DATE,\n"
                + "         A.GENDER,\n"
                + "         A.NATIONALITY,\n"
                + "         A.AUTHOR_INFO,\n"
                + "         A.REWARD";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Author author = new Author();
                    author.setId(rs.getLong("Id"));
                    author.setNumber(rs.getLong("r"));
                    author.setFirstName(rs.getString("F_NAME"));
                    author.setLastName(rs.getString("l_name"));
                    author.setFatherName(rs.getString("FATHER_NAME"));
                    author.setNationality(rs.getString("NATIONALITY"));
                    author.setDob(rs.getDate("Dob"));
                    author.setDeadDate(rs.getDate("DEAD_DATE"));
                    author.setGender(rs.getString("Gender"));
                    author.setReward(rs.getString("Reward"));
                    author.setAuthorInfo(rs.getString("AUTHOR_INFO"));
                    Subjects subjects = new Subjects();
                    subjects.setSubjectName(rs.getString("Subject_name"));
                    author.setSubjects(subjects);
                    Book book = new Book();
                    book.setTitle(rs.getString("book"));
                    author.setBook(book);
                    authorList.add(author);

                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return authorList;
    }

    @Override
    public boolean addAuthor(Author author) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (author.getDob() != null && author.getDeadDate() != null) {
                    String sql1 = "INSERT INTO AUTHOR (ID,F_NAME,l_NAME,FATHER_NAME,GENDER,DOB,DEAD_DATE,NATIONALITY,REWARD,AUTHOR_INFO)"
                            + "values(author_seq.nextval,?,?,?,?,?,?,?,?,?)";
                    ps = c.prepareCall(sql1);
                    ps.setString(1, author.getFirstName());
                    ps.setString(2, author.getLastName());
                    ps.setString(3, author.getFatherName());
                    ps.setString(4, author.getGender());
                    ps.setDate(5, new java.sql.Date(author.getDob().getTime()));
                    ps.setDate(6, new java.sql.Date(author.getDeadDate().getTime()));
                    ps.setString(7, author.getNationality());
                    ps.setString(8, author.getReward());
                    ps.setString(9, author.getAuthorInfo());
                    ps.execute();
                    System.out.println("gbfb ");
                    result = true;
                } else if (author.getDob() != null && author.getDeadDate() == null) {
                    String sql1 = "INSERT INTO AUTHOR (ID,F_NAME,l_NAME,FATHER_NAME,GENDER,DOB,NATIONALITY,REWARD,AUTHOR_INFO)"
                            + "values(author_seq.nextval,?,?,?,?,?,?,?,?)";
                    ps = c.prepareCall(sql1);
                    ps.setString(1, author.getFirstName());
                    ps.setString(2, author.getLastName());
                    ps.setString(3, author.getFatherName());
                    ps.setString(4, author.getGender());
                    ps.setDate(5, new java.sql.Date(author.getDob().getTime()));
                    ps.setString(6, author.getNationality());
                    ps.setString(7, author.getReward());
                    ps.setString(8, author.getAuthorInfo());
                    ps.execute();
                    result = true;
                } else if (author.getDob() == null && author.getDeadDate() != null) {
                    String sql1 = "INSERT INTO AUTHOR (ID,F_NAME,l_NAME,FATHER_NAME,GENDER,DEAD_DATE,NATIONALITY,REWARD,AUTHOR_INFO)"
                            + "values(author_seq.nextval,?,?,?,?,?,?,?,?)";
                    ps = c.prepareCall(sql1);
                    ps.setString(1, author.getFirstName());
                    ps.setString(2, author.getLastName());
                    ps.setString(3, author.getFatherName());
                    ps.setString(4, author.getGender());
                    ps.setDate(5, new java.sql.Date(author.getDeadDate().getTime()));
                    ps.setString(6, author.getNationality());
                    ps.setString(7, author.getReward());
                    ps.setString(8, author.getAuthorInfo());
                    ps.execute();
                    result = true;
                } else if (author.getDob() == null && author.getDeadDate() == null) {
                    String sql1 = "INSERT INTO AUTHOR (ID,F_NAME,l_NAME,FATHER_NAME,GENDER,NATIONALITY,REWARD,AUTHOR_INFO)"
                            + " values(author_seq.nextval,?,?,?,?,?,?,?)";
                    ps = c.prepareCall(sql1);
                    ps.setString(1, author.getFirstName());
                    ps.setString(2, author.getLastName());
                    ps.setString(3, author.getFatherName());
                    ps.setString(4, author.getGender());
                    ps.setString(5, author.getNationality());
                    ps.setString(6, author.getReward());
                    ps.setString(7, author.getAuthorInfo());
                    System.out.println("bevegege");
                    ps.execute();
                    result = true;
                }

            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean updateAuthor(Long id, Author author) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (author.getDob() != null && author.getDeadDate() != null) {
                    String sql1 = "update  AUTHOR set F_NAME=?,l_NAME=?,FATHER_NAME=?,GENDER=?,DOB=?,DEAD_DATE=?,NATIONALITY=?,REWARD=?,AUTHOR_INFO=? where id=?";
                    ps = c.prepareCall(sql1);
                    ps.setString(1, author.getFirstName());
                    ps.setString(2, author.getLastName());
                    ps.setString(3, author.getFatherName());
                    ps.setString(4, author.getGender());
                    ps.setDate(5, new java.sql.Date(author.getDob().getTime()));
                    ps.setDate(6, new java.sql.Date(author.getDeadDate().getTime()));
                    ps.setString(7, author.getNationality());
                    ps.setString(8, author.getReward());
                    ps.setString(9, author.getAuthorInfo());
                    ps.setLong(10, id);
                    ps.execute();
                    result = true;
                } else if (author.getDob() != null && author.getDeadDate() == null) {
                    String sql1 = "update  AUTHOR set F_NAME=?,l_NAME=?,FATHER_NAME=?,GENDER=?,DOB=?,NATIONALITY=?,REWARD=?,AUTHOR_INFO=? where id=?";
                    ps = c.prepareCall(sql1);
                    ps.setString(1, author.getFirstName());
                    ps.setString(2, author.getLastName());
                    ps.setString(3, author.getFatherName());
                    ps.setString(4, author.getGender());
                    ps.setDate(5, new java.sql.Date(author.getDob().getTime()));
                    ps.setString(6, author.getNationality());
                    ps.setString(7, author.getReward());
                    ps.setString(8, author.getAuthorInfo());
                    ps.setLong(9, id);
                    ps.execute();
                    result = true;
                } else if (author.getDob() == null && author.getDeadDate() != null) {
                    String sql1 = "update  AUTHOR set F_NAME=?,l_NAME=?,FATHER_NAME=?,GENDER=?,DEAD_DATE=?,NATIONALITY=?,REWARD=?,AUTHOR_INFO=? where id=?";
                    ps = c.prepareCall(sql1);
                    ps.setString(1, author.getFirstName());
                    ps.setString(2, author.getLastName());
                    ps.setString(3, author.getFatherName());
                    ps.setString(4, author.getGender());
                    ps.setDate(7, new java.sql.Date(author.getDeadDate().getTime()));
                    ps.setString(8, author.getNationality());
                    ps.setString(9, author.getReward());
                    ps.setString(10, author.getAuthorInfo());
                    ps.setLong(11, id);
                    ps.execute();
                    result = true;
                } else if (author.getDob() == null && author.getDeadDate() == null) {
                    String sql1 = "update  AUTHOR set F_NAME=?,l_NAME=?,FATHER_NAME=?,GENDER=?,NATIONALITY=?,REWARD=?,AUTHOR_INFO=? where id=?";
                    ps = c.prepareCall(sql1);
                    ps.setString(1, author.getFirstName());
                    ps.setString(2, author.getLastName());
                    ps.setString(3, author.getFatherName());
                    ps.setString(4, author.getGender());
                    ps.setString(5, author.getNationality());
                    ps.setString(6, author.getReward());
                    ps.setString(7, author.getAuthorInfo());
                    ps.setLong(8, id);
                    ps.execute();
                    result = true;
                }
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
    public Author getAuthorById(Long id) throws Exception {
        Author author = new Author();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT A.ID,\n"
                + "       A.F_NAME,\n"
                + "       A.L_NAME,\n"
                + "       A.FATHER_NAME,\n"
                + "       A.DOB,\n"
                + "       A.DEAD_DATE,\n"
                + "       A.GENDER,\n"
                + "       A.NATIONALITY,\n"
                + "       A.AUTHOR_INFO,\n"
                + "       A.REWARD,\n"
                + "       S.id,\n"
                + "       S.SUBJECT_NAME,\n"
                + "       B.TITLE,\n"
                + "       B.id\n"
                + "  FROM book_author ba\n"
                + "       FULL JOIN author a\n"
                + "          ON A.ID = BA.AUTHOR_ID\n"
                + "       LEFT JOIN book b\n"
                + "          ON B.ID = BA.BOOK_ID\n"
                + "       FULL JOIN author_subject ass\n"
                + "          ON ass.author_id = a.id\n"
                + "       LEFT JOIN subjects s\n"
                + "          ON S.ID = ass.subject_id\n"
                + " WHERE a.id = ?";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                rs = ps.executeQuery();
                if (rs.next()) {
                    author.setFirstName(rs.getString("F_NAME"));
                    author.setLastName(rs.getString("L_name"));
                    author.setFatherName(rs.getString("FATHER_NAME"));
                    author.setNationality(rs.getString("NATIONALITY"));
                    author.setDob(rs.getDate("Dob"));
                    author.setDeadDate(rs.getDate("DEAD_DATE"));
                    author.setGender(rs.getString("Gender"));
                    author.setReward(rs.getString("Reward"));
                    author.setAuthorInfo(rs.getString("AUTHOR_INFO"));
                    Subjects subjects = new Subjects();
                    subjects.setSubjectName(rs.getString("Subject_name"));
                    subjects.setId(rs.getLong("id"));
                    author.setSubjects(subjects);
                    Book book = new Book();
                    book.setTitle(rs.getString("Title"));
                    book.setId(rs.getLong("id"));
                    author.setBook(book);

                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }
        return author;
    }

    @Override
    public boolean deleteAuthor(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql1 = "update  AUTHOR set active=0 where id=?";
        String sql2 = "update  book_author set active=0 where  author_id=? ";
        String sql3 = "update  author_subject  set active=0 where author_id=?  ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareCall(sql1);
                ps.setLong(1, id);
                ps.execute();
                ps = c.prepareStatement(sql2);
                ps.setLong(1, id);
                ps.execute();
                ps = c.prepareStatement(sql3);
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
    public boolean addAuthorBook(Long authorId, Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;

        String sql = "insert into book_author(id,book_id,author_id)values(book_author_seq.nextval,?,?)";

        try {
            c = DbHelper.getConnection();
            if (c != null) {

                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.setLong(2, authorId);
                ps.addBatch();
                ps.executeBatch();
                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return result;
    }

    @Override
    public List<Author> getAuthorBySubject(String name) throws Exception {
        List<Author> getAuthotList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT A.ID,\n"
                + "       A.F_NAME,\n"
                + "       A.L_NAME,\n"
                + "       A.FATHER_NAME\n"
                + "  FROM AUTHOR_SUBJECT ASS\n"
                + "       INNER JOIN SUBJECTS S\n"
                + "          ON S.ID = ASS.SUBJECT_ID\n"
                + "       INNER JOIN AUTHOR A\n"
                + "          ON A.ID = ASS.AUTHOR_ID\n"
                + " WHERE A.ACTIVE = 1 AND S.subject_name = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, name);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Author author = new Author();
                    author.setId(rs.getLong("id"));
                    author.setFirstName(rs.getString("F_name"));
                    author.setLastName(rs.getString("L_name"));
                    author.setFatherName(rs.getString("Father_name"));
                    getAuthotList.add(author);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return getAuthotList;
    }

    @Override
    public boolean addAuthorBooks(Long book, Long author) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql2 = "insert into book_author(id,book_id,author_id)values(book_author_seq.nextval,?,?)";
        try {

            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql2);
                ps.setLong(1, book);
                ps.setLong(2, author);
                ps.addBatch();
                ps.executeBatch();

                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return result;
    }

    @Override
    public Long addbookId(Author author) throws Exception {
        Long result = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql2 = "Select  max(id) as maxid from   author";// bunun islemesi ucun cevdelde en azi 1 row olmalidi!!

        try {

            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql2);
                rs = ps.executeQuery();
                while (rs.next()) {
                    result = rs.getLong("maxid");
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean addListSubject(Long authorId, Long subjectId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "insert into author_subject(id,author_id,subject_id)values(author_subject_seq.nextval,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, authorId);
                ps.setLong(2, subjectId);
                ps.addBatch();
                ps.executeBatch();
                System.out.println("dtrhhhrh");
                result = true;
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return result;
    }

    @Override
    public List<Author> booksOfAuthor(Long authorId) throws Exception {
        List<Author> getBooksOfAuthor = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select  b.id,b.isbn,B.TITLE  from book_author ba inner join book b on b.id=BA.BOOK_ID\n"
                + "inner join author a  on a.id=BA.AUTHOR_ID where a.id=? and ba.active=1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, authorId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Author author = new Author();
                    Book book = new Book();
                    book.setId(rs.getLong("id"));
                    book.setIsbn(rs.getLong("isbn"));
                    book.setTitle(rs.getString("title"));
                    author.setBook(book);
                    getBooksOfAuthor.add(author);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return getBooksOfAuthor;
    }

    @Override
    public List<Author> bookNoAuthor(Long id) throws Exception {
        List<Author> getBooksOfAuthor = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT distinct b.id, B.TITLE,b.isbn from\n"
                + "    book_author ba     \n"
                + "       INNER JOIN book b\n"
                + "          ON b.id = BA.BOOK_ID\n"
                + "       INNER JOIN author a\n"
                + "          ON a.id = BA.AUTHOR_ID\n"
                + " WHERE a.id != ? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Author author = new Author();
                    Book book = new Book();
                    book.setId(rs.getLong("id"));
                    book.setIsbn(rs.getLong("isbn"));
                    book.setTitle(rs.getString("title"));
                    author.setBook(book);
                    getBooksOfAuthor.add(author);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return getBooksOfAuthor;
    }

    @Override
    public List<Author> subjectofAuthor(Long id) throws Exception {
        List<Author> getBooksOfAuthor = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT S.ID, S.SUBJECT_NAME\n"
                + "  FROM author_subject ass\n"
                + "       INNER JOIN author a\n"
                + "          ON a.id = ASS.AUTHOR_ID\n"
                + "       INNER JOIN subjects s\n"
                + "          ON S.ID = ASS.SUBJECT_ID\n"
                + " WHERE a.id = ? and ass.active=1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Author author = new Author();
                    Subjects subjects = new Subjects();
                    subjects.setId(rs.getLong("id"));
                    subjects.setSubjectName(rs.getString("SUBJECT_NAME"));
                    author.setSubjects(subjects);
                    getBooksOfAuthor.add(author);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return getBooksOfAuthor;
    }

    @Override
    public boolean updateBookOfAuthor(Long bookId, Long authorId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql2 = "update  book_author set book_id=? where author_id=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {

                ps = c.prepareStatement(sql2);
                ps.setLong(1, bookId);
                ps.setLong(2, authorId);
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
    public boolean updateSubjectOfAuthor(Long subjectId, Long authorId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql2 = "update  author_subject set subject_id=? where author_id=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql2);
                ps.setLong(1, subjectId);
                ps.setLong(2, authorId);
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
    public List<Long> getBookId(Long authorId) throws Exception {
        List<Long> results = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql2 = "select  BA.BOOK_ID from book_author ba where BA.AUTHOR_ID=? and ba.active=1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql2);
                ps.setLong(1, authorId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Long result = rs.getLong("BOOK_ID");
                    results.add(result);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return results;
    }

    @Override
    public boolean deleteBookOfAuthor(Long authorId, Long bookId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql2 = " update book_author ba set active=0 where BA.AUTHOR_ID=? and BA.BOOK_ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql2);
                ps.setLong(1, authorId);
                ps.setLong(2, bookId);
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
    public boolean deleteSubject(Long authorId, Long subjectId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql2 = " update  author_subject ass set active=0 where ASS.AUTHOR_ID=? and ASS.SUBJECT_ID=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql2);
                ps.setLong(1, authorId);
                ps.setLong(2, subjectId);
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
    public List<Author> getSubjectByAuthor(Long subjectId) throws Exception {
        List<Author> getAuthotList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,\n"
                + "       A.ID,\n"
                + "       A.F_NAME,\n"
                + "       A.L_NAME,\n"
                + "       A.Father_NAME,\n"
                + "       a.SUBJECT_NAME\n"
                + "  FROM (  SELECT DISTINCT A.ID,\n"
                + "                          A.F_NAME,\n"
                + "                          A.L_NAME,\n"
                + "                          A.Father_NAME,\n"
                + "                          S.SUBJECT_NAME\n"
                + "            FROM author_subject ass\n"
                + "                 INNER JOIN subjects s\n"
                + "                    ON s.id = ASS.SUBJECT_ID\n"
                + "                 INNER JOIN author a\n"
                + "                    ON a.id = ASS.AUTHOR_ID\n"
                + "           WHERE ASS.SUBJECT_ID = ? AND a.active = 1\n"
                + "        ORDER BY s.SUBJECT_NAME desc) a";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, subjectId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Author author = new Author();
                    author.setId(rs.getLong("id"));
                    author.setNumber(rs.getLong("r"));
                    author.setFirstName(rs.getString("F_name"));
                    author.setLastName(rs.getString("L_name"));
                    author.setFatherName(rs.getString("Father_name"));
                    Subjects subjects = new Subjects();
                    subjects.setSubjectName(rs.getString("SUBJECT_NAME"));
                    author.setSubjects(subjects);
                    getAuthotList.add(author);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(c, ps, rs);
        }

        return getAuthotList;
    }

    @Override
    public boolean deleteAuthorForSubject(Long authorId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "update  author_subject  set active=0 where subject_id=?  ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareCall(sql);
                ps.setLong(1, authorId);
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
    public List<Author> booksOfAuthorActiveZero(Long authorId) throws Exception {
        List<Author> getBooksOfAuthor = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,\n"
                + "       d.id,\n"
                + "       d.isbn,\n"
                + "       d.TITLE,\n"
                + "       d.f_name,\n"
                + "       d.l_name\n"
                + "  FROM (SELECT DISTINCT b.id,\n"
                + "                        b.isbn,\n"
                + "                        B.TITLE,\n"
                + "                        a.f_name,\n"
                + "                        a.l_name\n"
                + "          FROM book_author ba\n"
                + "               INNER JOIN book b\n"
                + "                  ON b.id = BA.BOOK_ID\n"
                + "               INNER JOIN author a\n"
                + "                  ON a.id = BA.AUTHOR_ID\n"
                + "         WHERE a.id = ? AND ba.active = 0) d";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, authorId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Author author = new Author();
                    Book book = new Book();
                    book.setId(rs.getLong("id"));
                    book.setNumber(rs.getLong("r"));
                    book.setIsbn(rs.getLong("isbn"));
                    book.setTitle(rs.getString("title"));
                    author.setFirstName(rs.getString("f_name"));
                    author.setLastName(rs.getString("l_name"));
                    author.setBook(book);
                    getBooksOfAuthor.add(author);
                }
            } else {
                System.out.println("Connection error!");
            }
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        } finally {
            c.commit();
            Util.closeConnection(c, ps, null);
        }
        return getBooksOfAuthor;
    }

}
