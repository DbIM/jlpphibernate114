package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private String url = "jdbc:mysql://127.0.0.1:3306/jlpp?serverTimezone=UTC";
    private String user = "root";
    private String password = "1234567";

    public Connection Util() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            System.out.println("Connection wasn't established!");
        }
        return connection;
    }
}
