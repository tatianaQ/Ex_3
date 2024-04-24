package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class Util {
    private static SessionFactory sessionFactory;
    private static final String URL1 = "jdbc:mysql://localhost:3306/test1";
    private static final String URL2 = "jdbc:mysql://localhost:3306/test2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .addAnnotatedClass(User.class)
                        .setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver")
                        .setProperty(Environment.URL, URL2)
                        .setProperty(Environment.USER, USERNAME)
                        .setProperty(Environment.PASS, PASSWORD)
                        .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect")
                        .setProperty(Environment.SHOW_SQL, "true")
                        .setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread")
                        .setProperty(Environment.HBM2DDL_AUTO, "")
                        .setProperty(Environment.AUTOCOMMIT, "true");

                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                registryBuilder.applySettings(configuration.getProperties());
                ServiceRegistry serviceRegistry = registryBuilder.build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL1, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return connection;
    }
}
