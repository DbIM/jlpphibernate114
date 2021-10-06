package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static UserServiceImpl userServiceImpl = new UserServiceImpl();


    public static void main(String[] args) {
        // создание таблицы
        userServiceImpl.createUsersTable();

        //создание пользователей
        User bilbo = new User("Bilbo", "Baggins", (byte) 150);
        User frodo = new User("Frodo", "Baggins", (byte) 60);
        User sam = new User("Samwise", "Ganja", (byte) 65);
        User gandalf = new User("Gandalf", "White", (byte) 999);

        //добавление пользователей
        userServiceImpl.saveUser(bilbo.getName(), bilbo.getLastName(), bilbo.getAge());
        userServiceImpl.saveUser(frodo.getName(), frodo.getLastName(), frodo.getAge());
        userServiceImpl.saveUser(sam.getName(), sam.getLastName(), sam.getAge());
        userServiceImpl.saveUser(gandalf.getName(), gandalf.getLastName(), gandalf.getAge());

        //вывод пользователей
        userServiceImpl.getAllUsers();

        //очистка таблицы
        userServiceImpl.cleanUsersTable();

        //удаление таблицы
        userServiceImpl.dropUsersTable();

    }
}
