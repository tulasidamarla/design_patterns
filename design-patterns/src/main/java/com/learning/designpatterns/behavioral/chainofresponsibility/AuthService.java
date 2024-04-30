package com.learning.designpatterns.behavioral.chainofresponsibility;

public class AuthService {
    private BaseHandler handler;

    AuthService(BaseHandler handler){
        this.handler = handler;
    }

    public boolean login(String email, String password){
        if(handler.handleRequest(email, password)){
            // logic related to authenticated users
            return true;
        }
        return false;
    }


}
