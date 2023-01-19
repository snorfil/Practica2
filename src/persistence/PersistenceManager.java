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
        ArrayList<Actor> result = new ArrayList<>();
        try {
                Connection connection = getConnection();
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {

                    Actor actor = new Actor();
                        actor.setActor_id(rs.getInt("actor_id"));
                        actor.setFirst_name(rs.getString("first_name"));
                        actor.setLast_name(rs.getString("last_name"));
                        actor.setTimestamp(rs.getTimestamp("last_update"));
                    result.add(actor);
                    // Aquí obtiene los datos de la tabla
                }
                rs.close();
                st.close();
                connection.close();
            } catch (SQLException e) {
                return result;
            }
        return result;

    }


}
