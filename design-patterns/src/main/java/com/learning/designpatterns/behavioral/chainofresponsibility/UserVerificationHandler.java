package com.learning.designpatterns.behavioral.chainofresponsibility;

public class UserVerificationHandler extends BaseHandler{
    private Database database;

    public UserVerificationHandler(Database database){
        this.database = database;
    }

    @Override
    public boolean handleRequest(String username, String password) {
        if(!database.isValidUser(username)){
            // write error to log
            return false;
        }
        return handleNext(username, password);
    }
}
