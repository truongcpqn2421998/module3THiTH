package library.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/module3library",
                        "root",
                        "Truong@167294385");
                System.out.println("thanh cong");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("that bai");
            }
        }
        return connection;
    }
}
