package com.learning.designpatterns.creational.factory;

public class MySQLSessionCreator implements SessionCreator {
    @Override
    public Session createSession() {
        // Hibernate configuration for MySQL
        // StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        //         .configure("hibernate_mysql.cfg.xml")
        //         .build();
        // return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return new Session();
    }
}
