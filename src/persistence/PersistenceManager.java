package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersistenceManager {

    private String url = "jdbc:mysql://localhost:3306/sakila";
    private String user = "root";;
    private String pass = "root";;

    public PersistenceManager() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public Connection getConnection(String dbUrl,String user, String password) throws SQLException{
        Connection connection = DriverManager.getConnection(dbUrl,user,password);
        connection.setAutoCommit(true);
        return connection;
    }
    

}
