package com.learning.designpatterns.creational.abstract_factory;

public interface ContentFactory {
    Document createDocument(String type);
    Chart createChart(String type);
}
