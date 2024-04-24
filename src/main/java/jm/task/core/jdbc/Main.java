package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService user = new UserServiceImpl();

        user.createUsersTable();
        user.saveUser("Таня", "Фамилия1", (byte) 43);
        user.saveUser("Аня", "Фамилия2", (byte) 44);
        user.saveUser("Саша", "Фамилия3", (byte) 5);
        user.saveUser("Маша", "Фамилия4", (byte) 8);
        user.saveUser("Коля", "Фамилия4", (byte) 8);
        user.removeUserById(5);
        user.getAllUsers();
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}