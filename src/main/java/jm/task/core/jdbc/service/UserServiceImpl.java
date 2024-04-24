package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //    UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
    UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
        System.out.println("Таблица создана или уже существует");

    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
        System.out.println("Таблица удалена");
    }

    public void saveUser(String name, String lastName, byte age){
        userDao.saveUser(name, lastName, age);
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id){
        userDao.removeUserById(id);
        System.out.println("User c id № " + id + " удален!" );
    }

    public List<User> getAllUsers(){
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
        return users;
    }

    public void cleanUsersTable(){
        userDao.cleanUsersTable();
        System.out.println("Таблица очищена");
    }
}