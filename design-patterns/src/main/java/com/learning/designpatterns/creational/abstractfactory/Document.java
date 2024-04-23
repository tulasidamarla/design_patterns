package com.learning.designpatterns.creational.abstractfactory;

public interface Document {
  String getTitle();
  String setTitle(String title);
  String getContent();
  String setContent(String content);
  void save();
}
