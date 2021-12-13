package project.library.desktop.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Properties;

public class DbHelper {
    public  static Connection getConnection() throws Exception{
        Connection c=null;
        Locale.setDefault(Locale.ENGLISH);
        Properties properties=new Properties();
        properties.load(new FileReader("config.properties"));
        Class.forName(properties.getProperty("db.driver"));
       c= DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.userName"),properties.getProperty("db.password"));
        return c;
    }

}
