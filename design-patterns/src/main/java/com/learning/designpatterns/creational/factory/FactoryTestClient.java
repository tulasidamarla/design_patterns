package com.learning.designpatterns.creational.factory;

public class FactoryTestClient {
    public static void main(String[] args) {
        // Creating SessionCreator using the factory
        SessionCreator sessionCreator = SessionCreatorFactory.getSessionCreator("mysql");
        Session mysqlSession = sessionCreator.createSession();
        
        // Use the mysqlSession to interact with MySQL database
        
        // Creating SessionCreator for PostgreSQL using the factory
        sessionCreator = SessionCreatorFactory.getSessionCreator("postgresql");
        Session postgresqlSession = sessionCreator.createSession();
        
        // Use the postgresqlSession to interact with PostgreSQL database
    }
}
