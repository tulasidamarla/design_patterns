package com.learning.designpatterns.behavioral.chainofresponsibility;

import java.util.Objects;

public abstract class BaseHandler{
    private BaseHandler next;

    public BaseHandler setNextHandler(BaseHandler next){
        this.next = next;
        return next;
    }

    public abstract boolean handleRequest(String username, String password);

    protected boolean handleNext(String username, String password){
        if (Objects.nonNull(next)){
            return next.handleNext(username, password);
        }
        return true;
    }
}
