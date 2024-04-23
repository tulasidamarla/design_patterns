package com.learning.designpatterns.creational.factory;

public class PostgreSQLSessionCreator implements SessionCreator{
    @Override
    public Session createSession() {
        // Hibernate configuration for PostgreSQL
        // StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        //         .configure("hibernate_postgresql.cfg.xml")
        //         .build();
        // return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return new Session();
    }
}
