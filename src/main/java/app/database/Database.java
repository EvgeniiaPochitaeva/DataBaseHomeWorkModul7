package app.database;

import app.prefs.Prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database() {
        try {
            String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
            connection = DriverManager.getConnection(connectionUrl);

        } catch (Exception ex) {
            ex.printStackTrace();
            }

    }
    public static Database getInstance() {
        return INSTANCE;
    }
    public int executeUpdate(String sql) {
        try (Statement st = connection.createStatement()){
         return st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
                Connection conn = Database.getInstance().getConnection();
    }


}
