package com.learning.designpatterns.behavioral.chainofresponsibility;

public class PasswordVerificationHandler extends BaseHandler{
    private Database database;

    public PasswordVerificationHandler(Database database){
        this.database = database;
    }

    @Override
    public boolean handleRequest(String username, String password) {
        if(!database.isValidPassword(username, password)){
            // write error to log and execute some custom logic
            return false;
        }
        return handleNext(username, password);
    }
}
