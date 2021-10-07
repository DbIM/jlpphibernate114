package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

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
        String sql = "INSERT INTO jlpp.user ( name, lastName, age) VALUES (?, ?, ?) ;\n";
        Util connect = new Util();
        try {
            PreparedStatement statement = connect.Util().prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных ");
            connect.Util().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM jlpp.user WHERE id= ?";
        Util connect = new Util();
        try {
            PreparedStatement statement = connect.Util().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("User с id – " + id + " был удален.");
            connect.Util().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM jlpp.user;";
        Util connect = new Util();
        List<User> userList = new ArrayList();
        try {
            Statement statement = connect.Util().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            int index = 0;
            while (result.next()) {
                String name = result.getString(2);
                String lastName = result.getString(3);
                Byte age = Byte.valueOf(result.getString(4));
                User user = new User(name, lastName, age);
                userList.add(index, user);
                System.out.println(user.getName() + " " + user.getLastName() + " " + user.getAge());
                index++;
            }
            connect.Util().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
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
