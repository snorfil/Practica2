package persistence;

import datamodel.Actor;

import java.sql.*;
import java.util.ArrayList;

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


    public Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(url,user,pass);
        connection.setAutoCommit(true);
        return connection;
    }

    public ArrayList<Actor> getActor(){
        String query = "SELECT * FROM sakila.actor";
        try {
                Connection connection = getConnection();
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    // Aquí obtiene los datos de la tabla
                }
                rs.close();
                st.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


}
