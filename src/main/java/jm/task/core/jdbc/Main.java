package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.dropUsersTable();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("DAO Name", "DAO Last name", (byte)10);
        userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();


    }
}
