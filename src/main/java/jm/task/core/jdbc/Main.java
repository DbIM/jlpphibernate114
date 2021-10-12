package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {
        userServiceImpl.dropUsersTable();
        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("DAO Name", "DAO Last name", (byte)10);
        userServiceImpl.getAllUsers();
        userServiceImpl.cleanUsersTable();
    }
}
