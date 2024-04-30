package com.learning.designpatterns.behavioral.chainofresponsibility;

public class RoleVerificationHandler extends BaseHandler{

    @Override
    public boolean handleRequest(String username, String password) {
        if("admin".equals(username)){
            // Fetch specific permissions related to admin
            System.out.println("Loading admin page");
            return handleNext(username, password);
        }
        System.out.println("loading home page");
        return handleNext(username, password);
    }
}
