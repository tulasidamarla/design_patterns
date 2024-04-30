package com.learning.designpatterns.behavioral.chainofresponsibility;

import java.util.logging.Handler;

public class Test {
    public static void main(String[] args) {
        Database db = new Database();
        BaseHandler handler = new UserVerificationHandler(db)
                .setNextHandler(new PasswordVerificationHandler(db))
                .setNextHandler(new RoleVerificationHandler());
        AuthService service = new AuthService(handler);
        service.login("admin", "admin");
    }
}