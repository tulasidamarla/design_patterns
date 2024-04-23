package com.learning.designpatterns.creational.abstract_factory;

import java.util.List;

public interface Chart {
  List<Double> getData();
  void setData(List<Double> data);
  String getType();
  void generateImage();
}
