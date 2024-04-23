package com.learning.designpatterns.creational.abstractfactory;


public class ReportDocument implements Document{

    @Override
    public String getTitle() {
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }

    @Override
    public String getContent() {
        throw new UnsupportedOperationException("Unimplemented method 'getContent'");
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public String setTitle(String title) {
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }

    @Override
    public String setContent(String content) {
        throw new UnsupportedOperationException("Unimplemented method 'setContent'");
    }
    
}
