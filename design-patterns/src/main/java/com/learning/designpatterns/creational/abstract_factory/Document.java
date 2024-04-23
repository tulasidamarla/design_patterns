package com.learning.designpatterns.creational.abstract_factory;

public interface Document {
  String getTitle();
  String setTitle(String title);
  String getContent();
  String setContent(String content);
  void save();
}
