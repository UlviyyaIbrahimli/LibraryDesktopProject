package project.library.desktop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Util {
    public static void    closeConnection(Connection c, PreparedStatement pr, ResultSet rs) throws Exception{
        if (c!=null)
        c.close();
        if (pr!=null)
        pr.close();
        if (rs!=null)
        rs.close();
    }
}
