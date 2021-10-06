package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {
        //удаление таблицы
        userServiceImpl.dropUsersTable();

        // создание таблицы
        userServiceImpl.createUsersTable();

        final String testName = "Bilbo";
        final String testLastName = "Baggins";
        final byte testAge = 60;

        //создание пользователей
        User bilbo = new User(testName, testLastName, testAge);
        User frodo = new User("Frodo", "Baggins", (byte) 30);
        User sam = new User("Samwise", "Ganja", (byte) 35);
        User gandalf = new User("Gandalf", "White", (byte) 99);

        //добавление пользователей
        userServiceImpl.saveUser(bilbo.getName(), bilbo.getLastName(), bilbo.getAge());
        userServiceImpl.saveUser(frodo.getName(), frodo.getLastName(), frodo.getAge());
        userServiceImpl.saveUser(sam.getName(), sam.getLastName(), sam.getAge());
        userServiceImpl.saveUser(gandalf.getName(), gandalf.getLastName(), gandalf.getAge());

        //вывод пользователей
        userServiceImpl.getAllUsers();

        //вывод одного пользователя
        User user = userServiceImpl.getAllUsers().get(0);
        System.out.println(user.getName());

        //очистка таблицы
        userServiceImpl.cleanUsersTable();

        //удаление таблицы
        //userServiceImpl.dropUsersTable();

    }
}
