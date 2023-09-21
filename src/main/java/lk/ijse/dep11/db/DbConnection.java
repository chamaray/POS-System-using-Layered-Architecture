package lk.ijse.dep11.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private Connection connection;

    DbConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pos","root","13823Textile?");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  static DbConnection getInstance(){
        if(dbConnection == null){
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
