package com.learning.designpatterns.creational.factory;

public class SessionCreatorFactory {
    public static SessionCreator getSessionCreator(String databaseType) {
        switch (databaseType.toLowerCase()) {
            case "mysql":
                return new MySQLSessionCreator();
            case "postgresql":
                return new PostgreSQLSessionCreator();
            default:
                throw new IllegalArgumentException("Unsupported database type");
        }
    }
}
