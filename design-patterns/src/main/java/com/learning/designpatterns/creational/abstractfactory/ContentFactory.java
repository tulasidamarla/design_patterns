package com.learning.designpatterns.creational.abstractfactory;

public interface ContentFactory {
    Document createDocument(String type);
    Chart createChart(String type);
}
