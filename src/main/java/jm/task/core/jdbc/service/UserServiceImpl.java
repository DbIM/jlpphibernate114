package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS `jlpp`.`user` (\n" +
                "  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `name` TEXT NULL,\n" +
                "  `lastName` TEXT NULL,\n" +
                "  `age` INT NULL,\n" +
                "  PRIMARY KEY (`id`));\n";
        Util connect = new Util();
        try {
            PreparedStatement statement = connect.Util().prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Table CREATEd");
            connect.Util().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS jlpp.user;";
        Util connect = new Util();
        try {
            PreparedStatement statement = connect.Util().prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Table DROPed");
            connect.Util().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO jlpp.user ( name, lastname, age)\n" +
                "VALUES ('"+ name +"', '" + lastName + "', '" + age + "') ;\n";
        Util connect = new Util();
        try {
            PreparedStatement statement = connect.Util().prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных ");
            connect.Util().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM jlpp.user;";
        Util connect = new Util();
        try {
            Statement statement = connect.Util().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                System.out.println(result.getString(2));
            }
            connect.Util().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE jlpp.user;";
        Util connect = new Util();
        try {
            PreparedStatement statement = connect.Util().prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Table TRUNCATed");
            connect.Util().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
